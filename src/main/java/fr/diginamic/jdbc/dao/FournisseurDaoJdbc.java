package fr.diginamic.jdbc.dao;

import fr.diginamic.jdbc.ConnectionDatabase;
import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe jdbc qui permet l'exécution des principales fonctionnalités
 * de gestion de l'entité Fournisseur
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 04/11/2021
 */
public class FournisseurDaoJdbc implements FournisseurDao {
    private static final String SELECT_ALL_FOURNISSEURS = "SELECT * FROM FOURNISSEUR";
    private static final String INSERT_FOURNISSEUR = "INSERT INTO FOURNISSEUR (nom) VALUE (?)";
    private static final String DELETE_FOURNISSEUR = "DELETE FROM FOURNISSEUR WHERE nom = ?";

    @Override
    public List<Fournisseur> extraire() {
        List<Fournisseur> fournisseurs = new ArrayList<>();
        try (Connection connection = DriverManager
                .getConnection(ConnectionDatabase.DB_URL, ConnectionDatabase.DB_USERNAME, ConnectionDatabase.DB_PASSWORD); Statement st = connection
                .createStatement()) {
            ResultSet resultSet = st.executeQuery(SELECT_ALL_FOURNISSEURS);
            while (resultSet.next()) {
                fournisseurs.add(new Fournisseur(resultSet.getInt(1), resultSet.getString("Nom")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return fournisseurs;
    }

    @Override
    public void insert(Fournisseur fournisseur) {
        try (Connection connection = DriverManager
                .getConnection(ConnectionDatabase.DB_URL, ConnectionDatabase.DB_USERNAME, ConnectionDatabase.DB_PASSWORD);
             PreparedStatement preparedStatement = connection
                     .prepareStatement(INSERT_FOURNISSEUR, PreparedStatement.RETURN_GENERATED_KEYS)) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, fournisseur.getNom());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                fournisseur.setId(resultSet.getInt(1));
            }
            connection.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(String ancienNom, String nouveauNom) {
        try (Connection connection = DriverManager
                .getConnection(ConnectionDatabase.DB_URL, ConnectionDatabase.DB_USERNAME, ConnectionDatabase.DB_PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("UPDATE FOURNISSEUR SET nom='" + nouveauNom + "' WHERE nom='" + ancienNom + "'");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean delete(Fournisseur fournisseur) {
        boolean delete = true;
        try (Connection connection = DriverManager
                .getConnection(ConnectionDatabase.DB_URL, ConnectionDatabase.DB_USERNAME, ConnectionDatabase.DB_PASSWORD);
             PreparedStatement preparedStatement = connection
                     .prepareStatement(DELETE_FOURNISSEUR)) {
            preparedStatement.setString(1, fournisseur.getNom());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            delete = false;
            System.out.println(e.getMessage());
        }
        return delete;
    }
}