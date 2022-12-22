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
 * Servlet implementation class ServletHome
 */
@WebServlet({"/home"})
public class ServletHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--------ServletHome doGet-------------");
		HttpSession session = request.getSession(false);
		
		if (session.getAttribute("current_user") != null) {
			doGetConnected(request, response);
			return;
		}
		List<Article> articles = ArticleManager.getInstance().listAll();
        request.setAttribute("articles", articles);            
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/home.jsp");
		rd.forward(request, response);
	}
	
	protected void doGetConnected(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Si j'arrive ici, je suis connectée et donc je vois les filtres ACHATS/VENTES --> par défaut, je veux voir la liste ACHATS (listAllAuctions) 
	
		
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("current_user");
		session.setAttribute("current_pseudo", utilisateur.getPseudo());
				
		List<Article> articles = ArticleManager.getInstance().listAllAuctions(utilisateur);
        request.setAttribute("articles", articles);     
		request.setAttribute("buying", "koshed"); 
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/home.jsp");
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
