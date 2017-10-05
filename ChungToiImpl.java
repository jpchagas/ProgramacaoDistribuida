import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class ChungToiImpl extends UnicastRemoteObject implements ChungToiInterface {

	private static final long serialVersionUID = 1234L;
	private static final int numMaxPartidas = 500;
	private static final int numMaxPlayers = 1000;
	private ArrayList<ChungToi> partidas;
	private ArrayList<Player> players;
	private int id = 0;
	private Player aguardando = null;
		
	protected ChungToiImpl() throws RemoteException {
		partidas = new ArrayList<ChungToi>();
		players = new ArrayList<Player>();
	}

	@Override
	public int registraJogador(String nome) throws RemoteException {
		if (players.size()>=numMaxPlayers){
			return -2;
		} else if(verificaNomeRepetido(nome)){
			return -1;
		}else {
			int id = generateId();
			Player newPlayer =  new Player(id,nome);
			players.add(newPlayer);
			return id;
		}
	}

	@Override
	public int encerraPartida(int id) throws RemoteException {
		ChungToi ct = buscaPartidaJogador(id);
		
		if(ct.getNumJogadores()==2) {
			ct.setNumJogadores(ct.getNumJogadores()-1);
			return 0;
		}else if(ct.getNumJogadores()==1){
			Player p1 = ct.getP1();
			Player p2 = ct.getP2();
			partidas.remove(ct);
			players.remove(p1);
			players.remove(p2);
			return 0;
		}else {
			//erro
			return -1;
		}
	}

	@Override
	public int temPartida(int id) throws RemoteException {
		
		if(aguardando == null || aguardando.id == id) {
			if(buscaPartidaJogador(id)!= null) {
				return 1;
			}else {
				aguardando = getPlayer(id);
				return 0;
			}
		}else if(aguardando != null && aguardando.id != id) {
			Player p1 = getPlayer(aguardando.id);
			Player p2 = getPlayer(id);
			ChungToi ct = new ChungToi();
			ct.setP1(p1);
			ct.setP2(p2);
			partidas.add(ct);
			aguardando = null;
			return 2;
		}else {
			return -1;
		}
	}

	@Override
	public int ehMinhaVez(int id) throws RemoteException {
		ChungToi ct = buscaPartidaJogador(id);
		int vencedor = ehVencedor(ct, ct.findBoard());
		boolean venci = false;
		if(ct.getP1().id == id && vencedor == 1) {
			venci = true;
		}else if(ct.getP2().id == id && vencedor == 2) {
			venci = true;
		}else {
			venci = false;
		}
		
		
		if(ct.getP1()==null || ct.getP2()==null) {
			return -2;
		}else if(venci){
			return 2;
		}else if(!venci && ct.getNumJogadores()==1){
			return 3;
		}else if(ct.getP1().id == id && ct.getTurno()==1 || ct.getP2().id == id && ct.getTurno()==2){
			return 1;
		}else if(ct.getP1().id == id && ct.getTurno()==2 || ct.getP2().id == id && ct.getTurno()==1){
			return 0;
		}else if(false){
			return 4;
		}else if(false){
			return 5;
		}else if(false){
			return 6;
		}else {
			return -1;
		}
	}

	@Override
	public String obtemOponente(int id) throws RemoteException {
		//Busca se jogador tem partida
		ChungToi partida = buscaPartidaJogador(id);
		if(partida != null) {
			if(partida.getP1().id == id) {
				return partida.getP2().nome;
			}else {
				return partida.getP1().nome;
			}
			
		}
		//Retorna vazio se não tem partida
		return null;
	}

	@Override
	/*
	 * Printa tabuleiro da partida do jogador
	 * 
	 * */
	public String obtemTabuleiro(int id) throws RemoteException {
		//Busca se jogador tem partida
		ChungToi partida = buscaPartidaJogador(id);
		if(partida != null) {
			//Printa tabuleiro se tem partida
			return partida.getBoard();
		}
		//Retorna vazio se não tem partida
		return null;
	}

	@Override
	public int posicionaPeca(int id, int pos, int orient) throws RemoteException {
		ChungToi ct = buscaPartidaJogador(id);
		ArrayList<String> baux = ct.findBoard();
		
		if(false) {
			//partida encerrada
			return 2;
		}else if(validaPosicao(pos, baux)) {
			return 0;
		}else if(!(pos>= 0 && pos<=8 && orient >= 0 && orient <= 1 )) {
			return -1;
		}else if(ct == null) {
			return -2;
		}else if(ehMinhaVez(id)==0){
			return -3;
		}else {
			if(ct.getP1().id==id) {
				if(orient==0) {
					baux.add(pos, "C");
				}else {
					baux.add(pos, "c");
				}
			}else {
				if(orient==0) {
					baux.add(pos, "E");
				}else {
					baux.add(pos, "e");
				}
			}
			trocaTurno(ct);
			return 1;
			
		}
	}

	@Override
	public int movePeca(int id, int pos,int sent, int numCasas, int orient) throws RemoteException {
		ChungToi ct = buscaPartidaJogador(id);
		ArrayList<String> baux = ct.findBoard();
		if(false) {
			//partida encerrada
			return 2;
		}else if(ehMinhaVez(id)==0) {
			//não é a vez do jogador
			return -3;
		}else if(baux.get(pos)!= ".") {
			//movimento inválido
			return 0;
		}else if(!(pos>= 0 && pos<=8 && orient >= 0 && orient <= 1 && sent>= 0 && sent<=8 && numCasas>= 0 && numCasas<=2 )) {
				//parametros inválidos
				return -1;
		}else if(ct == null) {
				//partida não iniciada
				return -2;
		}else {
			if(ct.getP1().id==id) {
				if(orient==0) {
					if(sent == 0) {
						
					}else if(sent == 0) {
						// diagonal esquerda­superior
					}else if(sent == 1) {
						//para cima
					}else if(sent == 2) {
						// diagonal direita­superior;
					}else if(sent == 3) {
						// esquerda;
						baux.add(pos, ".");
						baux.add(pos-numCasas, "C");
					}else if(sent == 4) {
						//sem movimento;
					}else if(sent == 5) {
						//direita
						baux.add(pos, ".");
						baux.add(pos+numCasas, "C");
						trocaTurno(ct);
					}else if(sent == 6) {
						//diagonal esquerda­inferior;
					}else if(sent == 7) {
						//para baixo
					}else if(sent == 8) {
						//diagonal direita­inferio
					}
					
					
				}else {
					
				}
			}else {
				if(orient==0) {
					
				}else {
					
				}
			}
			trocaTurno(ct);
			return 1;
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
			if(p.id == id)return p;
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
			if(ct.getP1().id==id ||ct.getP2().id==id) {
				return ct;
			}
		}
		return null;
	}
	
	private boolean partidaEncerrada() {
		return false;
	}
	
	private int ehVencedor(ChungToi ct,ArrayList<String> board) {
		
		//012
		//345
		//678
		//048
		//246
		//036
		//147
		//258
		
		
		
		int venceu = 0;
		
		if(board.get(0)==board.get(1) && board.get(1)==board.get(2)) {
			if(board.get(0)=="c" || board.get(0)=="C") {
				venceu = 1;
			}else if(board.get(0)=="e" || board.get(0)=="E") {
				venceu=2;
			}
			
		}else if(board.get(3)==board.get(4) && board.get(4)==board.get(5)) {
			if(board.get(3)=="c" || board.get(3)=="C") {
				venceu = 1;
			}else if(board.get(3)=="e" || board.get(3)=="E") {
				venceu=2;
			}
		}else if(board.get(6)==board.get(7) && board.get(7)==board.get(8)) {
			if(board.get(6)=="c" || board.get(6)=="C") {
				venceu = 1;
			}else if(board.get(6)=="e" || board.get(6)=="E") {
				venceu=2;
			}
		}else if(board.get(0)==board.get(4) && board.get(4)==board.get(8)) {
			if(board.get(0)=="c" || board.get(0)=="C") {
				venceu = 1;
			}else if(board.get(0)=="e" || board.get(0)=="E") {
				venceu=2;
			}
		}else if(board.get(2)==board.get(4) && board.get(4)==board.get(6)) {
			if(board.get(2)=="c" || board.get(2)=="C") {
				venceu = 1;
			}else if(board.get(2)=="e" || board.get(2)=="E") {
				venceu=2;
			}
		}else if(board.get(0)==board.get(3) && board.get(3)==board.get(6)) {
			if(board.get(0)=="c" || board.get(0)=="C") {
				venceu = 1;
			}else if(board.get(0)=="e" || board.get(0)=="E") {
				venceu=2;
			}
		}else if(board.get(1)==board.get(4) && board.get(4)==board.get(7)) {
			if(board.get(1)=="c" || board.get(1)=="C") {
				venceu = 1;
			}else if(board.get(1)=="e" || board.get(1)=="E") {
				venceu=2;
			}
		}else if(board.get(2)==board.get(5) && board.get(5)==board.get(8)) {
			if(board.get(2)=="c" || board.get(2)=="C") {
				venceu = 1;
			}else if(board.get(2)=="e" || board.get(2)=="E") {
				venceu=2;
			}
		}
		
		return venceu;
	}
	
	private boolean partidaIniciada() {
		return false;
	}
	
	private boolean validaMovimento() {
		
		return false;
	}
	
	private boolean validaPosicao( int pos,ArrayList<String> board) {
		boolean validadePosicao = false;
		if(pos<0 || pos>8) {
			System.out.println("pos out of range");
			validadePosicao = true;
		}else if(!(board.get(pos).equals("."))) {
			System.out.println("pos not empty");
			validadePosicao = true;
		}else {
			System.out.println("everything ok");
			validadePosicao = false;
		}
		return validadePosicao;
	}
	
	private void trocaTurno(ChungToi ct) {
		int taux = ct.getTurno();
		System.out.println("Turno: " + taux);
		if(taux==1) {
			System.out.println("Era o turno do primeiro e troquei pro segundo");
			ct.setTurno(2);
		}else if(taux==2){
			System.out.println("Era o turno do segundo e troquei pro primeiro");
			ct.setTurno(1);
		}
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
