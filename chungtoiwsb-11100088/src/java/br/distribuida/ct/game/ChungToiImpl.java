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
	private ArrayList<Player> players;
	private int id = 0;
	private Player aguardando = null;
		
	
	public ChungToiImpl() {
		partidas = new ArrayList<ChungToi>(numMaxPartidas);
		players = new ArrayList<Player>(numMaxPlayers);
	}
	
	@Override
	public int preRegistro(String nome1, int id1, String nome2, int id2 ) {
            Player p1 = new Player(id1, nome1);
            Player p2 =  new Player(id2, nome2);            
            players.add(p1);
            players.add(p2);
            ChungToi novaPartida = new ChungToi(p1,p2);
            partidas.add(novaPartida);
            return 0;
	}


	@Override
	public synchronized int registraJogador(String nome) {
		if (players.size()>=numMaxPlayers){
			return RespostasRegistraJogadorEnum.NumeroMaximoJogadoresAtingido.getValor();
		} else if(verificaNomeRepetido(nome)){
			return RespostasRegistraJogadorEnum.UsuárioJaCadastrado.getValor();
		}else {
			int id = generateId();
			Player newPlayer =  new Player(id,nome);
			players.add(newPlayer);
			return id;
		}
	}

	@Override
	public synchronized int encerraPartida(int id) {
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

	@Override
	public synchronized int temPartida(int id) {
		
		if(aguardando == null || aguardando.getId() == id) {
			if(buscaPartidaJogador(id)!= null) {
				return RespostasTemPartidaEnum.TemPartidaP1.getValor();
			}else {
				aguardando = getPlayer(id);
				return RespostasTemPartidaEnum.AindaSemPartida.getValor();
			}
		}else if(aguardando != null && aguardando.getId() != id) {
			Player p1 = getPlayer(aguardando.getId());
			p1.setCor("c");
			Player p2 = getPlayer(id);
			p2.setCor("e");
			ChungToi ct = new ChungToi(p1,p2);
			partidas.add(ct);
			aguardando = null;
			ct.setPartidaNaoIniciada(false);
			return RespostasTemPartidaEnum.TemPartidaP2.getValor();
		}else {
			return RespostasTemPartidaEnum.Erro.getValor();
		}
	}

	@Override
	public int ehMinhaVez(int id) {
		ChungToi ct = buscaPartidaJogador(id);
		int qual_player = ct.verificaPlayer(id);
		
		ct.vencedor();

		if(ct.getP1()==null || ct.getP2()==null) {
			
			return RespostasMinhaVezEnum.NaoHaDoisJogadores.getValor();
		}else if(ct.getVencedor()==qual_player){
			return RespostasMinhaVezEnum.Vencedor.getValor();
		}else if(ct.getVencedor()!=qual_player && ct.getVencedor()!=0){
			return RespostasMinhaVezEnum.Perdedor.getValor();
		}else if(ct.getP1().getId() == id && ct.getTurno()==1 || ct.getP2().getId() == id && ct.getTurno()==2){
			return RespostasMinhaVezEnum.Sim.getValor();
		}else if(ct.getP1().getId() == id && ct.getTurno()==2 || ct.getP2().getId() == id && ct.getTurno()==1){
			return RespostasMinhaVezEnum.Nao.getValor();
		}else if(false){
			return RespostasMinhaVezEnum.Empate.getValor();
		}else if(ct.isPartidaEncerrada() && ct.getVencedor()==id){
			return RespostasMinhaVezEnum.VencedorWO.getValor();
		}else if(ct.isPartidaEncerrada() && ct.getVencedor()!=id){
			return RespostasMinhaVezEnum.PerdedorWO.getValor();
		}else {
			return RespostasMinhaVezEnum.Erro.getValor();
		}
	}

	@Override
	public String obtemOponente(int id) {
		//Busca se jogador tem partida
		ChungToi partida = buscaPartidaJogador(id);
		if(partida != null) {
			return partida.oponente(id);
		}
		//Retorna vazio se não tem partida
		return null;
	}

	@Override
	/*
	 * Printa tabuleiro da partida do jogador
	 * 
	 * */
	public String obtemTabuleiro(int id) {
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
		ChungToi ct = buscaPartidaJogador(id);
				
		if(ct.isPartidaEncerrada()) {
			return RespostasPosicionaPecaEnum.PartidaEncerrada.getValor();
		
		}else if(ct.isPartidaNaoIniciada()) {
			return RespostasPosicionaPecaEnum.PartidaNaoIniciada.getValor();
		
		}else if(ehMinhaVez(id)==0){
			return RespostasPosicionaPecaEnum.NaoEVez.getValor();
			
		}else if(ct.validaParametrosPosicionaPeca(pos,orient)) {
			return RespostasPosicionaPecaEnum.ParâmetrosInválidos.getValor();
			
		}else if(ct.validaPosicao(pos)) {
			return RespostasPosicionaPecaEnum.PosicaoInvalida.getValor();
			
		}else {
			ct.posiciona(pos, orient, id);
			ct.trocaTurno();
			return RespostasPosicionaPecaEnum.TudoCerto.getValor();
			
		}
	}

	@Override
	public int movePeca(int id, int pos,int sent, int numCasas, int orient) {
		ChungToi ct = buscaPartidaJogador(id);
		if(ct.isPartidaEncerrada()) {
			System.out.println("Partida Encerrada");
			return RespostasMovePecaEnum.PartidaEncerrada.getValor();
		
		}else if(ct.isPartidaNaoIniciada()) {
			System.out.println("Partida Não Iniciada");
			return RespostasMovePecaEnum.PartidaNaoIniciada.getValor();
			
		}else if(ehMinhaVez(id)==0) {
			System.out.println("Não é a vez");
			return RespostasMovePecaEnum.NaoEVez.getValor();
			
		}else if(ct.validaParametrosMovePeca(id,pos,sent, numCasas,orient)) {
			System.out.println("Parâmetros inválidos");
			return RespostasMovePecaEnum.ParâmetrosInválidos.getValor();
			
		}else if(ct.validaMovimento(id,pos,sent, numCasas, orient)) {
			System.out.println("Movimento válido");
			return RespostasMovePecaEnum.MovimentoInvalido.getValor();
				
		}else {
			ct.move(id, pos, sent, numCasas, orient);
			System.out.println("Movimento executado");
			ct.trocaTurno();
			System.out.println("Troquei turno");
			System.out.println(RespostasMovePecaEnum.TudoCerto.getValor());
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
		for (Player p : players) {
			if(p.getId() == id)return p;
		}
		return null;
	}
	
	//Busca partida com vaga para jogador
	private ChungToi buscaPartida() {
		for (ChungToi ct : partidas) {
			if(ct.getNumJogadores()==1) {
				return ct;
			}
		}
		return null;	
	}
	
	//Busca partida que o jogador está
	private ChungToi buscaPartidaJogador(int id) {
		for (ChungToi ct : partidas) {
			if(ct.getP1().getId()==id ||ct.getP2().getId()==id) {
				return ct;
			}
		}
		return null;
	}
	
	public void serverInfo() {
		System.out.println("Register players: \n");
		for (Player p : players) {
			System.out.println(p.toString());
		}
		
		System.out.println("Matches: \n");
		for (ChungToi pa : partidas) {
			System.out.println(pa.toString());
		}
	}

}


