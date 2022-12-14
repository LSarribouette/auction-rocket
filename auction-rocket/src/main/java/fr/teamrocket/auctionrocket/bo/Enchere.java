package fr.teamrocket.auctionrocket.bo;

import java.sql.Date;

public class Enchere {
	private int noEnchere;
	private Utilisateur utilisateur;
	private Article article;
	private Date dateEnchere;
	private int montantEnchere;
	
	
	
	@Override
	public String toString() {
		return "Enchere [getNoEnchere()=" + getNoEnchere() + ", getArticle()=" + getArticle() + ", getDateEnchere()="
				+ getDateEnchere() + ", getMontantEnchere()=" + getMontantEnchere() + "]";
	}

	public Enchere() {
		
	}
	
	public Enchere(int noEnchere, Utilisateur utilisateur, Article article, Date dateEnchere, int montantEnchere) {
		super();
		this.setNoEnchere(noEnchere);
		this.setUtilisateur(utilisateur);
		this.setArticle(article);
		this.setDateEnchere(dateEnchere);
		this.setMontantEnchere(montantEnchere);
		}

	public int getNoEnchere() {
		return noEnchere;
	}
	public void setNoEnchere(int noEnchere) {
		this.noEnchere = noEnchere;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public Date getDateEnchere() {
		return dateEnchere;
	}
	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	public int getMontantEnchere() {
		return montantEnchere;
	}
	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}
}
