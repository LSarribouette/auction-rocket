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
		System.out.println("UTILISATEURMANAGER");
		System.out.println(utilisateur);
		DAOFactory.getUtilisateurDAO().insertUtilisateur(utilisateur);
	}
	
	public Utilisateur fetchUtilisateurById(int id) {
		return DAOFactory.getUtilisateurDAO().fetchUtilisateurById();
	}
	

}
