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

    private static final String DB_URL;
    private static final String DB_USERNAME;
    private static final String DB_PASSWORD;

    static {
//      On déclare le fichier externe de configuration de la base de données
        ResourceBundle props = ResourceBundle.getBundle("databaseCloud");
//      On récupère les données dont on a besoin du fichier
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
        listerArticles();
    }

    private static void listerArticles(){
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)){
            System.out.println(connection);
            try(Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM ARTICLE")){
                while (resultSet.next()){
                    System.out.println("ID : " + resultSet.getString(1) + ", désignation : " + resultSet.getString("Designation"));
                }
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
