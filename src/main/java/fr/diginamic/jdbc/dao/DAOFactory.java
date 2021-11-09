package fr.diginamic.jdbc.dao;

/**
 * Classe abstraite récupérant nos différentes DAO.
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 04/11/2021
 */
public abstract class DAOFactory {

    public static FournisseurDao getFournisseurDAO() {
        return new FournisseurDaoJdbc();
    }

    public static ArticleDao getArticleDAO() {
        return new ArticleDaoJdbc();
    }
}