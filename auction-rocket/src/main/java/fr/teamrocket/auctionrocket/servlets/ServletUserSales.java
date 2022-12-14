package fr.teamrocket.auctionrocket.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		response.getWriter().append("Served at doPost ServletUseSales !!!: ").append(request.getContextPath());
//		TODO Traitement du post
		doGet(request, response);
	}

}
