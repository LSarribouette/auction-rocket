package fr.teamrocket.auctionrocket.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ServletConnection
 */
@WebServlet({"/ServletConnection", "/connection/signup", "/connection/login", "/connection/logout"})
public class ServletConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConnection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		if URL
			if(request.getServletPath().equals("/connection/signup")) {
				request.setAttribute("requestType", "signup");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/connection-signup.jsp");
				rd.forward(request, response);
			}  else if(request.getServletPath().equals("/connection/logout")) {
//				TODO : session destroy
				System.out.println("THE USER HAS TO BE DISCONNECTED");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/home.jsp");
				rd.forward(request, response);
			}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/connection-login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
