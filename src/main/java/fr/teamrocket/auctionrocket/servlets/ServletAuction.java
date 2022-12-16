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

import fr.teamrocket.auctionrocket.bll.ArticleManager;
import fr.teamrocket.auctionrocket.bo.Article;
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
//		Si j'arrive ici, je suis connectée et donc je vois les filtres ACHATS/VENTES --> par défaut, je veux voir la liste ACHATS
//			= Je veux pas listAll par défaut, mais bien listAllAuctions 		
		List<Article> articles = ArticleManager.getInstance().listAllAuctions();
        request.setAttribute("articles", articles);     

		request.setAttribute("buying", "koshed"); 
		
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
