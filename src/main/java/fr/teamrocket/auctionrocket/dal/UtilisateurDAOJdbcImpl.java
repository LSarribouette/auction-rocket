package fr.teamrocket.auctionrocket.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.teamrocket.auctionrocket.bo.Utilisateur;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	
	private final static String INSERT_UTILISATEUR="\r\n"
			+ "INSERT INTO utilisateurs (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, (CAST(? AS bit)));";

	@Override
	public void insertUtilisateur(Utilisateur utilisateur) {
		System.out.println("ich bin dans utilisateur jdbcimlp");
		System.out.println(utilisateur);
//		PreparedStatement pstmt = null; JE SAIS PAS SI C'est mieux de mettre ça
		try(Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_UTILISATEUR);
			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setString(5, utilisateur.getTelephone());
			pstmt.setString(6, utilisateur.getRue());
			pstmt.setString(7, utilisateur.getCodePostal());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMdp());
			pstmt.setInt(10, utilisateur.getCredit()); 
			pstmt.setInt(11, utilisateur.getAdministrateur());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Utilisateur fetchUtilisateurById() {
		Utilisateur utilisateur = null;
		
		return utilisateur;
	}
	
}
