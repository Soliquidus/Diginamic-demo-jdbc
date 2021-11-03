package fr.digi.d12;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * Classe pour tester la connexion avec la base de données
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 03/11/2021
 */
public class TestConnexionJdbc {
    public static void main(String[] args) throws Exception {

//        On déclare le fichier externe de configuration de la base de données
        ResourceBundle props = ResourceBundle.getBundle("database");
//        On récupère les données dont on a besoin du fichier
        String url = props.getString("jdbc.db.url");
        Class.forName(props.getString("jdbc.driver"));
        String username = props.getString("jdbc.db.login");
        String password = props.getString("jdbc.db.password");
//        On a plus qu'à établir la connexion avec la BDD
        Connection connection = DriverManager.getConnection(url, username, password);
        connection.createStatement();
        System.out.println("Connexion établie !");
        connection.close();
        System.out.println("Connexion fermée !");
    }
}
