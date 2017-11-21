    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.distribuida.ct.model;

import br.distribuida.ct.enums.*;


/**
 *
 * @author joao
 */
public class ChungToi {
	
	private int numJogadores, turno, vencedor,pecasP1,pecasP2;
	private Player p1,p2;
	private String[] board = { ".", ".", "." , ".", ".", ".", ".", ".", "."};
	private static int[][][] moves;
	private boolean partidaNaoIniciada , partidaEncerrada;
	
	
	public ChungToi() {
            turno = 1;
            numJogadores = 0;
            vencedor = 0;
            moves = new int [9][9][2];
            buildMoves();
            partidaNaoIniciada = true;
            partidaEncerrada = false;
            pecasP1 = 3;
            pecasP2 = 3;
	}
	
	public void move(int id, int pos,int sent, int numCasas, int orient) {
		int i = findNewPos(pos, sent, numCasas);
		board[i]=(orient==0) ? retornaPecaLinear(id) : retornaPecaDiagonal(id);
                if(sent!=4){
                    board[pos]= ".";
                }
	}
	
	public void posiciona(int pos,int orient,int id) {
		if(orient==0){
			board[pos]=retornaPecaLinear(id);
		}else {
			board[pos]=retornaPecaDiagonal(id);
		}
		
	}
	
	/**
	 * Verifica se o turno atual é o do jogador. 
	 *  
	 * @param	id  do jogador que esa verificando sua vez
	 * @return      true se for a vez do jgoador ou false se não for
	 */
	public boolean minhaVez(int id) {
		if ((p1.getId()== id && turno == id)||(p2.getId()== id && turno == id)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Busca oponente do jogador 
	 *  
	 * @param	id  do jogador que quer saber seu oponente
	 * @return      nome do oponente do jogador
	 */
	public String oponente(int id) {
		if(p1.getId()== id) {
			return p2.getNome();
		}else {
			return p1.getNome();
		}
	}
        
        public boolean jogadorNaPartida(int id){
            if(p1.getId()==id){
                return true;
            }else if(p2.getId()==id){
                return true;
            }else{
                return false;
            }
        }
		
	/*
	 * 
	 * Funções auxiliares
	 * 
	 * 
	 * */
	
	public int findNewPos(int pos, int sent, int numCasas) {
                //System.out.println("Procurando Novo Movimento");
                if(numCasas==0){
                    return moves[pos][sent][numCasas];
                }else{
                    return moves[pos][sent][numCasas-1];
                }
	}
	
	public boolean validaParametrosPosicionaPeca(int pos, int orient){
		if(!(pos>= 0 && pos<=8 && orient >= 0 && orient <= 1 )) {
			return true;
		}
		return false;
	}
	
	public boolean validaParametrosMovePeca(int id, int pos,int sent,int numCasas, int orient){
		if(!(pos>= 0 && pos<=8 && orient >= 0 && orient <= 1 && sent>= 0 && sent<=8 && numCasas>= 0 && numCasas<=2 )) {
			System.out.println("Parâmetros de Entrada Inválidos");
			return true;
		}
//		if(!(minhaPeca(id, pos))) {
//			System.out.println("Não é minha peça");
//			return true;
//		}
		return false;
	}
	
	public String printaTabuleiro() {
		String sboard ="";
		for (int i = 0; i < 9; i++) {
			if(i==2 || i==5) {
				sboard += board[i]; 
			}else {
				sboard += board[i];
			}
		}
		return sboard;
	}
	
	public void vencedor() {
		//Combinações Vencedoras:
		//012		//345		//678
		//048		//246
		//036		//147		//258
				
		//Mapa para alterar peças para lower case sem afetar o mapa original
		//Verifica combinações
		String[] lwa = new String[9];
		for (int i = 0; i < board.length; i++) {
			lwa[i] = board[i].toLowerCase();
		}
		
		if(lwa[0].equals(lwa[1]) && lwa[1].equals(lwa[2])&&!(lwa[0].equals("."))){
			if(lwa[0].equals("c")) {
				 setVencedor(1);
                                 setPartidaEncerrada(true);
			}else if(lwa[0].equals("e")) {
				 setVencedor(2);
                                 setPartidaEncerrada(true);
			}
		}else if(lwa[3].equals(lwa[4]) && lwa[4].equals(lwa[5])&&!(lwa[3].equals("."))) {
			if(lwa[3].equals("c")) {
				 setVencedor(1);
                                 setPartidaEncerrada(true);
			}else if(lwa[3].equals("e")) {
				 setVencedor(2);
                                 setPartidaEncerrada(true);
			}
		}else if(lwa[6].equals(lwa[7]) && lwa[7].equals(lwa[8])&&!(lwa[6].equals("."))) {
			if(lwa[6].equals("c") ) {
				 setVencedor(1);
                                 setPartidaEncerrada(true);
			}else if(lwa[6].equals("e")) {
				 setVencedor(2);
                                 setPartidaEncerrada(true);
			}
		}else if(lwa[0].equals(lwa[4]) && lwa[4].equals(lwa[8])&&!(lwa[0].equals("."))) {
			if(lwa[0].equals("c")) {
				 setVencedor(1);
                                 setPartidaEncerrada(true);
			}else if(lwa[0].equals("e")) {
				 setVencedor(2);
                                 setPartidaEncerrada(true);
			}
		}else if(lwa[2].equals(lwa[4]) && lwa[4].equals(lwa[6])&&!(lwa[2].equals("."))) {
			if(lwa[2].equals("c")) {
				 setVencedor(1);
                                 setPartidaEncerrada(true);
			}else if(lwa[2].equals("e")) {
				 setVencedor(2);
                                 setPartidaEncerrada(true);
			}
		}else if(lwa[0].equals(lwa[3]) && lwa[3].equals(lwa[6])&&!(lwa[0].equals("."))) {
			if(lwa[0].equals("c")) {
				setVencedor(1);
                                setPartidaEncerrada(true);
			}else if(lwa[0].equals("e") ) {
				 setVencedor(2);
                                 setPartidaEncerrada(true);
			}
		}else if(lwa[1].equals(lwa[4]) && lwa[4].equals(lwa[7])&&!(lwa[1].equals("."))) {
			if(lwa[1].equals("c") ) {
				 setVencedor(1);
                                 setPartidaEncerrada(true);
			}else if(lwa[1].equals("e") ) {
				 setVencedor(2);
                                 setPartidaEncerrada(true);
			}
		}else if(lwa[2].equals(lwa[5]) && lwa[5].equals(lwa[8])&&!(lwa[2].equals("."))) {
			if(lwa[2].equals("c") ) {
                            setVencedor(1);
                            setPartidaEncerrada(true);
			}else if(lwa[2].equals("e")) {
				 setVencedor(2);
                                 setPartidaEncerrada(true);
			}
		}
	}
	
	/**
	 * Troca o turno do jogo
	 *  
	 * @param	nome  nomenclatura que o usuário será chamado no jogo
	 * @return      id do jogador
	 * @see		RespostaRegistraJogadorEnum
	 */
	public void trocaTurno() {
		//System.out.println("Turno: " + turno);
		if(turno==1) {
			//System.out.println("Era o turno do primeiro e troquei pro segundo");
			setTurno(2);
		}else if(turno==2){
			//System.out.println("Era o turno do segundo e troquei pro primeiro");
			setTurno(1);
		}
	}
	
	public boolean validaPosicao(int pos) {
		if(!(board[pos].equals("."))) {
			return true;
		}
		return false;
	}
	
	public boolean validaMovimento(int id,int pos,int sent, int numCasas, int orient) {
		if(board[pos].equals("C")||board[pos].equals("E")) {
			if(sent == JogadasEnum.DiagonalDireitaInferior.getValor() || sent == JogadasEnum.DiagonalEsquerdaInferior.getValor()|| sent == JogadasEnum.DiagonalEsquerdaSuperior.getValor()|| sent == JogadasEnum.DiagonlaDireitaSuperior.getValor()) {
				System.out.println("Perpendicular andando da Diagonal");
				return true;
			}
		}else if(board[pos].equals("c")||board[pos].equals("e")) {
			if(sent == JogadasEnum.Baixo.getValor() || sent == JogadasEnum.Cima.getValor()|| sent == JogadasEnum.Direita.getValor()|| sent == JogadasEnum.Esquerda.getValor()) {
				System.out.println("Diagonal Andando na Perpendicular");
				return true;
			}
		}
                if(findNewPos(pos, sent, numCasas)==-1){
                    return true;
                }
                
		if (!(board[findNewPos(pos, sent, numCasas)].equals("."))&&sent!=4) {
                        System.out.println(id + "" +pos + "" +sent+ "" +numCasas+ ""+orient);
			System.out.println("Posição não vazia");
			return true;
		}
                if(!(minhaPeca(id, pos))) {
			System.out.println("Não é minha peça");
			return true;
		}
                
                
                
		return false;
	}
	
	public int verificaPlayer(int id) {
		if(p1.getId()==id) {
			return 1;
		}else {
			return 2;
		}
	}
	
	public Player getMyPlayer(int id) {
		if(p1.getId()==id) {
			return p1;
		}else {
			return p2;
		}
	}
	
	public String retornaPecaLinear(int id) {
		return (verificaPlayer(id)==1) ? "C" : "E";
	}
	
	public String retornaPecaDiagonal(int id) {
		return (verificaPlayer(id)==1) ? "c" : "e";
	}
	
	public int defineNewPos(int pos,int sent, int numCasas) {
		
		return 0;
	}
	
	public boolean minhaPeca(int id, int pos) {
		int player = verificaPlayer(id);
		if(player == 1) {
			return (board[pos].equals("C")||board[pos].equals("c"))? true:false;
		}else {
			return (board[pos].equals("E")||board[pos].equals("e"))? true:false;
		}
	}

    @Override
    public String toString() {
        return "ChungToi{" + "numJogadores=" + numJogadores + ", turno=" + turno + ", vencedor=" + vencedor + ", p1=" + p1 + ", p2=" + p2 + ", board=" + board + ", partidaNaoIniciada=" + partidaNaoIniciada + ", partidaEncerrada=" + partidaEncerrada + '}';
    }
	
	/*
	 * Getters e Setters
	 * 
	 * 
	 * */

    public int getPecasP1() {
        return pecasP1;
    }

    public void setPecasP1(int pecasP1) {
        this.pecasP1 = pecasP1;
    }

    public int getPecasP2() {
        return pecasP2;
    }

    public void setPecasP2(int pecasP2) {
        this.pecasP2 = pecasP2;
    }
    
    
	
	public int getNumJogadores(){
		return numJogadores;
	}
	
	public void setNumJogadores(int num) {
		this.numJogadores = num;
	}
	
	public Player getP1() {
		return p1;
	}

	public void setP1(Player p1) {
		this.p1 = p1;
	}

	public Player getP2() {
		return p2;
	}

	public void setP2(Player p2) {
		this.p2 = p2;
	}
	
	public String[] getBoard(){
		return board;
	}	
	
	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}
	

	public boolean getVencedor(int id) {
            return (verificaPlayer(id)==vencedor)? true:false;
	}

	public void setVencedor(int vencedor) {
		this.vencedor = vencedor;
	}
	
	public boolean isPartidaNaoIniciada() {
		return partidaNaoIniciada;
	}

	public void setPartidaNaoIniciada(boolean partidaNaoIniciada) {
		this.partidaNaoIniciada = partidaNaoIniciada;
	}

	public boolean isPartidaEncerrada() {
		return partidaEncerrada;
	}

	public void setPartidaEncerrada(boolean partidaEncerrada) {
		this.partidaEncerrada = partidaEncerrada;
	}
	
	
	/*
    Monta tabela de movimentos
	*/
	public void buildMoves(){
		//moves[pos][sent][numCasas] = result;
		//pos 0 - num casas 1
		moves[0][0][0]=-1;
		moves[0][1][0]=-1;
		moves[0][2][0]=-1;
		moves[0][3][0]=-1;
		moves[0][4][0]=-0;
		moves[0][5][0]=1;
		moves[0][6][0]=-1;
		moves[0][7][0]=3;
		moves[0][8][0]=4;
  
		//pos 1 - num casas 1
		moves[1][0][0]=-1;
		moves[1][1][0]=-1;
		moves[1][2][0]=-1;
		moves[1][3][0]=0;
		moves[1][4][0]=1;
		moves[1][5][0]=2;
		moves[1][6][0]=3;
		moves[1][7][0]=4;
		moves[1][8][0]=5;
		
		//	pos 2 - num casas 1
		moves[2][0][0]=-1;
		moves[2][1][0]=-1;
		moves[2][2][0]=-1;
		moves[2][3][0]=1;
		moves[2][4][0]=2;
		moves[2][5][0]=-1;
		moves[2][6][0]=4;
		moves[2][7][0]=5;
		moves[2][8][0]=-1;
		
		//pos 3 - num casas 1
		moves[3][0][0]=-1;
		moves[3][1][0]=0;
		moves[3][2][0]=1;
		moves[3][3][0]=-1;
		moves[3][4][0]=3;
		moves[3][5][0]=4;
		moves[3][6][0]=-1;
		moves[3][7][0]=6;
		moves[3][8][0]=7;
		
		//pos 4 - num casas 1
		moves[4][0][0]=0;
		moves[4][1][0]=1;
		moves[4][2][0]=2;
		moves[4][3][0]=3;
		moves[4][4][0]=4;
		moves[4][5][0]=5;
		moves[4][6][0]=6;
		moves[4][7][0]=7;
		moves[4][8][0]=8;
		
		//pos 5 - num casas 1
		moves[5][0][0]=1;
		moves[5][1][0]=2;
		moves[5][2][0]=-1;
		moves[5][3][0]=4;
		moves[5][4][0]=5;
		moves[5][5][0]=-1;
		moves[5][6][0]=7;
		moves[5][7][0]=8;
		moves[5][8][0]=-1;
		
		//pos 6 - num casas 1
		moves[6][0][0]=-1;
		moves[6][1][0]=3;
		moves[6][2][0]=4;
		moves[6][3][0]=-1;
		moves[6][4][0]=6;
		moves[6][5][0]=7;
		moves[6][6][0]=-1;
		moves[6][7][0]=-1;
		moves[6][8][0]=-1;
		
		//pos 4 - num casas 1
		moves[7][0][0]=3;
		moves[7][1][0]=4;
		moves[7][2][0]=5;
		moves[7][3][0]=6;
		moves[7][4][0]=7;
		moves[7][5][0]=8;
		moves[7][6][0]=-1;
		moves[7][7][0]=-1;
		moves[7][8][0]=-1;
		
		//pos 4 - num casas 1
		moves[8][0][0]=4; 
		moves[8][1][0]=5;
		moves[8][2][0]=-1;
		moves[8][3][0]=7;
		moves[8][4][0]=8;
		moves[8][5][0]=-1;
		moves[8][6][0]=-1;
		moves[8][7][0]=-1;
		moves[8][8][0]=-1;
		
		//	pos 0 - num casas 2
		moves[0][0][1]=-1;
		moves[0][1][1]=-1;
		moves[0][2][1]=-1;
		moves[0][3][1]=-1;
		moves[0][4][1]=0;
		moves[0][5][1]=2;
		moves[0][6][1]=-1;
		moves[0][7][1]=6;
		moves[0][8][1]=8;
		
		//pos 1 - num casas 2
		moves[1][0][1]=-1;
		moves[1][1][1]=-1;
		moves[1][2][1]=-1;
		moves[1][3][1]=-1;
		moves[1][4][1]=1;
		moves[1][5][1]=-1;
		moves[1][6][1]=-1;
		moves[1][7][1]=7;
		moves[1][8][1]=-1;
		
		//pos 2 - num casas 2
		moves[2][0][1]=-1;
		moves[2][1][1]=-1;
		moves[2][2][1]=-1;
		moves[2][3][1]=0;
		moves[2][4][1]=2;
		moves[2][5][1]=-1;
		moves[2][6][1]=6;
		moves[2][7][1]=8;
		moves[2][8][1]=-1;
		
		//pos 3 - num casas 2
		moves[3][0][1]=-1;
		moves[3][1][1]=-1;
		moves[3][2][1]=-1;
		moves[3][3][1]=-1;
		moves[3][4][1]=3;
		moves[3][5][1]=5;
		moves[3][6][1]=-1;
		moves[3][7][1]=-1;
		moves[3][8][1]=-1;
		
		//pos 4 - num casas 2
		moves[4][0][1]=-1;
		moves[4][1][1]=-1;
		moves[4][2][1]=-1;
		moves[4][3][1]=-1;
		moves[4][4][1]=4;
		moves[4][5][1]=-1;
		moves[4][6][1]=-1;
		moves[4][7][1]=-1;
		moves[4][8][1]=-1;
		
		//	pos 5 - num casas 2
		moves[5][0][1]=-1;
		moves[5][1][1]=-1;
		moves[5][2][1]=-1;
		moves[5][3][1]=3;
		moves[5][4][1]=5;
		moves[5][5][1]=-1;
		moves[5][6][1]=-1;
		moves[5][7][1]=-1;
		moves[5][8][1]=-1;
  
		//pos 6 - num casas 2
		moves[6][0][1]=-1;
		moves[6][1][1]=0;
		moves[6][2][1]=2;
		moves[6][3][1]=-1;
		moves[6][4][1]=6;
		moves[6][5][1]=8;
		moves[6][6][1]=-1;
		moves[6][7][1]=-1;
		moves[6][8][1]=-1;
		
		//pos 7 - num casas 2
		moves[7][0][1]=-1;
		moves[7][1][1]=1;
		moves[7][2][1]=-1;
		moves[7][3][1]=-1;
		moves[7][4][1]=7;
		moves[7][5][1]=-1;
		moves[7][6][1]=-1;
		moves[7][7][1]=-1;
		moves[7][8][1]=-1;
		
		//pos 8 - num casas 2
		moves[8][0][1]=0;
		moves[8][1][1]=2;
		moves[8][2][1]=-1;
		moves[8][3][1]=6;
		moves[8][4][1]=8;
		moves[8][5][1]=-1;
		moves[8][6][1]=-1;
		moves[8][7][1]=-1;
		moves[8][8][1]=-1;
		
	}
	
	
	
}

