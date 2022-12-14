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
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
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
	
//	public List<Article> listBy
	

}
