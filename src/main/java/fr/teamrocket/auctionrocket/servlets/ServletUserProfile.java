package fr.teamrocket.auctionrocket.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletUserProfile
 */
@WebServlet({"/ServletUserProfile", "/user/myprofile", "/user/editprofile", "/user/deleteprofile"})
public class ServletUserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUserProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getServletPath().equals("/user/myprofile")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/user-profile.jsp");
			rd.forward(request, response);	
		} else if(request.getServletPath().equals("/user/editprofile")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/user-edit-profile.jsp");
			rd.forward(request, response);	
		} else if(request.getServletPath().equals("/user/deleteprofile")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/user-delete-profile.jsp");
			rd.forward(request, response);	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
