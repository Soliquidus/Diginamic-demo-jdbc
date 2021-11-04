package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe pour tester la mise à jour en BDD
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 03/11/2021
 */
public class TestUpdate {
    private static final ConnectionDatabase connectionDatabase = new ConnectionDatabase();

    public static void main(String[] args) {
//        Exercice 2
        connectionDatabase.getDriver();
        updateFournisseur();
    }

    private static void updateFournisseur() {
        try (Connection connection = DriverManager.getConnection( ConnectionDatabase.DB_URL, ConnectionDatabase.DB_USERNAME, ConnectionDatabase.DB_PASSWORD );
             Statement st = connection
                .createStatement() ) {
            System.out.println( st
                    .executeUpdate( "UPDATE FOURNISSEUR SET NOM = 'La Maison des Peintures' WHERE NOM = 'La Maison des Peintres'"));
        } catch ( SQLException e ) {
            System.out.println( e.getMessage() );
        }
    }
}