package fr.diginamic.bll;

import fr.diginamic.jdbc.dao.DAOFactory;
import fr.diginamic.jdbc.dao.FournisseurDao;
import fr.diginamic.jdbc.entites.Fournisseur;

import java.util.ArrayList;
import java.util.List;

/**
 * Class FournisseurManager
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 04/11/2021
 */
public class FournisseurManager {
    private final FournisseurDao fournisseurDao;

    public FournisseurManager() {
        this.fournisseurDao = DAOFactory.getFournisseurDAO();
    }

    public void voirFournisseurs() {
        List<Fournisseur> fournisseurList = new ArrayList<>();
        fournisseurList = this.fournisseurDao.extraire();
        for(Fournisseur fournisseur : fournisseurList){
            int id = fournisseur.getId();
            String nom = fournisseur.getNom();
            System.out.print("\nId - " + id + " | Nom - " + nom);
        }
    }

    public void ajouterFournisseur(String nom){
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setNom(nom);
        fournisseurDao.insert(fournisseur);
    }
    public void updateFournisseur(String ancienNom, String nouveauNom){
        fournisseurDao.update(ancienNom, nouveauNom);
    }

    public void deleteFournisseur(Fournisseur fournisseur){
        boolean succes = fournisseurDao.delete(fournisseur);
        if(succes){
            System.out.println("\nLe fournisseur a bien été supprimé");
        }
        else{
            System.out.println("\nLa suppression n'a pas eue lieu");
        }
    }
}