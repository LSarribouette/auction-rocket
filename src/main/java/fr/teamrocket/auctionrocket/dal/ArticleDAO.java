package fr.teamrocket.auctionrocket.dal;

import java.util.List;

import fr.teamrocket.auctionrocket.bo.Article;
import fr.teamrocket.auctionrocket.bo.Categorie;
import fr.teamrocket.auctionrocket.bo.Utilisateur;

public interface ArticleDAO {
	
	public abstract void insertArticle(Utilisateur utilisateur, Article article, Categorie categorie);

//	TOUT
	public abstract List<Article> listAll();
	
//	ACHAT
	public abstract List<Article> listAllAuctions();
	
//	ACHAT/enchères ouvertes
	public abstract List<Article> listAllOngoingAuctions();
	
//	Achat/mes encheres en cours
	public abstract List<Article> listOngoingUserAuctions();	
	
//	Achat/mes encheres remportées
	public abstract List<Article> listWonUserAuctions();
	
//	VENTE
	public abstract List<Article> listAllSales();
	
//	VENTE/mes ventes enc ours
	public abstract List<Article> listOngoinUserSales();
	
//	VENTE/ventes non débuté
	public abstract List<Article> listUnstartedUserSales();
	
//	VENTE/ventes terminées
	public abstract List<Article> listEndedUserSales();

}