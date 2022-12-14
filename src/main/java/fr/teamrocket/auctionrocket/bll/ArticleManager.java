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
}

