package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Article;
import dao.Dao;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/ArticleListServlet")
public class ArticleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Dao dao = new Dao();
		List<Article> articleList = dao.getArticleList();

		request.setAttribute("articleList" , articleList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/articleList.jsp");
		dispatcher.forward(request, response);
	}

}
