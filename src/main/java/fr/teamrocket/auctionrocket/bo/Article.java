package fr.teamrocket.auctionrocket.bo;

import java.util.Date;

public class Article {
	private final static String DEFAULT_URL_IMAGE ="/auction-rocket/src/main/webapp/media/placeHolderDefault.jpg";
	
	private int noArticle;
	private String nomArticle;
	private String description;
	private Date dateDebutEnchere;
	private Date dateFinEnchere;
	private int prixInitial;
	private int prixVente;
	private Utilisateur utilisateur;
	private Categorie categorie;
	private String etatVente;
	private String utilisateurEncherisseur;
	private Retrait retrait;
	private String urlImage = DEFAULT_URL_IMAGE;
	

	@Override
	public String toString() {
		return "Article [getNoArticle()=" + getNoArticle() + ", getNomArticle()=" + getNomArticle()
				+ ", getDescription()=" + getDescription() + ", getDateDebutEnchere()=" + getDateDebutEnchere()
				+ ", getDateFinEnchere()=" + getDateFinEnchere() + ", getPrixInitial()=" + getPrixInitial()
				+ ", getPrixVente()=" + getPrixVente() + ", getUtilisateur()=" + getUtilisateur() + ", getCategorie()="
				+ getCategorie() + ", getEtatVente()=" + getEtatVente() + ", getUtilisateurEncherisseur()="
				+ getUtilisateurEncherisseur() + ", getRetrait()=" + getRetrait() + ", getUrlImage()=" + getUrlImage() + "]";
	}	

	public Article() {
		
	}
	
	public Article(int noArticle) {
		this.setNoArticle(noArticle);
	}

//	constructeur pour handle le form de modif de profil
	public Article(
			String nomArticle, 
			String description, 
			Date dateDebutEnchere, 
			Date dateFinEnchere,
			int prixInitial, 
			Utilisateur utilisateur, 
			Categorie categorie, 
			Retrait retrait) {
		this();
		this.setNomArticle(nomArticle);
		this.setDescription(description); 
		this.setDateDebutEnchere(dateDebutEnchere);
		this.setDateFinEnchere(dateFinEnchere);
		this.setPrixInitial(prixInitial);
		this.setUtilisateur(utilisateur);
		this.setCategorie(categorie);
		this.setRetrait(retrait);
	}

	public Article(
			String nomArticle, 
			String description, 
			Date dateDebutEnchere, 
			Date dateFinEnchere,
			int prixInitial, 
			Utilisateur utilisateur, 
			Categorie categorie, 
			Retrait retrait, 
			String urlImage) {
		this();
		this.setUrlImage(urlImage);
	}
	
	public Article(String nomArticle, String description, Date dateDebutEnchere, Date dateFinEnchere,
			int prixInitial, int prixVente, Utilisateur utilisateur, Categorie categorie, String etatVente,Retrait retrait, String urlImage) {
		this(nomArticle, description, dateDebutEnchere, dateFinEnchere, prixInitial, utilisateur, categorie, retrait, urlImage);
		this.setEtatVente(etatVente);
	}
	
	public Article(int noArticle, String nomArticle, String description, Date dateDebutEnchere, Date dateFinEnchere,
			int prixInitial, int prixVente, Utilisateur utilisateur, Categorie categorie, String etatVente, String utilisateurEncherisseur) {
		this();
		this.setUtilisateurEncherisseur(utilisateurEncherisseur);
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

	public String getEtatVente() {
		return etatVente;
	}

	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}

	public String getUtilisateurEncherisseur() {
		return utilisateurEncherisseur;
	}

	public void setUtilisateurEncherisseur(String utilisateurEncherisseur) {
		this.utilisateurEncherisseur = utilisateurEncherisseur;
	}

	public Retrait getRetrait() {
		return retrait;
	}

	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}




}