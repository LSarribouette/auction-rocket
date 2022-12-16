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
////		TODO review this doGet with listAll inited from home.jsp
//		List<Article> articles = new ArrayList<>();
//		if(request.getParameter("search-filter")!= null || request.getParameter("search-filter").equals("home-listAll")) {
//			System.out.println("listAll requested from home.jsp");
//			
//			articles = ArticleManager.getInstance().listAll();
//	        request.setAttribute("articles", articles);
//	        
////	        est ce que je veux vraiment aller sur auction-home.jsp depuis le doGet de ServletSearch ?
//	        
//			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/auction-home.jsp");
//			rd.forward(request, response);
//		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		HttpSession session = request.getSession(false);
		System.out.println(session);
		
		List<Article> articles = new ArrayList<>();
		
		if (session == null) {
			System.out.println("submit d'une recherche sans session");
			
			articles = ArticleManager.getInstance().listAll();
	        request.setAttribute("articles", articles);
	        
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/home.jsp");
			rd.forward(request, response);
			
		} else if (session != null) {
			
			// ACHAT
			if(request.getParameter("radio-action")!=null && request.getParameter("radio-action").toString().equals("buying")) {
				System.out.println("radio bouton sélectionné : " + request.getParameter("radio-action"));
				
				if (request.getParameter("all-ongoing-auctions")!=null) {
					System.out.println("case cochée: all-ongoing-auctions");
					List<Article> articlesAllOngoingAuctions = ArticleManager.getInstance().listAllOngoingAuctions();
					articles.addAll(articlesAllOngoingAuctions);
				}
				
				if (request.getParameter("ongoing-user-auctions")!=null) {
					System.out.println("case cochée: ongoing-user-auctions");
					List<Article> articlesOngoingUserAuctions = ArticleManager.getInstance().listOngoingUserAuctions();
					articles.addAll(articlesOngoingUserAuctions);
				}
				
				if (request.getParameter("won-user-auctions")!=null) {
					System.out.println("case cochée: won-user-auctions");
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
			} else if(request.getParameter("radio-action")!=null && request.getParameter("radio-action").toString().equals("sales")) {
				System.out.println("radio bouton sélectionné : " + request.getParameter("radio-action"));
				
				if (request.getParameter("ongoing-user-sales")!=null) {
					System.out.println("case cochée: ongoing-user-sales");
					List<Article> articlesOngoingUserSales = ArticleManager.getInstance().listOngoinUserSales();
					articles.addAll(articlesOngoingUserSales);
				}
				
				if (request.getParameter("unstarted-user-sales")!=null) {
					System.out.println("case cochée: unstarted-user-sales");
					List<Article> articlesUnstartedUserSales = ArticleManager.getInstance().listUnstartedUserSales();
					articles.addAll(articlesUnstartedUserSales);
				}
				
				if (request.getParameter("ended-user-sales")!=null) {
					System.out.println("case cochée: ended-user-sales");
					List<Article> articlesEndedUserSales = ArticleManager.getInstance().listEndedUserSales();
					articles.addAll(articlesEndedUserSales);
				}
					
				if (articles.isEmpty()) {
					articles = ArticleManager.getInstance().listAllSales();
				} 
				
		        request.setAttribute("articles", articles);  
		    	
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/auction-home.jsp");
				rd.forward(request, response);
				
			
			// AUCUN FILTRE
			} else {
				System.out.println("Aucun filtre sélectionné");
				
				articles = ArticleManager.getInstance().listAll();
		        request.setAttribute("articles", articles);
		        
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/auction-home.jsp");
				rd.forward(request, response);
			}
		}
	}

}
