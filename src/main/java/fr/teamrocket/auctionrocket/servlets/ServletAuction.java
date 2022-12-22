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
import fr.teamrocket.auctionrocket.bll.UtilisateurManager;
import fr.teamrocket.auctionrocket.bo.Article;
import fr.teamrocket.auctionrocket.bo.Utilisateur;

/**
 * Servlet implementation class ServletAuctionHome
 */
@WebServlet("/auction")
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
		System.out.println("-------ServletAuction doGet----------");
		String articleIDString = request.getParameter("articleID").trim();
		int articleID = Integer.parseInt(articleIDString);
		
//		manager getarticlebyid
		Article article = ArticleManager.getInstance().fetchArticleByID(articleID);
		if(article != null) {
			request.setAttribute("article", article);
		}
		
		int sellerID = article.getUtilisateur().getNoUtilisateur();
		System.out.println("sellerID : " + sellerID);
		Utilisateur seller = UtilisateurManager.getInstance().fetchUtilisateurById(sellerID);
		System.out.println("seller : "+seller);
		if(seller != null) {
			request.setAttribute("seller", seller);
		}
				
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/auction.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-------ServletAuction doPost----------");

		doGet(request, response);
	}

}
