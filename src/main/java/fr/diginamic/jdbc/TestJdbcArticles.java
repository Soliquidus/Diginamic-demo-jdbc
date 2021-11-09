package fr.diginamic.jdbc;

import fr.diginamic.bll.ArticleManager;
import fr.diginamic.bll.FournisseurManager;

/**
 * Class TestJdbcArticles
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 04/11/2021
 */
public class TestJdbcArticles {
    private static final FournisseurManager fournisseurManager = new FournisseurManager();
    private static final ArticleManager articleManager = new ArticleManager();

    public static void main(String[] args) {
//        fournisseurManager.ajouterFournisseur("La Maison de la Peinture");
        articleManager.ajouterArticle("P01", "Peinture blanche 1L", 12.5, 11);
        articleManager.ajouterArticle("P02", "Peinture rouge mate 1L", 15.5, 11);
        articleManager.ajouterArticle("P03", "Peinture noire laquée 1L", 17.8, 11);
        articleManager.ajouterArticle("P03", "Peinture bleue mate 1L", 15.5, 11);

        articleManager.updateArticle(12, "P02", "Peinture rouge mate 1L", 11.6, 11);
        articleManager.updateArticle(15, "P04", "Peinture bleue mate 1L", 11.6, 11);

        articleManager.voirArticles();
        articleManager.calculerMoyenne();
        articleManager.deleteArticleByName("Peinture");
    }
}