package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import dao.Dao;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/EntryUserServlet")
public class EntryUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntryUserServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");

		Dao dao = new Dao();

		if(		!id.isBlank() //idが空もしくは空白のみではない
				&& dao.getUserById(id)==null //idが使用されていない
				&& password1.equals(password2) //確認用パスワードが一致
				&& !password1.isBlank() //passwordが空もしくは空白のみではない
				) {
			User userToEntry = new User(id, password1, name);
			dao.insertUser(userToEntry);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/login.jsp");
			dispatcher.forward(request, response);
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/entryUser.jsp");
			dispatcher.forward(request, response);
		}


	}

}
