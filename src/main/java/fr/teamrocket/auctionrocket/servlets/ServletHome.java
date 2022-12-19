package fr.teamrocket.auctionrocket.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.teamrocket.auctionrocket.bll.ArticleManager;
import fr.teamrocket.auctionrocket.bo.Article;

/**
 * Servlet implementation class ServletHome
 */
@WebServlet({"/ServletHome", "/home"})
public class ServletHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ServletHome : je passe ici à l'entrée dans l'appli et quand j'appuie sur le logo en non connecté");
		
		List<Article> articles = ArticleManager.getInstance().listAll();
        request.setAttribute("articles", articles);            
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/home.jsp");
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
