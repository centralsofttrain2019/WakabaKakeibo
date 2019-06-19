package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChatCommentServlet
 */
@WebServlet("/ChatCommentServlet")
public class ChatCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatCommentServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//家計簿データの登録をした場合
		if(request.getParameter("MoneyNoteSubmit") != null) {
			System.out.println("MoneyNoteSubmit!!");

			String productName = request.getParameter("product-name");



		}

		//家計簿データの登録をした場合
		if(request.getParameter("ChatPhrase") != null) {
			System.out.println("ChatPhrase!!");
		}

		//JSPに遷移する
		RequestDispatcher disp = request.getRequestDispatcher("/ChatServlet");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
