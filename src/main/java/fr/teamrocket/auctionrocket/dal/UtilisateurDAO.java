package fr.teamrocket.auctionrocket.dal;

import fr.teamrocket.auctionrocket.bo.Utilisateur;

public interface UtilisateurDAO {
	
	public abstract void insertUtilisateur(Utilisateur utilisateur);
	
	public abstract Utilisateur fetchUtilisateurById();

	public abstract Utilisateur fetchUtilisateurByPseudoAndMdp(String pseudo, String pwd);
	
}