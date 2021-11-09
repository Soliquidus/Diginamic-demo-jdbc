package fr.diginamic.jdbc.entites;

/**
 * Classe Article
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 03 /11/2021
 */
public class Article {
    /**
     * The Id.
     */
    int id;
    /**
     * The Ref.
     */
    String ref;
    /**
     * The Designation.
     */
    String designation;
    /**
     * The Prix.
     */
    double prix;
    /**
     * The Fournisseur.
     */
    int fournisseur;

    /**
     * Instantiates a new Article.
     *
     * @param id          the id
     * @param ref         the ref
     * @param designation the designation
     * @param prix        the prix
     * @param fournisseur the fournisseur
     */
    public Article(int id, String ref, String designation, double prix, int fournisseur) {
        this.id = id;
        this.ref = ref;
        this.designation = designation;
        this.prix = prix;
        this.fournisseur = fournisseur;
    }

    /**
     * Instantiates a new Article.
     *
     * @param ref         the ref
     * @param designation the designation
     * @param prix        the prix
     * @param fournisseur the fournisseur
     */
    public Article(String ref, String designation, double prix, int fournisseur) {
        this.ref = ref;
        this.designation = designation;
        this.prix = prix;
        this.fournisseur = fournisseur;
    }

    /**
     * Instantiates a new Article.
     *
     * @param designation the designation
     */
    public Article(String designation) {
        this.designation = designation;
    }

    /**
     * Instantiates a new Article.
     */
    public Article() {
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
     * Gets ref.
     *
     * @return the ref
     */
    public String getRef() {
        return ref;
    }

    /**
     * Sets ref.
     *
     * @param ref the ref
     */
    public void setRef(String ref) {
        this.ref = ref;
    }

    /**
     * Gets designation.
     *
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Sets designation.
     *
     * @param designation the designation
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * Gets prix.
     *
     * @return the prix
     */
    public double getPrix() {
        return prix;
    }

    /**
     * Sets prix.
     *
     * @param prix the prix
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }

    /**
     * Gets fournisseur.
     *
     * @return the fournisseur
     */
    public int getFournisseur() {
        return fournisseur;
    }

    /**
     * Sets fournisseur.
     *
     * @param fournisseur the fournisseur
     */
    public void setFournisseur(int fournisseur) {
        this.fournisseur = fournisseur;
    }
}