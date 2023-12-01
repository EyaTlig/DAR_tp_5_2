package rmiService;

import metier.Compte;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BanqueImpl extends UnicastRemoteObject implements IBanque {
    public BanqueImpl() throws RemoteException {
        super();
    }

    @Override
    public String creerCompte(Compte c) throws RemoteException {
        // Implémentation de la création de compte
        return "Compte créé avec succès : " + c.toString();
    }

    @Override
    public String getInfoCompte(int code) throws RemoteException {
        // Implémentation de la récupération d'informations de compte
        return "Informations du compte avec le code " + code + ".";
    }
}
