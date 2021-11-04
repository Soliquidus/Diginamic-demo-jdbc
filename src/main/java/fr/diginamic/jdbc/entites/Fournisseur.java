package fr.diginamic.jdbc.entites;

/**
 * Classe Fournisseur
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 03 /11/2021
 */
public class Fournisseur {

    /**
     * The Id.
     */
    int id;
    /**
     * The Nom.
     */
    String nom;

    /**
     * Instantiates a new Fournisseur.
     *
     * @param id  the id
     * @param nom the nom
     */
    public Fournisseur(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Fournisseur(String nom) {
        this.nom = nom;
    }

    public Fournisseur() {
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets nom.
     *
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Sets nom.
     *
     * @param nom the nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
}