package fr.teamrocket.auctionrocket.bll;

import fr.teamrocket.auctionrocket.bo.Utilisateur;
import fr.teamrocket.auctionrocket.dal.DAOFactory;

public class UtilisateurManager {
	
	private static UtilisateurManager instance;
	
	public static UtilisateurManager getInstance() {
		if(instance == null) {
			instance = new UtilisateurManager();
		}
		return instance;
	}
	
	private UtilisateurManager() { }
	
	public void insertUtilisateur(Utilisateur utilisateur) {
		DAOFactory.getUtilisateurDAO().insertUtilisateur(utilisateur);
	}
	
	public Utilisateur fetchUtilisateurById(int id) {
		return DAOFactory.getUtilisateurDAO().fetchUtilisateurById();
	}
	
	public Utilisateur fetchUtilisateurByPseudoAndMdp(String pseudo, String pwd) {
		return DAOFactory.getUtilisateurDAO().fetchUtilisateurByPseudoAndMdp(pseudo, pwd);
	}
	
	public Utilisateur UpdateUtilisateur(Utilisateur utilisateur, String pseudo, String pwd) {
		return DAOFactory.getUtilisateurDAO().updateUtilisateur(utilisateur, pseudo, pwd);
	};

}
