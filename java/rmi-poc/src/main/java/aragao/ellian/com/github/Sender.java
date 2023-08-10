package aragao.ellian.com.github;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Sender {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        MessengerService server = new MessengerServiceImpl();
        MessengerService stub = (MessengerService) UnicastRemoteObject.exportObject(server, 0);

        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("MessengerService", stub);
    }
}
