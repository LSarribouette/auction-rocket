package fr.teamrocket.auctionrocket.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.DateFormatter;

import fr.teamrocket.auctionrocket.bll.ArticleManager;
import fr.teamrocket.auctionrocket.bll.UtilisateurManager;
import fr.teamrocket.auctionrocket.bo.Article;
import fr.teamrocket.auctionrocket.bo.Categorie;
import fr.teamrocket.auctionrocket.bo.Retrait;
import fr.teamrocket.auctionrocket.bo.Utilisateur;

/**
 * Servlet implementation class ServletUserSales
 */
@WebServlet({"/ServletUserSales", "/user/mysales"})
public class ServletUserSales extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUserSales() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO arriver à mes ventes <=> AUCTIONHOME AVEC "MES VENTES"
		request.setAttribute("target", "mysales");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/auction-home.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("------------ServletUserSales doPost-----------");
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("current_user");
		System.out.println("current user is : "+utilisateur.getPseudo());
		
		System.out.println("nom-article "+request.getParameter("nom-article"));
		System.out.println("description "+request.getParameter("description"));
		System.out.println("category "+request.getParameter("category"));
		System.out.println("photo-article "+request.getParameter("photo-article"));
		System.out.println("prix-initial "+request.getParameter("prix-initial"));
		System.out.println("date-start "+request.getParameter("date-start"));
		System.out.println("date-end "+request.getParameter("date-end"));
		System.out.println("street "+request.getParameter("street"));
		System.out.println("postalcode "+request.getParameter("postalcode"));
		System.out.println("city "+request.getParameter("city"));
		
		
		Categorie categorie = new Categorie(
			request.getParameter("category").toString()
		); 
		
		Retrait retrait = new Retrait(
			request.getParameter("street"),
			request.getParameter("postalcode"),
			request.getParameter("city")
		);
		
		String photoArticle = null;
		
		if(request.getParameter("photo-article").toString()!=null) {
			photoArticle = request.getParameter("photo-article").toString(); 
		}
		
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
		Date dateStart = null;
		try {
			dateStart = (Date)formatter.parse(request.getParameter("date-start"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		Date dateEnd = null;
		try {
			dateEnd = (Date)formatter.parse(request.getParameter("date-end"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		Article article = new Article(
			request.getParameter("nom-article").toString(),
			request.getParameter("description").toString(),
		
			dateStart,
//			(Date)request.getParameter("date-start"),
			dateEnd,
//			(Date)request.getParameter("date-end"),
			
			Integer.parseInt(request.getParameter("prix-initial")),
//			utilisateur récupéré depuis la session
			utilisateur,

			categorie,
				
			retrait,
				
			photoArticle
		); 
		
		ArticleManager.getInstance()INSERT ARTICLE
		request.setAttribute("message", "utilisateur enregistré :)");
		doGet(request, response);
	}

}
