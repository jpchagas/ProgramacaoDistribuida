import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ChungToiImpl extends UnicastRemoteObject implements ChungToiInterface {
	
	private ChungToi[] partidas;
	private static final long serialVersion = 332423325255;
	
	public ChungToiImpl(int numMaxPartidas) throws RemoteException{
		partidas = new ChungToi[numMaxPartidas];
		for(int i=0; i< numMaxPartidas;i++){
			partidas[i]= new ChungToi();
		}
	}
	
	@Override
	public int registraJogador(String nome) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int encerraPartida(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int temPartida(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int ehMinhaVez(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String obtemTabuleiro(String nome) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int posicionaPeca(int id, int pos, int orient) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int movePeca(int id, int pos, int numCasas, int orient) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int obtemOponente(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

}
