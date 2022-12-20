package fr.teamrocket.auctionrocket.servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.teamrocket.auctionrocket.bll.UtilisateurManager;
import fr.teamrocket.auctionrocket.bo.Utilisateur;

/**
 * Servlet implementation class ServletRegister
 */
@WebServlet({"/ServletRegister", "/register"})
public class ServletRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("/register with user :(");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//TODO faire ça mieux, notemment avec les credit et admin
		Utilisateur utilisateur = new Utilisateur(
				request.getParameter("pseudo").toString(),
				request.getParameter("nom").toString(),
				request.getParameter("prenom").toString(),
				request.getParameter("email").toString(),
				request.getParameter("telephone").toString(),
				request.getParameter("rue").toString(),
				request.getParameter("code-postal").toString(),
				request.getParameter("ville").toString(),
				request.getParameter("mot-de-passe").toString(), 
//				TODO virer les 0, mettre un default coté DB ? profiter du constructeur sans credit et admin 
				0, 
				0
				); 
		UtilisateurManager.getInstance().insertUtilisateur(utilisateur);
		request.setAttribute("message", "utilisateur enregistré :)");
		doGet(request, response);
	}

}
