package fr.teamrocket.auctionrocket.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		System.out.println("current user is : "+session.getAttribute("current_user"));
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("current_user");
		
//TODO faire ça mieux, notemment avec les credit et admin
		Article article = new Article(
				request.getParameter("nom-article").toString(),
				request.getParameter("description").toString(),
				
//TODO:			request.getParameter("photo-article").toString(), 

				(Date) request.getParameter("date-start"),
				(Date) request.getParameter("date-end"),
				
				Integer.parseInt(request.getParameter("prix-initial")),
				utilisateur,

				request.getParameter("category").toString()
				
				Retrait retrait = new Retrait(
						request.getParameter("street"),
						request.getParameter("postalcode"),
						request.getParameter("city")
				),
				retrait
				); 
		UtilisateurManager.getInstance().insertUtilisateur(utilisateur);
		request.setAttribute("message", "utilisateur enregistré :)");
		doGet(request, response);
	}

}
