package fr.diginamic.jdbc;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * Classe qui permet de se connecter à la BDD
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 03/11/2021
 */
public class ConnectionDatabase {
//    On déclare le fichier externe de configuration de la base de données
    public static final ResourceBundle props = ResourceBundle.getBundle("databaseCloud");
    public static final String DB_URL = props.getString("jdbc.db.url");
    public static final String DB_USERNAME = props.getString("jdbc.db.login");
    public static final String DB_PASSWORD = props.getString("jdbc.db.password");

    public void getDriver(){
        try {
            Class.forName(props.getString("jdbc.driver"));
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
