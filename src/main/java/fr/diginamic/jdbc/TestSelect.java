package fr.diginamic.jdbc;

import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Classe pour tester la suppression en BDD
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 03/11/2021
 */
public class TestSelect {

    private static final String DB_URL;
    private static final String DB_USERNAME;
    private static final String DB_PASSWORD;

    static {
        ResourceBundle props = ResourceBundle.getBundle("databaseCloud");
        try {
            Class.forName(props.getString("jdbc.driver"));
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        DB_URL = props.getString("jdbc.db.url");
        DB_USERNAME = props.getString("jdbc.db.login");
        DB_PASSWORD = props.getString("jdbc.db.password");
    }

    public static void main(String[] args) {
//        Exercice 4
        listerFournisseurs();
    }

    private static void listerFournisseurs() {
        List<Fournisseur> fournisseurs = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD); Statement st = connection
                .createStatement()) {
            ResultSet resultSet = st.executeQuery("SELECT * FROM FOURNISSEUR");
            while (resultSet.next()) {
                fournisseurs.add(new Fournisseur(resultSet.getInt(1), resultSet.getString("Nom")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        for (Fournisseur fournisseur : fournisseurs) {
            int id = fournisseur.getId();
            String nom = fournisseur.getNom();
            System.out.print("\nID - " + id + " : " + nom);
        }
    }
}