package fr.diginamic.jdbc.dao;

import fr.diginamic.jdbc.ConnectionManager;
import fr.diginamic.jdbc.entites.Article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe jdbc qui permet l'exécution des principales fonctionnalités
 * de gestion de l'entité Fournisseur
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 04 /11/2021
 */
public class ArticleDaoJdbc implements ArticleDao {
    private static final String SELECT_ALL_ARTICLES = "SELECT * FROM ARTICLE";
    private static final String INSERT_ARTICLE = "INSERT INTO ARTICLE (REF, DESIGNATION, PRIX, ID_FOU) VALUE (?, ?, ?, ?)";
    private static final String UPDATE_ARTICLE = "UPDATE ARTICLE SET ref=?, designation=?, prix=?, id_fou=? WHERE id=?";
    private static final String DELETE_ARTICLE = "DELETE FROM ARTICLE WHERE ref=?";
    private static final String DELETE_ARTICLES_BY_NAME = "DELETE FROM ARTICLE WHERE designation LIKE ?";

    @Override
    public List<Article> extraire() {
        List<Article> articles = new ArrayList<>();
        try {
            Connection connection = ConnectionManager.getConnection();
            try (PreparedStatement preparedStatement = connection
                    .prepareStatement(SELECT_ALL_ARTICLES)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    articles.add(new Article(resultSet.getInt(1),
                            resultSet.getString("Ref"),
                            resultSet.getString("Designation"),
                            resultSet.getDouble(4),
                            resultSet.getInt(5)));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return articles;
    }

    @Override
    public void insert(Article article) {
        try {
            Connection connection = ConnectionManager.getConnection();
            try (PreparedStatement preparedStatement = connection
                    .prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS)) {
                connection.setAutoCommit(false);
                preparedStatement.setString(1, article.getRef());
                preparedStatement.setString(2, article.getDesignation());
                preparedStatement.setDouble(3, article.getPrix());
                preparedStatement.setInt(4, article.getFournisseur());
                preparedStatement.executeUpdate();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    article.setId(resultSet.getInt(1));
                }
                connection.commit();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Article article) {
        try {
            Connection connection = ConnectionManager.getConnection();
            try (PreparedStatement prepareStatement = connection
                    .prepareStatement(UPDATE_ARTICLE)) {
                prepareStatement.setString(1, article.getRef());
                prepareStatement.setString(2, article.getDesignation());
                prepareStatement.setDouble(3, article.getPrix());
                prepareStatement.setInt(4, article.getFournisseur());
                prepareStatement.setInt(5, article.getId());
                prepareStatement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public boolean delete(Article article) {
        boolean delete = true;
        try {
            Connection connection = ConnectionManager.getConnection();
            try (PreparedStatement preparedStatement = connection
                    .prepareStatement(DELETE_ARTICLE)) {
                preparedStatement.setString(1, article.getRef());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            delete = false;
            System.out.println(e.getMessage());
        }
        return delete;
    }

    @Override
    public boolean deleteByName(String designation) {
        boolean delete = true;
        try {
            Connection connection = ConnectionManager.getConnection();
            try (PreparedStatement preparedStatement = connection
                    .prepareStatement(DELETE_ARTICLES_BY_NAME)) {
                preparedStatement.setString(1, designation);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            delete = false;
            System.out.println(e.getMessage());
        }
        return delete;
    }
}