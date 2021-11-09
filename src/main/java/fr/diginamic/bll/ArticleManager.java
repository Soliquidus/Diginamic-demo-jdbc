package fr.diginamic.bll;

import fr.diginamic.jdbc.dao.DAOFactory;
import fr.diginamic.jdbc.dao.ArticleDao;
import fr.diginamic.jdbc.entites.Article;

import java.util.List;

/**
 * Class FournisseurManager
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 04/11/2021
 */
public class ArticleManager {
    private final ArticleDao articleDao;

    public ArticleManager() {
        this.articleDao = DAOFactory.getArticleDAO();
    }

    public void voirArticles() {
        List<Article> articles;
        articles = this.articleDao.extraire();
        for(Article article : articles){
            int id = article.getId();
            String ref = article.getRef();
            String designation = article.getDesignation();
            double prix = article.getPrix();
            int fournisseur = article.getFournisseur();

            System.out.print("\nId - " + id + " | Reference - " + ref + " | Designation - " + designation + " | Prix - "
                    + prix + " | Id fournisseur - " + fournisseur);
        }
    }

    public void ajouterArticle(String ref, String designation, double prix, int fournisseur){
        Article article = new Article();
        article.setRef(ref);
        article.setDesignation(designation);
        article.setPrix(prix);
        article.setFournisseur(fournisseur);
        articleDao.insert(article);
    }
    public void updateArticle(int id, String ref, String designation, double prix, int fournisseur){
        Article article = new Article();
        article.setId(id);
        article.setRef(ref);
        article.setDesignation(designation);
        article.setPrix(prix);
        article.setFournisseur(fournisseur);
        articleDao.update(article);
    }

    public void deleteArticle(Article article){
        boolean succes = articleDao.delete(article);
        if(succes){
            System.out.println("\nL'article a bien été supprimé");
        }
        else{
            System.out.println("\nLa suppression n'a pas eue lieu");
        }
    }

    public void deleteArticleByName(String designation){
        boolean succes = articleDao.deleteByName(designation);
        if(succes){
            System.out.println("\nL'article a bien été supprimé");
        }
        else{
            System.out.println("\nLa suppression n'a pas eue lieu");
        }
    }

    public void calculerMoyenne(){
        List<Article> articles;
        articles = this.articleDao.extraire();
        int somme = 0;
        for(Article article : articles){
            somme += article.getPrix();
        }
        int moyenne = somme/articles.size();
        System.out.println("\nLa moyenne des prix des articles est de : " + moyenne + " €");
    }
}