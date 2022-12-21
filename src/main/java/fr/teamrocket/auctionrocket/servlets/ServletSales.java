package fr.teamrocket.auctionrocket.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;

import java.sql.Date; 
//TODO : au secours
//import java.util.Date;

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
//
//		System.out.println("datetime-date-end "+request.getParameter("datetime-date-end"));
//		System.out.println("date-date-end "+request.getParameter("date-date-end"));
//		
//				
//		String initDateStart = request.getParameter("date-start");
//		String newDateStart = initDateStart.replace("T", " ");
//		
//		
//		System.out.println("date-start replace : "+newDateStart);
//		System.out.println("Date.valueOf(newDateStart) "+Date.valueOf(newDateStart));
//		
		System.out.println("date-end "+request.getParameter("date-end"));
		System.out.println("street "+request.getParameter("street"));
		System.out.println("postalcode "+request.getParameter("postalcode"));
		System.out.println("city "+request.getParameter("city"));
		
//		2022-12-20T22:42		formTIME
//		2022-12-24 00:08:00 	DBTime
//		String pattern = "yyyy-MM-dd HH:mm:ss";
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//		
//		String culdebli="2022-12-20T22:42";
//		String newcul =culdebli.replace("T", " ");
//		System.out.println("newcudebli "+newcul);
//		2022-12-20 22:42
		
//		String date_s = " 2011-01-18 00:00:00.0"; 
//		SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss"); 
//		Date date = dt.parse(date_s); 
//		SimpleDateFormat dt1 = new SimpleDateFormat("yyyyy-mm-dd");
//		
		
		
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
		
//		TODO : au secours		
//		Date dateStart = null;
//		Date dateEnd = null;
//		try {
//			dateStart = new SimpleDateFormat("dd-MMM-yyyy HH:mm.").parse(request.getParameter("date-start"));
//			dateEnd = new SimpleDateFormat("dd-MMM-yyyy HH:mm.").parse(request.getParameter("date-end"));
//		
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		LocalDate dateStart, dateEnd;
		
		LocalDate dateStart, dateEnd;
		
		Article article = new Article(
				request.getParameter("nom-article"),
				request.getParameter("description"),
//				Date.valueOf(request.getParameter("date-start")),
//				dateStart,
//				Date.valueOf(request.getParameter("date-start")),
//				Date.valueOf(request.getParameter("date-end")),
//				dateEnd,
				
//				Timestamp.valueOf(request.getParameter("date-start").toString()));
//				
//				Date.valueOf(request.getParameter("date-start").toString()),
//				Date.valueOf(request.getParameter("date-end").toString()),
//				
//				request.getParameter("date-start"),
//				request.getParameter("date-end"),
//				
//				je souhaite garder la possibilité de récup l'heure, donc je substring pour la virer, 
//				pour partir dans le traitement Date, sans heure 
				dateStart = LocalDate.parse(request.getParameter("date-start").substring(0,10)),
		        dateEnd = LocalDate.parse(request.getParameter("date-end").substring(0,10)),
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
