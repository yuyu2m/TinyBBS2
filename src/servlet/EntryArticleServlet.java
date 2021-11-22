package servlet;

import java.io.IOException;

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
@WebServlet("/EntryArticleServlet")
public class EntryArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntryArticleServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		String editorId = (String) request.getSession().getAttribute("userId");

		Dao dao = new Dao();

		Article articleToEntry = new Article(title, body, editorId);
		dao.insertArticle(articleToEntry);

//		//登録した最新の記事を取得する場合は下記を使用
//		Article article = dao.getNewestArticleByEditorId(editorId);
//		request.setAttribute("article", article);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/ArticleListServlet");
		dispatcher.forward(request, response);
	}

}
