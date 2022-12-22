package fr.teamrocket.auctionrocket.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
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
		
//		il faut fetch la catégorie dans la DB LA
//		Pour l'instant test en dure, mais apres fetch selon le libellé ou id depuis le form
		Categorie categorie = new Categorie(
				1, "Art"
//			request.getParameter("category").toString()
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

//TRAVAUX mise en place message erreurs
		
		//form data rq
		
		String nomArticle = request.getParameter("nom-article");
		String descriptionArticle = request.getParameter("description");
		
//		je souhaite garder la possibilité de récup l'heure, donc je substring pour la virer, 
//		pour partir dans le traitement Date, sans heure 
//		dateStart = LocalDate.parse(request.getParameter("date-start").substring(0,10)),
//      dateEnd = LocalDate.parse(request.getParameter("date-end").substring(0,10)),
		
		String dateStartString = request.getParameter("date-start").substring(0,10);
		
		String dateEndString = request.getParameter("date-end").substring(0,10);
		
////////Conversion des données de la requête vers le bon type
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
//////////////// PROTECTION CONTRE L'INJECTION DE SCRIPT ////////////////////		
		
//		System.out.println(descriptionArticle);
//		String symbol="!! NON TU ARRETES !!";
//		descriptionArticle = descriptionArticle.replaceAll("[\\<\\>\\;\\{\\}]", " "+symbol+" ");
//		System.out.println(descriptionArticle);
		
////////////////PROTECTION CONTRE L'INJECTION DE SCRIPT ////////////////////
		
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
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/sale.jsp");
			rd.forward(request, response);
		} else {
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
			ArticleManager.getInstance().insertArticle(utilisateur, article, categorie);
			request.setAttribute("message", "article enregistré :)");
			doGet(request, response);
		}
	}
}