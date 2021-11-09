package fr.diginamic.jdbc.dao;

import fr.diginamic.jdbc.entites.Fournisseur;

import java.util.List;

/**
 * The interface Fournisseur dao.
 */
public interface FournisseurDao {
    /**
     * Extraire list.
     *
     * @return the list
     */
    List<Fournisseur> extraire();

    /**
     * Insert.
     *
     * @param fournisseur the fournisseur
     */
    void insert(Fournisseur fournisseur);

    /**
     * Update.
     *
     * @param ancienNom  the ancien nom
     * @param nouveauNom the nouveau nom
     */
    void update(String ancienNom, String nouveauNom);

    /**
     * Delete boolean.
     *
     * @param fournisseur the fournisseur
     * @return the boolean
     */
    boolean delete(Fournisseur fournisseur);
}
