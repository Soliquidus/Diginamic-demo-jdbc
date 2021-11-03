package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * Classe pour tester la mise à jour en BDD
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 03/11/2021
 */
public class TestUpdate {

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
//        Exercice 2
        updateFournisseur();
    }

    private static void updateFournisseur() {
        try (Connection connection = DriverManager.getConnection( DB_URL, DB_USERNAME, DB_PASSWORD ); Statement st = connection
                .createStatement() ) {
            System.out.println( st
                    .executeUpdate( "UPDATE FOURNISSEUR SET NOM = 'La Maison des Peintures' WHERE NOM = 'La Maison des Peintres'"));
        } catch ( SQLException e ) {
            System.out.println( e.getMessage() );
        }
    }
}