package fr.teamrocket.auctionrocket.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.teamrocket.auctionrocket.bo.Article;
import fr.teamrocket.auctionrocket.bo.Categorie;
import fr.teamrocket.auctionrocket.bo.Utilisateur;

public class ArticleDAOJdbcImpl implements ArticleDAO {

	private final static String SELECT_ALL="SELECT * FROM articles";
	
	@Override
	public List<Article> listAll() {
		List<Article> articles = new ArrayList<>();
		System.out.println("je suis dans ArticleDAOJdbcImpl listAll ");
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL);
			Article article = null;
			System.out.println("je suis dans le try Impl");
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
				System.out.println("je suis dans le while rs.next");
			}
			System.out.println("sorti de mon while rs.next");
			for (Article a : articles) {
				System.out.println(a);
			}
			
		} catch (Exception e) {
			System.out.println("KOUYE ArticleDAOIPLJDOJFSbgom");
			e.printStackTrace();
		}
		
		return articles;
	}
	
	private int extractUtilisateurId(Utilisateur utilisateur) {
		int idUtilisateur = utilisateur.getNoUtilisateur();
		return idUtilisateur;
	}

}
