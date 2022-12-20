package fr.teamrocket.auctionrocket.servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.teamrocket.auctionrocket.bll.ArticleManager;
import fr.teamrocket.auctionrocket.bo.Article;
import fr.teamrocket.auctionrocket.bo.Categorie;
import fr.teamrocket.auctionrocket.bo.Retrait;
import fr.teamrocket.auctionrocket.bo.Utilisateur;

/**
 * Servlet implementation class ServletSales
 */
@WebServlet({ "/sale/create", "/sale/edit", "/sale/delete" })
public class ServletSales extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSales() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/sale.jsp");
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
		
//		il faut fetch la catégorie dans la DB LA
//		Pour l'instant test en dure, mais apres fetch selon le libellé ou id
		Categorie categorie = new Categorie(
				1, "Art"
//			request.getParameter("category").toString()
		); 
		System.out.println("categorie :"+categorie.toString());
		
		Retrait retrait = new Retrait(
			request.getParameter("street"),
			request.getParameter("postalcode"),
			request.getParameter("city")
		);
		System.out.println("retrait :"+retrait.toString());
		
		String photoArticle = null;
		if(request.getParameter("photo-article").toString()!=null) {
			photoArticle = request.getParameter("photo-article").toString(); 
		}
		
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
		Date dateStart = null;
		Date dateEnd = null;
		try {
			dateStart = (Date)formatter.parse(request.getParameter("date-start"));
			dateEnd = (Date)formatter.parse(request.getParameter("date-end"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println("dateStart : "+dateStart);
		System.out.println("dateEnd : "+dateEnd);
		
		Article article = new Article(
				request.getParameter("nom-article").toString(),
				request.getParameter("description").toString(),
//				(Date)request.getParameter("date-start"),
				dateStart,
//				(Date)request.getParameter("date-end"),
				dateEnd,
				Integer.parseInt(request.getParameter("prix-initial")),
//				utilisateur récupéré depuis la session
				utilisateur,
				categorie,
				retrait,
				photoArticle
			); 
		System.out.println("article -> "+article.toString());
		
		ArticleManager.getInstance().insertArticle(utilisateur, article, categorie);
		request.setAttribute("message", "article enregistré :)");
		doGet(request, response);
	}
}
