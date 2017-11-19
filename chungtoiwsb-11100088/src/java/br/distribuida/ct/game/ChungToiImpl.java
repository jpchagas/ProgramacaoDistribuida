/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.distribuida.ct.game;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import br.distribuida.ct.enums.*;
import br.distribuida.ct.model.*;

/**
 *
 * @author joao
 */
public class ChungToiImpl implements ChungToiInterface {

	private static final long serialVersionUID = 1234L;
	private static final int numMaxPartidas = 500;
	private static final int numMaxPlayers = 1000;
	private ArrayList<ChungToi> partidas;
        private ArrayList<ChungToi> prePartidas;
	private ArrayList<Player> players;
        private ArrayList<Player> prePlayers;
	private int id = 0;
	private ArrayList<Player> aguardando;
		
	
	public ChungToiImpl() {
		partidas = new ArrayList<ChungToi>(numMaxPartidas);
		players = new ArrayList<Player>(numMaxPlayers);
                prePartidas = new ArrayList<ChungToi>(numMaxPartidas);
		prePlayers = new ArrayList<Player>(numMaxPlayers);
                aguardando = new ArrayList<Player>(numMaxPlayers);
	}
	
	@Override
	public int preRegistro(String nome1, int id1, String nome2, int id2 ) {
            //System.out.print("Efetuando Pré Registro");
            Player p1 = new Player(id1, nome1);
            //System.out.print("Pré Registrando Jogador " +p1.toString());
            Player p2 =  new Player(id2, nome2);
            //System.out.print("Pré Registrando Jogador " +p2.toString());
            prePlayers.add(p1);
            prePlayers.add(p2);
            ChungToi ct = new ChungToi();
            ct.setP1(p1);
            ct.setP2(p2);
            //System.out.print("Pré Registrando Partida" + ct.toString());
            prePartidas.add(ct);
            return 0;
	}
        
        public Player meuPreAdversario(Player p){
            Player r = null;
            for (ChungToi partida : prePartidas) {
                if (partida.getP1().getId()==p.getId()) r=partida.getP2();
                if (partida.getP2().getId()==p.getId()) r=partida.getP1();
            }
            return r;
        }
        
        public boolean ehMeuPreAdversarioNoAguarde(Player eu){
            boolean r = false;
            for (Player p : aguardando) {
                if (p.getId()==meuPreAdversario(eu).getId()) r=true;
            }
            return r;
        }
        
        public void entraNaPartidaExistente(Player eu){
            ChungToi aux = null;
            for (ChungToi partida : partidas) {
                if (partida.getP1().getId()==meuPreAdversario(eu).getId()){
                    partida.setP2(eu);
                    aux=partida;
                }
                
            }
                aux.setNumJogadores(aux.getNumJogadores()+1);
                aux.setPartidaNaoIniciada(false);
        }
        
        public void criarPartida(Player eu){
            ChungToi novaPartida  = new ChungToi();
            novaPartida.setP1(eu);
            novaPartida.setNumJogadores(novaPartida.getNumJogadores()+1);
            partidas.add(novaPartida);
        }
        
        public void removeFromAguardando(Player eu){
            int index = 0;
            for (Player p : aguardando) {
                if (p.getId()==eu.getId()) {
                    break;
                }
                index++;
            }
            aguardando.remove(index);
        }


	@Override
	public synchronized int registraJogador(String nome) {
            //System.out.print("Efetuando Registro");
            
            if (players.size()>=numMaxPlayers){
              //  System.out.println("Entrei no Erro de número máximo de usuários");
                return RespostasRegistraJogadorEnum.NumeroMaximoJogadoresAtingido.getValor();
            } else if(verificaNomeRepetido(nome)){
               // System.out.println("Entrei no Erro de usuário já cadastrado");
		return RespostasRegistraJogadorEnum.UsuárioJaCadastrado.getValor();
            }else if(getIdPlayerPre(nome)!=-99){
                Player newPlayer =  new Player(getIdPlayerPre(nome),nome);
               // System.out.print("Registrando Jogador a partir do pré registro " + newPlayer.toString());
                players.add(newPlayer);
                if(!(aguardando.isEmpty())){
                   // System.out.println("Aguardando não vazio");
                    if (ehMeuPreAdversarioNoAguarde(newPlayer)) {
                       // System.out.println("Aguardado é meu pré adversario");
                        entraNaPartidaExistente(newPlayer);
                        removeFromAguardando(meuPreAdversario(newPlayer));
                    }else{
                        //System.out.println("Aguardando não é meu pré adversario");
                        criarPartida(newPlayer);
                        aguardando.add(newPlayer);
                    }
                }else{
                   // System.out.println("Aguardando vázio");
                    criarPartida(newPlayer);
                    aguardando.add(newPlayer);
                }
		return getIdPlayerPre(nome);
            }else {
		int id = generateId();
		Player newPlayer =  new Player(id,nome);
                //verificar se existe alguem aguardando
                //se sim entrar na partida
                //se não criar partida e ficar aguardando
                //System.out.print("Registrando Jogador " +newPlayer.toString());
		players.add(newPlayer);
		return id;
            }
	}

	@Override
	public synchronized int encerraPartida(int id) {
            //System.out.print("Encerrado Partida");
            ChungToi ct = buscaPartidaJogador(id);
           
            if(ct.getNumJogadores()==2) {
		ct.setNumJogadores(ct.getNumJogadores()-1);
		ct.setPartidaEncerrada(true);
		return RespostasEncerraPartidaEnum.Ok.getValor();
            }else if(ct.getNumJogadores()==1){
		Player p1 = ct.getP1();
		Player p2 = ct.getP2();
		partidas.remove(ct);
		players.remove(p1);
		players.remove(p2);
		ct.setPartidaEncerrada(true);
		return RespostasEncerraPartidaEnum.Ok.getValor();
            }else {
		//erro
		return RespostasEncerraPartidaEnum.Erro.getValor();
            }
	}
        
        public Player getPlayerAguarde(int id){
            Player aux = null;
            for (Player p : aguardando) {
                if(p.getId()==id)aux = p;
            }
            return aux;
        }
        

//	@Override
//	public synchronized int temPartida(int id) {
//                System.out.print("Procurando Partida");
//		serverInfo();
//		if(aguardando.isEmpty() || aguardando.contains(getPlayer(id))) {
//			if(buscaPartidaJogador(id)!= null) {
//				return RespostasTemPartidaEnum.TemPartidaP1.getValor();
//			}else {
//				aguardando.add(getPlayer(id));
//				return RespostasTemPartidaEnum.AindaSemPartida.getValor();
//			}
//		}else if(!(aguardando.isEmpty()) && !aguardando.contains(getPlayer(id))) {
//			Player p1 = getPlayer(getPlayerAguarde(id).getId());
//			p1.setCor("c");
//			Player p2 = getPlayer(id);
//			p2.setCor("e");
//			ChungToi ct = new ChungToi(p1,p2);
//			partidas.add(ct);
//			aguardando.remove(p1);
//			ct.setPartidaNaoIniciada(false);
//			return RespostasTemPartidaEnum.TemPartidaP2.getValor();
//		}else {
//			return RespostasTemPartidaEnum.Erro.getValor();
//		}
//	}
        
        public boolean estouEmPartida(int id){
            boolean toNaPartida = false;
            for (ChungToi partida : partidas) {
                if(partida.jogadorNaPartida(id))toNaPartida=true;
            }
            return toNaPartida;
        }
        
        public boolean souP1(int id){
            boolean ehP1 = false;
            for (ChungToi partida : partidas) {
                if(partida.getP1().getId()==id){
                    ehP1=true;
                }
            }
            return ehP1;
        }
        
        public boolean souP2(int id){
            boolean ehP2 = false;
            for (ChungToi partida : partidas) {
                if(partida.getP2().getId()==id){
                    ehP2 = true;
                }
            }
            return ehP2;
        }
        
        @Override
	public synchronized int temPartida(int id) {
              //  System.out.print("Procurando Partida");
                Player aux = getPlayer(id);
                
                if(aguardando.contains(aux)){
                    return RespostasTemPartidaEnum.AindaSemPartida.getValor();
                }else if(!(aguardando.contains(aux))&& souP1(id)){
                    return RespostasTemPartidaEnum.TemPartidaP1.getValor();
                }else if(!(aguardando.contains(aux))&& souP2(id)){
                    return RespostasTemPartidaEnum.TemPartidaP2.getValor();
                }else{
                    return RespostasTemPartidaEnum.Erro.getValor();
                }
	}

	@Override
	public int ehMinhaVez(int id) {
            //System.out.print("Verificando Vez");
		ChungToi ct = buscaPartidaJogador(id);
		//int qual_player = ct.verificaPlayer(id);
		
		ct.vencedor();
                
		if(aguardando.contains(getPlayer(id))) {
			return RespostasMinhaVezEnum.NaoHaDoisJogadores.getValor();
		}else if(ct.getVencedor(id) && ct.isPartidaEncerrada()){
			return RespostasMinhaVezEnum.Vencedor.getValor();
		}else if(!(ct.getVencedor(id))&&ct.isPartidaEncerrada()){
			return RespostasMinhaVezEnum.Perdedor.getValor();
		}else if((ct.getP1().getId() == id && ct.getTurno()==1) || (ct.getP2().getId() == id && ct.getTurno()==2)){
			return RespostasMinhaVezEnum.Sim.getValor();
		}else if(ct.getP1().getId() == id && ct.getTurno()==2 || ct.getP2().getId() == id && ct.getTurno()==1){
			return RespostasMinhaVezEnum.Nao.getValor();
		}else if(false){
			return RespostasMinhaVezEnum.Empate.getValor();
		}else if(ct.isPartidaEncerrada() && ct.getVencedor(id)){
			return RespostasMinhaVezEnum.VencedorWO.getValor();
		}else if(ct.isPartidaEncerrada() && !(ct.getVencedor(id))){
			return RespostasMinhaVezEnum.PerdedorWO.getValor();
		}else {
			return RespostasMinhaVezEnum.Erro.getValor();
		}
	}
        
        public boolean estouAguardando(int id){
            boolean aguard = false;
            for (Player p : aguardando) {
                if(p.getId()==id)aguard=true;
            }
            return aguard;
        }
        
	@Override
	public String obtemOponente(int id) {
            //System.out.print("Obtendo oponente");
            String r = "";
            //serverInfo();
            //Busca se jogador tem partida
            ChungToi partida = buscaPartidaJogador(id);
            if (!(estouAguardando(id))) {
              //  System.out.println("Não estou em aguardo");
                r = partida.oponente(id);
            }else{
                //System.out.println("Estou em aguardo");
                r = "";
            }
            return r;
	}

	@Override
	/*
	 * Printa tabuleiro da partida do jogador
	 * 
	 * */
	public String obtemTabuleiro(int id) {
            //System.out.print("Obtendo Tabuleiro");
		//Busca se jogador tem partida
		ChungToi partida = buscaPartidaJogador(id);
		if(partida != null) {
			//Printa tabuleiro se tem partida
			return partida.printaTabuleiro();
		}
		//Retorna vazio se não tem partida
		return null;
	}

	@Override
	public int  posicionaPeca(int id, int pos, int orient) {
            //System.out.print("Posicionando Peça");
		ChungToi ct = buscaPartidaJogador(id);
		int my_player = ct.verificaPlayer(id);
		if(ct.isPartidaEncerrada()) {
			return RespostasPosicionaPecaEnum.PartidaEncerrada.getValor();
		
		}else if(ct.isPartidaNaoIniciada()) {
			return RespostasPosicionaPecaEnum.PartidaNaoIniciada.getValor();
		
		}else if(ehMinhaVez(id)==0){
			return RespostasPosicionaPecaEnum.NaoEVez.getValor();
			
		}else if(ct.validaParametrosPosicionaPeca(pos,orient)) {
			return RespostasPosicionaPecaEnum.ParametrosInvalidos.getValor();
			
		}else if(ct.validaPosicao(pos)) {
			return RespostasPosicionaPecaEnum.PosicaoOcupada.getValor();
                
                }else if((my_player==1 && ct.getPecasP1()==0) ||(my_player==2 && ct.getPecasP2()==0)) {
                    //TODO:
			return RespostasPosicionaPecaEnum.FasePosicionamentoEncerrada.getValor();
                        
                }else if(getPlayer(id)==null) {
                    //TODO:
			return RespostasPosicionaPecaEnum.JogadorNaoEncontrado.getValor();	
		}else {
                        if(my_player==1){
                            ct.setPecasP1(ct.getPecasP1()-1);
                        }else{
                            ct.setPecasP2(ct.getPecasP2()-1);
                        }
			ct.posiciona(pos, orient, id);
			ct.trocaTurno();
			return RespostasPosicionaPecaEnum.TudoCerto.getValor();
			
		}
	}

	@Override
	public int movePeca(int id, int pos,int sent, int numCasas, int orient) {
            //System.out.print("Movendo Peça");
		ChungToi ct = buscaPartidaJogador(id);
                int my_player = ct.verificaPlayer(id);
		if(ct.isPartidaEncerrada()) {
			return RespostasMovePecaEnum.PartidaEncerrada.getValor();
		
		}else if(ct.isPartidaNaoIniciada()) {
			return RespostasMovePecaEnum.PartidaNaoIniciada.getValor();
			
		}else if(ehMinhaVez(id)==0) {
			return RespostasMovePecaEnum.NaoEVez.getValor();
			
		}else if(ct.validaParametrosMovePeca(id,pos,sent, numCasas,orient)) {
                    System.out.println("Parâmetro Inválido");
                    return RespostasMovePecaEnum.ParametrosInvalidos.getValor();
			
		}else if(ct.validaMovimento(id,pos,sent, numCasas, orient)) {
                    System.out.println("Movimento Inválido");
                    return RespostasMovePecaEnum.MovimentoInvalido.getValor();
                
                }else if((my_player==1 && ct.getPecasP1()>0)||(my_player==2 && ct.getPecasP2()>0)) {
                    return RespostasMovePecaEnum.AindaNaoForamPosicionadas3Pecas.getValor();
                
                }else if(getPlayer(id)==null) {
                    return RespostasMovePecaEnum.JogadorNaoEncontrado.getValor();
				
		}else {
                    //System.out.println("Executando Movimento");
                    //System.out.println(id+" "+pos+" "+sent+" "+numCasas+" "+orient);
                    ct.move(id, pos, sent, numCasas, orient);
                    ct.trocaTurno();
                    return RespostasMovePecaEnum.TudoCerto.getValor();
		}
	}
	
	/*
	 * Funções auxiliares
	 * 
	 * 
	 * 
	 * */
	
	//Verifica se existe algum usuário com nome solicitado para cadastro
	private boolean verificaNomeRepetido(String nome) {
		boolean temNomeRepetido = false;
		for (Player p : players) {
			String pauxnome = p.getNome();
			if(pauxnome.equals(nome)) {
				temNomeRepetido = true;
			}else {
				temNomeRepetido = false;
			}
		}
		return temNomeRepetido;
	}
	
	//Gera  id para o usuário
	private int generateId(){
		id+=1;
		return id;
	}
	
	//Busca jogador na lista de jogadores
	private Player getPlayer(int id){
            Player pl = null;
		for (Player p : players) {
			if(p.getId() == id)pl= p;
		}
		return pl;
	}
        
        private int getIdPlayerPre(String nome){
            int userId = -99;
            for (Player p : prePlayers) {
			if(p.getNome().equals(nome))userId = p.getId();
		}
		return userId;
        }
        
        private boolean findPlayerById(int id){
            boolean findById = false;
            for (Player p : players) {
			if(p.getId()==id)findById = true;
		}
		return findById;
        }
        
        private boolean findPlayerByName(String nome){
            boolean findByName = false;
            for (Player p : players) {
			if(p.getNome().equals(nome))findByName = true;
		}
		return findByName;
        }
	
	//Busca partida com vaga para jogador
	private ChungToi buscaPartida() {
            ChungToi p = null;
		for (ChungToi ct : partidas) {
			if(ct.getNumJogadores()==1) {
				p = ct;
			}
		}
		return p;	
	}
	
	//Busca partida que o jogador está
	private ChungToi buscaPartidaJogador(int id) {
                ChungToi p = null;
		for (ChungToi ct : partidas) {
			if(ct.getP1().getId()==id ||ct.getP2().getId()==id) {
				p = ct;
			}
		}
		return p;
	}
	
	public void serverInfo() {
            System.out.println("Informações do Servidor");
		System.out.println("Jogadores Registrados: \n");
		for (Player p : players) {
			System.out.println(p.toString());
		}
		
		System.out.println("Partidas Criadas: \n");
		for (ChungToi pa : partidas) {
			System.out.println(pa.toString());
		}
                
                System.out.println("Jogadores Pré Registrados: \n");
		for (Player p : prePlayers) {
			System.out.println(p.toString());
		}
                
                System.out.println("Partidas Pré Criadas: \n");
		for (ChungToi pa : prePartidas) {
			System.out.println(pa.toString());
		}
                
                System.out.println("Jogadores em Aguardo: \n");
		for (Player p : aguardando) {
			System.out.println(p.toString());
		}
                
                System.out.println("---------------------------------------------------------------");
	}

}


