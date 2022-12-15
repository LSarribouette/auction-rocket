package fr.teamrocket.auctionrocket.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.teamrocket.auctionrocket.bll.UtilisateurManager;
import fr.teamrocket.auctionrocket.bo.Utilisateur;


/**
 * Servlet implementation class ServletConnection
 */
@WebServlet({"/ServletConnection", "/connection/signup", "/connection/login", "/connection/logout"})
public class ServletConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConnection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		if URL
			if(request.getServletPath().equals("/connection/signup")) {
				request.setAttribute("requestType", "signup");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/connection-signup.jsp");
				rd.forward(request, response);
			}  else if(request.getServletPath().equals("/connection/logout")) {
//				TODO : session destroy
				System.out.println("THE USER HAS TO BE DISCONNECTED");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/home.jsp");
				rd.forward(request, response);
			}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/connection-login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		reception login form, check user ok in DB, IF OK we go create session and  -> /auction/home
		String pseudo = request.getParameter("pseudo");
		String pwd = request.getParameter("pwd");
		System.out.println(pseudo + " - " + pwd);
		Utilisateur utilisateur = UtilisateurManager.getInstance().fetchUtilisateurByPseudoAndMdp(request.getParameter("pseudo"), request.getParameter("pwd"));
		System.out.println(utilisateur);
		if(utilisateur!=null) {
			System.out.println("user connected ! :)");
//			CREATE SESSION AVEC LOBJET USER
		} else {
			System.out.println("user unknow ! :(");
		}
	}

}
