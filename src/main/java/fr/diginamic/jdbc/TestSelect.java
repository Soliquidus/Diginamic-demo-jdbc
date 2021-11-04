//package fr.diginamic.jdbc;
//
//import fr.diginamic.jdbc.entites.Fournisseur;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Classe pour tester la suppression en BDD
// *
// * @author Tibo Pfeifer
// * @version 1.0
// * @date 03/11/2021
// */
//public class TestSelect {
//    private static final ConnectionDatabase connectionDatabase = new ConnectionDatabase();
//
//    public static void main(String[] args) {
////        Exercice 4
//        connectionDatabase.getDriver();
//        listerFournisseurs();
//    }
//
//    private static void listerFournisseurs() {
//        List<Fournisseur> fournisseurs = new ArrayList<>();
//        try (Connection connection = DriverManager.getConnection(ConnectionDatabase.DB_URL, ConnectionDatabase.DB_USERNAME, ConnectionDatabase.DB_PASSWORD); Statement st = connection
//                .createStatement()) {
//            ResultSet resultSet = st.executeQuery("SELECT * FROM FOURNISSEUR");
//            while (resultSet.next()) {
//                fournisseurs.add(new Fournisseur(resultSet.getInt(1), resultSet.getString("Nom")));
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        for (Fournisseur fournisseur : fournisseurs) {
//            int id = fournisseur.getId();
//            String nom = fournisseur.getNom();
//            System.out.print("\nID - " + id + " : " + nom);
//        }
//    }
//}