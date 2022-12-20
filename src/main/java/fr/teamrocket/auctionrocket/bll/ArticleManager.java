package fr.teamrocket.auctionrocket.bll;

import java.util.List;

import fr.teamrocket.auctionrocket.bo.Article;
import fr.teamrocket.auctionrocket.dal.DAOFactory;

public class ArticleManager {

    private static ArticleManager instance;
    
    public static ArticleManager getInstance() {
        if(instance == null) {
            instance = new ArticleManager();
        }
        return instance;
    }
    
    private ArticleManager() { }
    
    public List<Article> listAll() {
        return DAOFactory.getArticleDAO().listAll();
    }
    
    public List<Article> listAllAuctions() {
        return DAOFactory.getArticleDAO().listAllAuctions();
    }
    
    public List<Article> listAllOngoingAuctions() {
    	return DAOFactory.getArticleDAO().listAllOngoingAuctions();
    }
    
    public List<Article> listOngoingUserAuctions() {
    	return DAOFactory.getArticleDAO().listOngoingUserAuctions();
    }
    
    public List<Article> listWonUserAuctions() {
    	return DAOFactory.getArticleDAO().listWonUserAuctions();
    }

    public List<Article> listAllSales() {
    	return DAOFactory.getArticleDAO().listAllSales();
    }
    
    public List<Article> listOngoinUserSales() {
    	return DAOFactory.getArticleDAO().listOngoinUserSales();
    }
    
    public List<Article> listUnstartedUserSales() {
    	return DAOFactory.getArticleDAO().listUnstartedUserSales();
    }
    
    public List<Article> listEndedUserSales() {
    	return DAOFactory.getArticleDAO().listEndedUserSales();
    }
    
    public void insertArticle(Article article) {
    	DAOFactory.getArticleDAO().insertArticle(article);
    }
}

