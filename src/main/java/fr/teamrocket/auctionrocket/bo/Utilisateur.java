package fr.teamrocket.auctionrocket.bo;

public class Utilisateur {
	private int noUtilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String codePostal;
	private String ville;
	private String mdp;
	private int credit = 0;
	private int administrateur = 0;
	
	@Override
	public String toString() {
		return "Utilisateur [getNoUtilisateur()=" + getNoUtilisateur() + ", getPseudo()=" + getPseudo() + ", getNom()="
				+ getNom() + ", getPrenom()=" + getPrenom() + ", getEmail()=" + getEmail() + ", getTelephone()="
				+ getTelephone() + ", getRue()=" + getRue() + ", getCodePostal()=" + getCodePostal() + ", getVille()="
				+ getVille() + ", getMdp()=" + getMdp() + ", getCredit()=" + getCredit() + ", getAdministrateur()="
				+ getAdministrateur() + "]";
	}
	
	public Utilisateur() {
		
	}
	
	public Utilisateur(int noUtilisateur) {
		this.setNoUtilisateur(noUtilisateur);
	}
	
//	constructeur pour handle le form de modif de profil
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String mdp) {
		this.setPseudo(pseudo);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setEmail(email);
		this.setTelephone(telephone);
		this.setRue(rue);
		this.setCodePostal(codePostal);
		this.setVille(ville);
		this.setMdp(mdp);
	}
	
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String mdp, int credit, int administrateur) {
		this(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, mdp);
		this.setCredit(credit);
		this.setAdministrateur(administrateur);	
	}

	public int getNoUtilisateur() {
		return noUtilisateur;
	}
	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
//	public boolean isAdministrateur() {
//		return administrateur;
//	}
	public void setAdministrateur(int administrateur) {
		this.administrateur = administrateur;
	}

	public int getAdministrateur() {
		return administrateur;
	}


}
