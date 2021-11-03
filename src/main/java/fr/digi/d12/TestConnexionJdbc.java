package fr.digi.d12;

import java.sql.*;

/**
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 03/11/2021
 */
public class TestConnexionJdbc {
    public static void main(String[] args) throws Exception {
        Class.forName("org.mariadb.jdbc.Driver");

        String host = "localhost:3307";
        String dbName = "compta";
        String url = "jdbc:mariadb://" + host + "/" + dbName;
        String username = "root";
        String password = "";
        Connection connection = DriverManager.getConnection(url, username, password);
        connection.createStatement();
        System.out.println("Connexion établie !");
        connection.close();
        System.out.println("Connexion fermée !");
    }
}
