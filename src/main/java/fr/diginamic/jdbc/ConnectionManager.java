package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Class to manage Database connection.
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 04 /11/2021
 */
public class ConnectionManager {
    private static Connection connection;
    /**
     * The constant props.
     */
    public static final ResourceBundle props = ResourceBundle.getBundle("databaseCloud");
    /**
     * The constant DB_URL.
     */
    public static final String DB_URL = props.getString("jdbc.db.url");
    /**
     * The constant DB_USERNAME.
     */
    public static final String DB_USERNAME = props.getString("jdbc.db.login");
    /**
     * The constant DB_PASSWORD.
     */
    public static final String DB_PASSWORD = props.getString("jdbc.db.password");

    private ConnectionManager(){}

    /**
     * Gets connection.
     *
     * @return the connection
     * @throws SQLException the sql exception
     */
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(props.getString("jdbc.driver"));
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        if(null == connection || connection.isClosed()){
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        }
        return connection;
    }

    /**
     * Close connection.
     *
     * @throws SQLException the sql exception
     */
    public static void closeConnection() throws SQLException{
        if(null != connection && !connection.isClosed()){
            connection.close();
        }
    }
}
