import java.rmi.Naming;
import java.rmi.RemoteException;

public class ChungToiServer {

	public static void main(String[] args) {
		try {
			java.rmi.registry.LocateRegistry.createRegistry(1099);
			System.out.println("RMI registry ready.");
		} catch (RemoteException e) {
			System.out.println("RMI registry already running.");
		}
		try {
			Naming.rebind ("ChungToi", new ChungToiImpl());
			System.out.println ("ChungToi is ready.");
		} catch (Exception e) {
			System.out.println ("ChungToi failed:");
			e.printStackTrace();
		}
	}

}
