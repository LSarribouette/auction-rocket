package fr.teamrocket.auctionrocket.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.teamrocket.auctionrocket.bll.UtilisateurManager;
import fr.teamrocket.auctionrocket.bo.Utilisateur;

/**
 * Servlet implementation class ServletUserProfile
 */
@WebServlet({"/user/showprofile", "/user/editprofile", "/user/deleteprofile"})
public class ServletUserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUserProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		TODO: recharger les infos en session
		
		if(request.getServletPath().equals("/user/editprofile")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/user-edit-profile.jsp");
			rd.forward(request, response);	
		} else if(request.getServletPath().equals("/user/deleteprofile")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/user-delete-profile.jsp");
			rd.forward(request, response);	
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/user-profile.jsp");
			rd.forward(request, response);	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO reception des infos de modif du profil
		System.out.println("---------ServletUserPofile doPost----------");
		HttpSession session = request.getSession(false);
		Utilisateur utilisateurBeforeEdit = (Utilisateur) session.getAttribute("current_user");
		System.out.println("BEFORE EDIT -> current user: "+utilisateurBeforeEdit.getNom());
		System.out.println("session ID : "+session.getId());
		System.out.println("pseudo from session : " + session.getAttribute("current_pseudo"));
		System.out.println("pseudo from form : " + request.getParameter("pseudo").toString());

		System.out.println("******utilisateurBeforeEdit******");
		System.out.println(utilisateurBeforeEdit.toString());
		
		Utilisateur utilisateurFromEdit = new Utilisateur(
				request.getParameter("pseudo").toString(),
				request.getParameter("nom").toString(),
				request.getParameter("prenom").toString(),
				request.getParameter("email").toString(),
				request.getParameter("telephone").toString(),
				request.getParameter("rue").toString(),
				request.getParameter("code-postal").toString(),
				request.getParameter("ville").toString(),
				request.getParameter("mot-de-passe").toString()
				); 

		System.out.println("******utilisateurFromEdit******");
		System.out.println(utilisateurFromEdit.toString());
		
		String pseudo = utilisateurBeforeEdit.getPseudo();
		String pwd = utilisateurBeforeEdit.getMdp();
		
		UtilisateurManager.getInstance().UpdateUtilisateur(utilisateurFromEdit, pseudo, pwd);
		request.setAttribute("message", "utilisateur enregistré :)");
		System.out.println("ServletUserProfile->doPost : utilisateur enregistré :)");

		
//		utilisateur modifié en DB, on le rechage dans la session (faudrait peut etre une fonction pour ça)
//		meme code que dans le login -> factoriser ? faire un sessionManager ?
		System.out.println("******session refresh******");
		System.out.println("old -> "+session.getAttribute("current_user"));
		
		pseudo = utilisateurFromEdit.getPseudo();
		pwd = utilisateurFromEdit.getMdp();
		
		Utilisateur utilisateur = UtilisateurManager.getInstance().fetchUtilisateurByPseudoAndMdp(pseudo, pwd);
		
		if(utilisateur != null) {
			session.setAttribute("current_user", utilisateur);
			System.out.println("session ID : "+session.getId());
			System.out.println(session.getAttribute("current_user"));
		}else {
//			TODO:erreur a gerer
			System.out.println("problem fetching, sessionning USER");
		}
		System.out.println("new -> "+session.getAttribute("current_user"));
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/user-profile.jsp");
		rd.forward(request, response);	
		
//		doGet(request, response);
	}

}
