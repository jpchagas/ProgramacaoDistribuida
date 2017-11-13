import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChungToiInterface extends Remote {
	
	/**
	 * Registra um jogador no servidor do jogo. 
	 *  
	 * @param	nome  nomenclatura que o usuário será chamado no jogo
	 * @return      id do jogador
	 * @see		RespostaRegistraJogadorEnum
	 */
	public int registraJogador(String nome) throws RemoteException;
	
	/**
	 * Encerra a partida em que determinado jogador está. 
	 *
	 * @param	id do jogador gerado à partir do registraJogador
	 * @return  retorna partida encerrada ou erro
	 * @see		RespostaEncerraPartidaEnum
	 */
	public int encerraPartida(int id) throws RemoteException;
	
	/**
	 * Verifica se existe uma partida para determinado jogador. 
	 *
	 * @param  id do jogador gerado à partir do registraJogador
	 * @return      retorna partida ou erro
	 * @see		RespostaTemPartidaEnum
	 */
	public int temPartida(int id) throws RemoteException;
	
	/**
	 * Verifica se é a vez do jogador de jogar.
	 *
	 * @param  id do jogador gerado à partir do registraJogador
	 * @return      retorna vez do jogador ou erro
	 * @see		RespostaMinhaVezEnum
	 */
	public int ehMinhaVez(int id) throws RemoteException;
	
	/**
	 * Obtem o oponente com quem o jogador está jogando. 
	 *
	 * @param  id do jogador gerado à partir do registraJogador
	 * @return      the image at the specified URL
	 */
	public String obtemOponente(int id) throws RemoteException;
	
	/**
	 * Obtem o tabuleiro no qual o jogador está jogando. 
	 *
	 * @param  id do jogador gerado à partir do registraJogador
	 * @return      the image at the specified URL
	 */
	public String obtemTabuleiro(int id) throws RemoteException;
	
	/**
	 * Posiciona as peças do jogador no tabuleiro. 
	 *
	 * @param  id do jogador gerado à partir do registraJogador
	 * @param  pos da jogador gerado à partir do registraJogador
	 * @param  orient do jogador gerado à partir do registraJogador
	 * @return      the image at the specified URL
	 * @see		RespostaPosicionaPecaEnum
	 */
	public int posicionaPeca(int id, int pos, int orient) throws RemoteException;
	
	/**
	 * Move as peças do jogador no tabuleiro.
	 *
	 * @param  id do jogador gerado à partir do registraJogador
	 * @param  pos da jogador gerado à partir do registraJogador
	 * @param  orient do jogador gerado à partir do registraJogador
	 * @param  sent do jogador gerado à partir do registraJogador
	 * @param  numCasas do jogador gerado à partir do registraJogador
	 * @return      the image at the specified URL
	 * @see		RespostaMovePecaEnum
	 */
	public int movePeca(int id, int pos,int sent,int numCasas, int orient) throws RemoteException;
	
	/**
	 * Pré registra o jogador no jogo.
	 *
	 * @param  id do jogador gerado à partir do registraJogador
	 * @param  pos da jogador gerado à partir do registraJogador
	 * @param  orient do jogador gerado à partir do registraJogador
	 * @param  sent do jogador gerado à partir do registraJogador
	 * @param  numCasas do jogador gerado à partir do registraJogador
	 * @return      the image at the specified URL
	 * @see		RespostaMovePecaEnum
	 */
	public int preRegistro(int id1, String nome1, int id2, String nome2)throws RemoteException;
}
