package fr.teamrocket.auctionrocket.bo;

import java.sql.Date;

public class Article {
	private int noArticle;
	private String nomArticle;
	private String description;
	private Date dateDebutEnchere;
	private Date dateFinEnchere;
	private int prixInitial;
	private int prixVente;
	private Utilisateur utilisateur;
	private Categorie categorie;
	
	@Override
	public String toString() {
		return "Article [getNoArticle()=" + getNoArticle() + ", getNomArticle()=" + getNomArticle()
				+ ", getDescription()=" + getDescription() + ", getDateDebutEnchere()=" + getDateDebutEnchere()
				+ ", getDateFinEnchere()=" + getDateFinEnchere() + ", getPrixInitial()=" + getPrixInitial()
				+ ", getPrixVente()=" + getPrixVente() + "]";
	}
	
	public Article() {
		
	}
	
	public Article(int noArticle, String nomArticle, String description, Date dateDebutEnchere, Date dateFinEnchere,
			int prixInitial, int prixVente, Utilisateur utilisateur, Categorie categorie) {
		this.setNoArticle(noArticle);
		this.setNomArticle(nomArticle);
		this.setDescription(description); 
		this.setDateDebutEnchere(dateDebutEnchere);
		this.setDateFinEnchere(dateFinEnchere);
		this.setPrixInitial(prixInitial);
		this.setPrixVente(prixVente);
		this.setUtilisateur(utilisateur);
		this.setCategorie(categorie);
	}

	public int getNoArticle() {
		return noArticle;
	}
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}
	public String getNomArticle() {
		return nomArticle;
	}
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateDebutEnchere() {
		return dateDebutEnchere;
	}
	public void setDateDebutEnchere(Date dateDebutEnchere) {
		this.dateDebutEnchere = dateDebutEnchere;
	}
	public Date getDateFinEnchere() {
		return dateFinEnchere;
	}
	public void setDateFinEnchere(Date dateFinEnchere) {
		this.dateFinEnchere = dateFinEnchere;
	}
	public int getPrixInitial() {
		return prixInitial;
	}
	public void setPrixInitial(int prixInitial) {
		this.prixInitial = prixInitial;
	}
	public int getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	
	
	
	
}