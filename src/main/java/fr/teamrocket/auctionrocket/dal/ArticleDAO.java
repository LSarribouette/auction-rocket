package fr.teamrocket.auctionrocket.dal;

import java.util.List;

import fr.teamrocket.auctionrocket.bo.Article;

public interface ArticleDAO {

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