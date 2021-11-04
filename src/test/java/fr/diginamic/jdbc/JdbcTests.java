package fr.diginamic.jdbc;

import static org.junit.Assert.assertTrue;

import fr.diginamic.bll.FournisseurManager;
import fr.diginamic.jdbc.ConnectionDatabase;
import fr.diginamic.jdbc.entites.Fournisseur;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class JdbcTests
{
    private final static ConnectionDatabase connectionDatabase = new ConnectionDatabase();
    private static final FournisseurManager fournisseurManager = new FournisseurManager();

    @Test
    public void testInsertionFournisseur(){
        connectionDatabase.getDriver();
        fournisseurManager.ajouterFournisseur("La maison de la Peinture");
    }

    @Test
    public void testVoirFournisseurs(){
        connectionDatabase.getDriver();
        fournisseurManager.voirFournisseurs();
    }

    @Test
    public void testUpdateFournisseur(){
        connectionDatabase.getDriver();
        fournisseurManager.updateFournisseur("La maison de la Peinture", "La maison des Peintures");
    }

    @Test
    public void testDeleteFournisseur(){
        Fournisseur maisonDesPeintures = new Fournisseur("La maison des Peintures");
        fournisseurManager.deleteFournisseur(maisonDesPeintures);
    }
}
