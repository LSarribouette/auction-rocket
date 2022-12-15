package fr.teamrocket.auctionrocket.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.teamrocket.auctionrocket.bll.ArticleManager;
import fr.teamrocket.auctionrocket.bo.Article;

/**
 * Servlet implementation class ServletSearchBloc
 */
@WebServlet("/ServletSearchBloc")
public class ServletSearchBloc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSearchBloc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("radio-action"));
		
  
        
		if(request.getParameter("radio-action")!=null && request.getParameter("radio-action").toString().equals("buying")) {
			List<Article> articles = ArticleManager.getInstance().listAllAuctions();
	        request.setAttribute("articles", articles);
	    	
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/home.jsp");
			rd.forward(request, response);
		};
		
		
//		doGet(request, response);
	}

}
