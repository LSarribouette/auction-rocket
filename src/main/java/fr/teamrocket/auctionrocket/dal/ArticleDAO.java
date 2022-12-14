package fr.teamrocket.auctionrocket.dal;

import java.util.List;

import fr.teamrocket.auctionrocket.bo.Article;

public interface ArticleDAO {

//	filtrer TOUT enfin rien enfin voilà quoi
	public abstract List<Article> listAll();
	
//	filtrer ACHAT/tout
	public abstract List<Article> listAllAuctions();
	
//	filtrer ACHAT/enchères ouvertes
	public abstract List<Article> listAllOngoingAuctions();
	
//	Achat/mes encheres en cours
	public abstract List<Article> listOngoingUserAuctions();	
	
//	Achat/mes encheres remportées
	public abstract List<Article> listWonUserAuctions();
	
//	VENTE/mes ventes enc ours
	public abstract List<Article> listOngoinUserSales();
	
//	VENTE/ventes non débuté
	public abstract List<Article> listUnstartedUserSales();
	
//	VENTE/ventes terminées
	public abstract List<Article> listEndedUserSales();

}