package fr.teamrocket.auctionrocket.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.teamrocket.auctionrocket.bo.Article;
import fr.teamrocket.auctionrocket.bo.Categorie;
import fr.teamrocket.auctionrocket.bo.Utilisateur;

public class ArticleDAOJdbcImpl implements ArticleDAO {

	//TODO Factoriser le rs
	
	private final static String SELECT_ALL = 
			"SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente FROM articles;";
	
	private final static String SELECT_ALL_AUCTIONS = 
			"SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente FROM articles WHERE no_utilisateur !=?;";
	
	private final static String SELECT_ALL_ONGOING_AUCTIONS = 
			"SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente FROM articles WHERE no_utilisateur !=?  AND etat_vente ='en cours';";
	
	private final static String SELECT_ONGOING_USER_AUCTIONS = 
			"SELECT a.no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, a.no_utilisateur, no_categorie, etat_vente, u.pseudo FROM articles a INNER JOIN encheres e ON a.no_article = e.no_article INNER JOIN utilisateurs u ON e.no_utilisateur = u.no_utilisateur WHERE a.no_utilisateur !=? AND a.etat_vente ='en cours' AND e.no_utilisateur =?;";

	private final static String SELECT_WON_USER_AUCTIONS = 
			"SELECT a.no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, a.no_utilisateur, no_categorie, etat_vente, u.pseudo FROM articles a INNER JOIN encheres e ON a.no_article = e.no_article INNER JOIN utilisateurs u ON e.no_utilisateur = u.no_utilisateur WHERE a.no_utilisateur !=? AND a.etat_vente ='vendu' AND e.no_utilisateur =?;";
	
	private final static String SELECT_ALL_SALES =
			"SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente FROM articles WHERE no_utilisateur =?;";
	
	private final static String SELECT_ONGOING_USER_SALES = 
			"SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente FROM articles WHERE no_utilisateur =? AND etat_vente ='en cours';";
	
	private final static String SELECT_UNSTARTED_USER_SALES = 
			"SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente FROM articles WHERE no_utilisateur =? AND etat_vente ='non débuté';";
	
	private final static String SELECT_ENDED_USER_SALES = 
			"SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente FROM articles WHERE no_utilisateur =? AND etat_vente ='vendu';";
			
	
	@Override
	public List<Article> listAll() {
		List<Article> articles = new ArrayList<>();
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			System.out.println("je rentre dans le listall");
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL);
			Article article = null;
			while(rs.next()) {
				article = new Article();
				Utilisateur utilisateur = new Utilisateur(rs.getInt("no_utilisateur"));
				Categorie categorie = new Categorie(rs.getInt("no_categorie"));
				article.setNoArticle(rs.getInt("no_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDateDebutEnchere(rs.getDate("date_debut_encheres"));
				article.setDateFinEnchere(rs.getDate("date_fin_encheres"));
				article.setPrixInitial(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setUtilisateur(utilisateur);
				article.setCategorie(categorie);
				article.setEtatVente(rs.getString("etat_vente"));
				articles.add(article);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return articles;
	}

	@Override
	public List<Article> listAllAuctions(Utilisateur utilisateurConnecte) {
		List<Article> articles = new ArrayList<>();
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			System.out.println("je rentre dans le listallauctions");
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_AUCTIONS);
			pstmt.setInt(1, utilisateurConnecte.getNoUtilisateur()); 
			ResultSet rs = pstmt.executeQuery();
			Article article = null;
			while(rs.next()) {
				article = new Article();
				Utilisateur utilisateur = new Utilisateur(rs.getInt("no_utilisateur"));
				Categorie categorie = new Categorie(rs.getInt("no_categorie"));
				article.setNoArticle(rs.getInt("no_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDateDebutEnchere(rs.getDate("date_debut_encheres"));
				article.setDateFinEnchere(rs.getDate("date_fin_encheres"));
				article.setPrixInitial(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setUtilisateur(utilisateur);
				article.setCategorie(categorie);
				article.setEtatVente(rs.getString("etat_vente"));
				articles.add(article);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articles;
	}
	
	@Override
	public List<Article> listAllOngoingAuctions(Utilisateur utilisateurConnecte) {
		List<Article> articles = new ArrayList<>();
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			System.out.println("je rentre dans le listallongoingauctions");
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_ONGOING_AUCTIONS);
			pstmt.setInt(1, utilisateurConnecte.getNoUtilisateur());
			ResultSet rs = pstmt.executeQuery();
			Article article = null;
			while(rs.next()) {
				article = new Article();
				Utilisateur utilisateur = new Utilisateur(rs.getInt("no_utilisateur"));
				Categorie categorie = new Categorie(rs.getInt("no_categorie"));
				article.setNoArticle(rs.getInt("no_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDateDebutEnchere(rs.getDate("date_debut_encheres"));
				article.setDateFinEnchere(rs.getDate("date_fin_encheres"));
				article.setPrixInitial(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setUtilisateur(utilisateur);
				article.setCategorie(categorie);
				article.setEtatVente(rs.getString("etat_vente"));
				articles.add(article);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articles;
	}

	@Override
	public List<Article> listOngoingUserAuctions(Utilisateur utilisateurConnecte) {
		List<Article> articles = new ArrayList<>();
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			System.out.println("je rentre dans le listongoinguserauctions");
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ONGOING_USER_AUCTIONS);
			pstmt.setInt(1, utilisateurConnecte.getNoUtilisateur());
			pstmt.setInt(2, utilisateurConnecte.getNoUtilisateur());
			ResultSet rs = pstmt.executeQuery();
			Article article = null;
			while(rs.next()) {
				article = new Article();
				Utilisateur utilisateur = new Utilisateur(rs.getInt("no_utilisateur"));
				Categorie categorie = new Categorie(rs.getInt("no_categorie"));
				article.setNoArticle(rs.getInt("no_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDateDebutEnchere(rs.getDate("date_debut_encheres"));
				article.setDateFinEnchere(rs.getDate("date_fin_encheres"));
				article.setPrixInitial(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setUtilisateur(utilisateur);
				article.setCategorie(categorie);
				article.setEtatVente(rs.getString("etat_vente"));
				article.setUtilisateurEncherisseur(rs.getString("pseudo"));
				articles.add(article);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articles;
	}

	@Override
	public List<Article> listWonUserAuctions(Utilisateur utilisateurConnecte) {
		List<Article> articles = new ArrayList<>();
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			System.out.println("je rentre dans le listwonuserauctions");
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_WON_USER_AUCTIONS);
			pstmt.setInt(1, utilisateurConnecte.getNoUtilisateur());
			pstmt.setInt(2, utilisateurConnecte.getNoUtilisateur());
			ResultSet rs = pstmt.executeQuery();
			Article article = null;
			while(rs.next()) {
				article = new Article();
				Utilisateur utilisateur = new Utilisateur(rs.getInt("no_utilisateur"));
				Categorie categorie = new Categorie(rs.getInt("no_categorie"));
				article.setNoArticle(rs.getInt("no_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDateDebutEnchere(rs.getDate("date_debut_encheres"));
				article.setDateFinEnchere(rs.getDate("date_fin_encheres"));
				article.setPrixInitial(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setUtilisateur(utilisateur);
				article.setCategorie(categorie);
				article.setEtatVente(rs.getString("etat_vente"));
				article.setUtilisateurEncherisseur(rs.getString("pseudo"));
				articles.add(article);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articles;
	}

	@Override
	public List<Article> listAllSales(Utilisateur utilisateurConnecte) {
		List<Article> articles = new ArrayList<>();
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			System.out.println("je rentre dans le listallsales");
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_SALES);
			pstmt.setInt(1, utilisateurConnecte.getNoUtilisateur());
			ResultSet rs = pstmt.executeQuery();
			Article article = null;
			while(rs.next()) {
				article = new Article();
				Utilisateur utilisateur = new Utilisateur(rs.getInt("no_utilisateur"));
				Categorie categorie = new Categorie(rs.getInt("no_categorie"));
				article.setNoArticle(rs.getInt("no_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDateDebutEnchere(rs.getDate("date_debut_encheres"));
				article.setDateFinEnchere(rs.getDate("date_fin_encheres"));
				article.setPrixInitial(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setUtilisateur(utilisateur);
				article.setCategorie(categorie);
				article.setEtatVente(rs.getString("etat_vente"));
				articles.add(article);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articles;
	}
	
	@Override
	public List<Article> listOngoinUserSales(Utilisateur utilisateurConnecte) {
		List<Article> articles = new ArrayList<>();
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			System.out.println("je rentre dans le listongoingusersales");
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ONGOING_USER_SALES);
			pstmt.setInt(1, utilisateurConnecte.getNoUtilisateur());
			ResultSet rs = pstmt.executeQuery();
			Article article = null;
			while(rs.next()) {
				article = new Article();
				Utilisateur utilisateur = new Utilisateur(rs.getInt("no_utilisateur"));
				Categorie categorie = new Categorie(rs.getInt("no_categorie"));
				article.setNoArticle(rs.getInt("no_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDateDebutEnchere(rs.getDate("date_debut_encheres"));
				article.setDateFinEnchere(rs.getDate("date_fin_encheres"));
				article.setPrixInitial(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setUtilisateur(utilisateur);
				article.setCategorie(categorie);
				article.setEtatVente(rs.getString("etat_vente"));
				articles.add(article);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articles;
	}

	@Override
	public List<Article> listUnstartedUserSales(Utilisateur utilisateurConnecte) {
		List<Article> articles = new ArrayList<>();
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			System.out.println("je rentre dans le listongoingusersales");
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_UNSTARTED_USER_SALES);
			pstmt.setInt(1, utilisateurConnecte.getNoUtilisateur());
			ResultSet rs = pstmt.executeQuery();
			Article article = null;
			while(rs.next()) {
				article = new Article();
				Utilisateur utilisateur = new Utilisateur(rs.getInt("no_utilisateur"));
				Categorie categorie = new Categorie(rs.getInt("no_categorie"));
				article.setNoArticle(rs.getInt("no_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDateDebutEnchere(rs.getDate("date_debut_encheres"));
				article.setDateFinEnchere(rs.getDate("date_fin_encheres"));
				article.setPrixInitial(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setUtilisateur(utilisateur);
				article.setCategorie(categorie);
				article.setEtatVente(rs.getString("etat_vente"));
				articles.add(article);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articles;
	}

	@Override
	public List<Article> listEndedUserSales(Utilisateur utilisateurConnecte) {
		List<Article> articles = new ArrayList<>();
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			System.out.println("je rentre dans le listongoingusersales");
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ENDED_USER_SALES);
			pstmt.setInt(1, utilisateurConnecte.getNoUtilisateur());
			ResultSet rs = pstmt.executeQuery();
			Article article = null;
			while(rs.next()) {
				article = new Article();
				Utilisateur utilisateur = new Utilisateur(rs.getInt("no_utilisateur"));
				Categorie categorie = new Categorie(rs.getInt("no_categorie"));
				article.setNoArticle(rs.getInt("no_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDateDebutEnchere(rs.getDate("date_debut_encheres"));
				article.setDateFinEnchere(rs.getDate("date_fin_encheres"));
				article.setPrixInitial(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setUtilisateur(utilisateur);
				article.setCategorie(categorie);
				article.setEtatVente(rs.getString("etat_vente"));
				articles.add(article);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articles;
	}
	

}
