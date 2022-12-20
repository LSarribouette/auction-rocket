package fr.teamrocket.auctionrocket.bo;

public class Categorie {

	private int noCategorie;
	private String libelle;
	
	@Override
	public String toString() {
		return "Categorie [getNoCategorie()=" + getNoCategorie() + ", getLibelle()=" + getLibelle() + "]";
	}

	public Categorie() {
		
	}	
	
	public Categorie(int noCategorie) {
		this();
		this.setNoCategorie(noCategorie);
	}

	public Categorie(int noCategorie, String libelle) {
		this();
		this.setLibelle(libelle);
	}
	
	public int getNoCategorie() {
		return noCategorie;
	}
	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
