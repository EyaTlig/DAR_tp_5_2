package rmiServer;

import rmiService.BanqueImpl;
import rmiService.IBanque;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BanqueServer {
    public static void main(String[] args) throws RemoteException {
        IBanque banqueObj = new BanqueImpl();

        try {
            // Vérifie si l'objet a déjà été exporté
            if (UnicastRemoteObject.unexportObject(banqueObj, false)) {
                System.out.println("Objet distant déjà exporté. Réexportation...");
            }

            IBanque stub = (IBanque) UnicastRemoteObject.exportObject(banqueObj, 0);

            Registry registry = LocateRegistry.createRegistry(1099);

            registry.rebind("BanqueService", stub);

            System.out.println("Serveur Banque prêt...");
        } catch (RemoteException e) {
            System.err.println("Erreur côté serveur : " + e.toString());
            e.printStackTrace();
        }
    }
}
