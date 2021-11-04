package fr.diginamic.jdbc;

import java.sql.*;

/**
 * Classe pour tester l'insertion dans la BDD
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 03/11/2021
 */
public class TestInsertion {
    private static final ConnectionDatabase connectionDatabase = new ConnectionDatabase();

    public static void main(String[] args) {
//        Exercice 1
        connectionDatabase.getDriver();
        creerFournisseur();
    }

    private static void creerFournisseur() {
        try (Connection connection = DriverManager.getConnection( ConnectionDatabase.DB_URL, ConnectionDatabase.DB_USERNAME, ConnectionDatabase.DB_PASSWORD ); Statement st = connection
                .createStatement() ) {
            System.out.println( st
                    .executeUpdate( "INSERT INTO FOURNISSEUR (NOM) VALUE ('La Maison des Peintres')" ) );
        } catch ( SQLException e ) {
            System.out.println( e.getMessage() );
        }
    }
}