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
	public abstract List<Article> listAllAuctions(Utilisateur utilisateurConnecte);
	
//	ACHAT/enchères ouvertes
	public abstract List<Article> listAllOngoingAuctions(Utilisateur utilisateurConnecte);
	
//	Achat/mes encheres en cours
	public abstract List<Article> listOngoingUserAuctions(Utilisateur utilisateurConnecte);	
	
//	Achat/mes encheres remportées
	public abstract List<Article> listWonUserAuctions(Utilisateur utilisateurConnecte);
	
//	VENTE
	public abstract List<Article> listAllSales(Utilisateur utilisateurConnecte);
	
//	VENTE/mes ventes enc ours
	public abstract List<Article> listOngoinUserSales(Utilisateur utilisateurConnecte);
	
//	VENTE/ventes non débuté
	public abstract List<Article> listUnstartedUserSales(Utilisateur utilisateurConnecte);
	
//	VENTE/ventes terminées
	public abstract List<Article> listEndedUserSales(Utilisateur utilisateurConnecte);

}