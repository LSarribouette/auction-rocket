package fr.teamrocket.auctionrocket.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.sql.Date; 

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
import fr.teamrocket.auctionrocket.exception.BusinessException;

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
		
		
//		il faut fetch la catégorie dans la DB LA
//		Pour l'instant test en dure, mais apres fetch selon le libellé ou id depuis le form
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
		
//		LocalDate dateStart, dateEnd;
		
//		TODO :
//		fetchdetailarticle 
//		verif de ce qu'on construit le Article Avec;
//		JE FOUS DES REGEXP dans tous les sens
//		 JE TRAITE LES DATA lowercase, replace ;bytruc 
		
//		exemple:
//		if(nomArticle isValidString){
//		nomArticle=nomArticle.towercase
			

//TRAVAUX	mise en place message erreurs
		
		//form data rq
		
		String nomArticle = request.getParameter("nom-article");
		String descriptionArticle = request.getParameter("description");
		
//		je souhaite garder la possibilité de récup l'heure, donc je substring pour la virer, 
//		pour partir dans le traitement Date, sans heure 
//		dateStart = LocalDate.parse(request.getParameter("date-start").substring(0,10)),
//      dateEnd = LocalDate.parse(request.getParameter("date-end").substring(0,10)),
		
		String dateStartString = request.getParameter("date-start").substring(0,10);
		String dateEndString = request.getParameter("date-end").substring(0,10);

		
		//2. Conversion des données de la requête vers le bon type
		BusinessException be = new BusinessException();
//		TRAITEMENT DES DATES
		LocalDate dateStart = null;
		try {
			dateStart = LocalDate.parse(dateStartString);
		} catch (DateTimeParseException e) {
			e.printStackTrace();
			be.addError(ErrorCodes.FORMAT_DATE_INCORRECT);
		}
		LocalDate dateEnd = null;
		try {
			dateEnd = LocalDate.parse(dateEndString);
		} catch (DateTimeParseException e) {
			e.printStackTrace();
			be.addError(ErrorCodes.FORMAT_DATE_INCORRECT);
		}
		if(!dateStart.isBefore(dateEnd)) {
			be.addError(ErrorCodes.CHRONOLOGIE_INVALIDE);
		}
//		TRAITEMENT DES STRINGS nom, description
//		verification de l'emptiness des Strings
		if(nomArticle==null || nomArticle.isEmpty() || nomArticle.isBlank()) {
			be.addError(ErrorCodes.CHAMPS_VIDE);
		}
		if(descriptionArticle==null || descriptionArticle.isEmpty() || descriptionArticle.isBlank()) {
			be.addError(ErrorCodes.CHAMPS_VIDE);
		}
//		TRAITEMENT DES INT prixInitial
		String prixInitialString = request.getParameter("prix-initial");
		int prixInitial = 0;
		try {
			prixInitial = Integer.parseInt(prixInitialString);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			be.addError(ErrorCodes.FORMAT_NOMBRE_INVALIDE);
		}
		if(prixInitial <= 0) {
			be.addError(ErrorCodes.FORMAT_NOMBRE_INVALIDE);
		}
		
//		TRAITEMENT DES ERREURS POTENTIELLES
		if(be.hasErrors()) {
			request.setAttribute("errorCodeList", be.getErrorCodeList());
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/sale.jsp");
			rd.forward(request, response);
		} else {
			try {
				Article article = new Article(
						nomArticle,			
						descriptionArticle,
						dateStart,
						dateEnd,
						prixInitial,
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
}
