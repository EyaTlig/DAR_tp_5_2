package rmiClient;

import rmiService.IBanque;
import metier.Compte;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;

public class BanqueClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            IBanque banqueObj = (IBanque) registry.lookup("BanqueService");

            // Utilisation des méthodes IBanque ici
            Compte nouveauCompte = new Compte(1, 1000.0, new Date());
            String resultatCreation = banqueObj.creerCompte(nouveauCompte);
            System.out.println(resultatCreation);

            String resultatInfo = banqueObj.getInfoCompte(1);
            System.out.println(resultatInfo);

        } catch (Exception e) {
            System.err.println("Erreur côté client : " + e.toString());
            e.printStackTrace();
        }
    }
}
