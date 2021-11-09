package fr.diginamic.jdbc;

import fr.diginamic.bll.ArticleManager;
import fr.diginamic.bll.FournisseurManager;
import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.entites.Fournisseur;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class JdbcTests
{
    private static final FournisseurManager fournisseurManager = new FournisseurManager();
    private static final ArticleManager articleManager = new ArticleManager();

    @Test
    public void testInsertionFournisseur(){
        fournisseurManager.ajouterFournisseur("La maison de la Peinture");
    }

    @Test
    public void testVoirFournisseurs(){
        fournisseurManager.voirFournisseurs();
    }

    @Test
    public void testUpdateFournisseur(){
        fournisseurManager.updateFournisseur("La maison de la Peinture", "La maison des Peintures");
    }

    @Test
    public void testDeleteFournisseur(){
        Fournisseur maisonDesPeintures = new Fournisseur("La maison des Peintures");
        fournisseurManager.deleteFournisseur(maisonDesPeintures);
    }

    @Test
    public void testVoirArticles() {
        articleManager.voirArticles();
    }

    @Test
    public void testInsererArticle() {
        articleManager.ajouterArticle("T01", "Article de test", 150.75,1);
    }

    @Test
    public void testUpdateArticle() {
        articleManager.updateArticle(11,"T01","Renommage d'article de test",  150.75,1);
    }

    @Test
    public void testDeleteArticle() {
        Article articleTest = new Article("T01");
        articleManager.deleteArticle(articleTest);
    }

}
