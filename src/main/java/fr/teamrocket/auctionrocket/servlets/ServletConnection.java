package fr.teamrocket.auctionrocket.servlets;

import java.io.IOException;
import java.util.List;

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
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/connection-signup.jsp");
				rd.forward(request, response);
			}  else if(request.getServletPath().equals("/connection/login")) {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/connection-login.jsp");
				rd.forward(request, response);
			}  else if(request.getServletPath().equals("/connection/logout")) {
				HttpSession session = request.getSession();
//					TODO : session destroy
					System.out.println("invalidate session . . . ");
					session.invalidate();
					System.out.println("User is disconnected");
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/home.jsp");
					rd.forward(request, response);
			}

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
			HttpSession session = request.getSession();
			System.out.println("session ID : "+session.getId());
			session.setAttribute("current_user", utilisateur);
			System.out.println("session current user logged -> "+session.getAttribute("current_user"));
			RequestDispatcher rd = request.getRequestDispatcher("/auction/home");
			rd.forward(request, response);
		} else {
			System.out.println("user unknow ! :( BACK TO LOGIN");
			request.setAttribute("message", "USER UNKNOWN, retry or create account :)");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/connection-login.jsp");
			rd.forward(request, response);
			
		}
	}

}
