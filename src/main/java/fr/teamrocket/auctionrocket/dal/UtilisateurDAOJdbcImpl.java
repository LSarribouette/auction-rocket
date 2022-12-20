package fr.teamrocket.auctionrocket.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import fr.teamrocket.auctionrocket.bo.Utilisateur;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

//	pas envie de factoriser les infal Strings de rq -> je ne connais pas l'évolution de l'appli ou sa DB
	private final static String INSERT_UTILISATEUR="INSERT INTO utilisateurs (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, (CAST(? AS bit)));";
	
	private final static String SELECT_UTILISATEUR_BY_PSEUDO_AND_PWD="SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur "
			+ "FROM utilisateurs "
			+ "WHERE pseudo =? AND mot_de_passe =?;";
	
	private final static String UPDATE_UTILISATEUR = "UPDATE utilisateurs "
			+ "SET pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postal=? ,ville=?, mot_de_passe=? "
			+ "WHERE (pseudo=? AND mot_de_passe=?);";

	@Override
	public void insertUtilisateur(Utilisateur utilisateur) {
		System.out.println("tentative d'insertion d'un Utilisateur en DB - "+utilisateur);
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

	@Override
	public Utilisateur fetchUtilisateurByPseudoAndMdp(String pseudo, String pwd) {
		Utilisateur utilisateur = null;
		ResultSet rs = null;
		try(Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_UTILISATEUR_BY_PSEUDO_AND_PWD);
			pstmt.setString(1, pseudo);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				utilisateur = new Utilisateur(rs.getInt("no_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCodePostal(rs.getString("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMdp(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setAdministrateur(rs.getInt("administrateur"));
				System.out.println("user -> "+utilisateur );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return utilisateur;
	}
	
	public Utilisateur updateUtilisateur(Utilisateur utilisateur, String pseudo, String pwd) {
//		en cas de pépins, c'est l'ancien utilisateur qui sera retourné
		Utilisateur updatedUtilisateur = utilisateur;
		ResultSet rs = null;
		try(Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_UTILISATEUR);
			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setString(5, utilisateur.getTelephone());
			pstmt.setString(6, utilisateur.getRue());
			pstmt.setString(7, utilisateur.getCodePostal());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMdp());
//			where -> ancien user
			pstmt.setString(10, pseudo);
			pstmt.setString(11, pwd);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updatedUtilisateur;
	}
	
}
