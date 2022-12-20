package fr.teamrocket.auctionrocket.bll;

import java.util.List;

import fr.teamrocket.auctionrocket.bo.Article;
import fr.teamrocket.auctionrocket.bo.Utilisateur;
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
    
    public List<Article> listAllAuctions(Utilisateur utilisateurConnecte) {
        return DAOFactory.getArticleDAO().listAllAuctions(utilisateurConnecte);
    }
    
    public List<Article> listAllOngoingAuctions(Utilisateur utilisateurConnecte) {
    	return DAOFactory.getArticleDAO().listAllOngoingAuctions(utilisateurConnecte);
    }
    
    public List<Article> listOngoingUserAuctions(Utilisateur utilisateurConnecte) {
    	return DAOFactory.getArticleDAO().listOngoingUserAuctions(utilisateurConnecte);
    }
    
    public List<Article> listWonUserAuctions(Utilisateur utilisateurConnecte) {
    	return DAOFactory.getArticleDAO().listWonUserAuctions(utilisateurConnecte);
    }

    public List<Article> listAllSales(Utilisateur utilisateurConnecte) {
    	return DAOFactory.getArticleDAO().listAllSales(utilisateurConnecte);
    }
    
    public List<Article> listOngoinUserSales(Utilisateur utilisateurConnecte) {
    	return DAOFactory.getArticleDAO().listOngoinUserSales(utilisateurConnecte);
    }
    
    public List<Article> listUnstartedUserSales(Utilisateur utilisateurConnecte) {
    	return DAOFactory.getArticleDAO().listUnstartedUserSales(utilisateurConnecte);
    }
    
    public List<Article> listEndedUserSales(Utilisateur utilisateurConnecte) {
    	return DAOFactory.getArticleDAO().listEndedUserSales(utilisateurConnecte);
    }
}

