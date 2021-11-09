package fr.diginamic.jdbc.dao;

import fr.diginamic.jdbc.entites.Article;

import java.util.List;

/**
 * The interface Article dao.
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 04 /11/2021
 */
public interface ArticleDao {
    /**
     * Extraire list.
     *
     * @return the list
     */
    List<Article> extraire();

    /**
     * Insert.
     *
     * @param article the article
     */
    void insert(Article article);

    /**
     * Update.
     *
     * @param article the article
     */
    void update(Article article);

    /**
     * Delete boolean.
     *
     * @param article the article
     * @return the boolean
     */
    boolean delete(Article article);

    /**
     * Delete by name boolean.
     *
     * @param designation the designation
     * @return the boolean
     */
    boolean deleteByName(String designation);

}
