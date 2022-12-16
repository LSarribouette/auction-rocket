package fr.teamrocket.auctionrocket.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.teamrocket.auctionrocket.bll.ArticleManager;
import fr.teamrocket.auctionrocket.bo.Article;

/**
 * Servlet implementation class ServletSearch
 */
@WebServlet({"/ServletSearch", "/search"})
public class ServletSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSearch() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ServletSearch doGet putain de sa r");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		HttpSession session = request.getSession(false);
		System.out.println(session);
		
		List<Article> articles = new ArrayList<>();
		
		// si j'arrive ici, je suis connectée et donc je vois les filtres ACHATS/VENTES --> par défaut, je veux voir les ACHATS
		
		if(session.getAttribute("current_user") != null) { // TODO ce if serait mieux en try/catch ???
			// ACHAT
			if(request.getParameter("radio-action")!=null && request.getParameter("radio-action").equals("buying")) {
				System.out.println("radio bouton sélectionné : " + request.getParameter("radio-action")); //TODO supp
				request.setAttribute("buying", "koshed"); 
				
				if (request.getParameter("all-ongoing-auctions")!=null) {
					request.setAttribute("all-ongoing-auctions", "koshed");  
					System.out.println("case cochée: all-ongoing-auctions"); //TODO supp
					List<Article> articlesAllOngoingAuctions = ArticleManager.getInstance().listAllOngoingAuctions();
					articles.addAll(articlesAllOngoingAuctions);
				}
				
				if (request.getParameter("ongoing-user-auctions")!=null) {
					request.setAttribute("ongoing-user-auctions", "koshed");  
					System.out.println("case ongoing-user-auctions stays " + request.getAttribute("ongoing-user-auctions")); //TODO supp
					List<Article> articlesOngoingUserAuctions = ArticleManager.getInstance().listOngoingUserAuctions();
					articles.addAll(articlesOngoingUserAuctions);
					
					
				}
				
				if (request.getParameter("won-user-auctions")!=null) {
					request.setAttribute("won-user-auctions", "koshed");  
					System.out.println("case cochée: won-user-auctions"); //TODO supp
					List<Article> articlesWonUserAuctions = ArticleManager.getInstance().listWonUserAuctions();
					articles.addAll(articlesWonUserAuctions);
				}
					
				if (articles.isEmpty()) {
					articles = ArticleManager.getInstance().listAllAuctions();
				}
				
		        request.setAttribute("articles", articles);  
		    	
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/auction-home.jsp");
				rd.forward(request, response);
				
			// MES VENTES
			} else if(request.getParameter("radio-action")!=null && request.getParameter("radio-action").equals("sales")) {
				System.out.println("radio bouton sélectionné : " + request.getParameter("radio-action")); //TODO supp
				request.setAttribute("sales", "koshed"); 
				
				if (request.getParameter("ongoing-user-sales")!=null) {
					request.setAttribute("ongoing-user-sales", "koshed");  
					System.out.println("case cochée: ongoing-user-sales"); //TODO supp
					List<Article> articlesOngoingUserSales = ArticleManager.getInstance().listOngoinUserSales();
					articles.addAll(articlesOngoingUserSales);
				}
				
				if (request.getParameter("unstarted-user-sales")!=null) {
					request.setAttribute("unstarted-user-sales", "koshed");  
					System.out.println("case cochée: unstarted-user-sales"); //TODO supp
					List<Article> articlesUnstartedUserSales = ArticleManager.getInstance().listUnstartedUserSales();
					articles.addAll(articlesUnstartedUserSales);
				}
				
				if (request.getParameter("ended-user-sales")!=null) {
					request.setAttribute("ended-user-sales", "koshed"); 
					System.out.println("case cochée: ended-user-sales"); //TODO supp
					List<Article> articlesEndedUserSales = ArticleManager.getInstance().listEndedUserSales();
					articles.addAll(articlesEndedUserSales);
				}
					
				if (articles.isEmpty()) {
					articles = ArticleManager.getInstance().listAllSales();
				} 
				
		        request.setAttribute("articles", articles);  
		    	
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/auction-home.jsp");
				rd.forward(request, response);
				
			
			// AUCUN FILTRE : ne devrait pas arriver mais bon...
			} else {
				System.out.println("Aucun filtre sélectionné"); //TODO supp
				
				articles = ArticleManager.getInstance().listAll();
		        request.setAttribute("articles", articles);
		        
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/auction-home.jsp");
				rd.forward(request, response);
			}
		}
	}
}
