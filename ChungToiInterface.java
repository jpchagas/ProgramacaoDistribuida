/**
 * 
 */
package chungtoigame;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author joao
 *
 */
public interface ChungToiInterface extends Remote {
	public int registraJogador(String nome) throws RemoteException;
	public int encerraPartida(int id) throws RemoteException;
	public int temPartida(int id) throws RemoteException;
	public int ehMinhaVez(int id) throws RemoteException;
	public int obtemOponente(int id) throws RemoteException;
	public String obtemTabuleiro(String nome) throws RemoteException;
	public int posicionaPeca(int id, int pos, int orient) throws RemoteException;
	public int movePeca(int id, int pos,int numCasas, int orient) throws RemoteException;
}
