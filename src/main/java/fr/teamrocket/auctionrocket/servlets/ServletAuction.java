package fr.teamrocket.auctionrocket.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.teamrocket.auctionrocket.bo.Utilisateur;

/**
 * Servlet implementation class ServletAuctionHome
 */
@WebServlet({"/ServletAuctionHome", "/auction/home", "/auction/article/sell", "/auction/article/detail"})
public class ServletAuction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAuction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("current_user");
		request.setAttribute("currentPseudo", utilisateur.getPseudo());
		
		System.out.println(utilisateur.getNom());
			if(request.getServletPath().equals("/auction/article/detail")) {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/article-detail.jsp");
				rd.forward(request, response);
			}  else if(request.getServletPath().equals("/auction/article/sell")) {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/article-sell.jsp");
				rd.forward(request, response);
			}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/auction-home.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
