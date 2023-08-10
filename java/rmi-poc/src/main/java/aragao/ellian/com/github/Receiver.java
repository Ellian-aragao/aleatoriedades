package aragao.ellian.com.github;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Receiver {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry();
        MessengerService server = (MessengerService) registry
                .lookup("MessengerService");
        String responseMessage = server.sendMessage("other");
        String expectedMessage = "Server Message";
        System.out.println(expectedMessage.equals(responseMessage));
    }
}
