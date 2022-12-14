package fr.teamrocket.auctionrocket.bo;

public class Retrait {
	private Article article;
	private String rue;
	private String codePostal;
	private String ville;
	
	@Override
	public String toString() {
		return "Retrait [getArticle()=" + getArticle() + ", getRue()=" + getRue() + ", getCodePostal()="
				+ getCodePostal() + ", getVille()=" + getVille() + "]";
	}

	public Retrait() {
		
	}
	
	public Retrait(Article article, String rue, String codePostal, String ville) {
		super();
		this.setArticle(article);
		this.setRue(rue);
		this.setCodePostal(codePostal);
		this.setVille(ville);
	}
	
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
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

	
}