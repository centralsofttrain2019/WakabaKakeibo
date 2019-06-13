package web;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BlogService;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		//時間の取得
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		//blogIDの取得
		int blogId = Integer.parseInt(request.getParameter("blogID"));
		//contentの取得
		String content = request.getParameter("formControlTextarea");
		//sessionからユーザーIDの取得
		int userId = 1;//テストです。

		//サービスを取得
		BlogService service = new BlogService();
		service.innerComment(userId, blogId, timestamp, content);


		//テスト消してよし
//		request.setAttribute("bean", mbBeanList);
//		TestBean t = new TestBean();
//		t.setBlogID(Integer.parseInt(request.getParameter("blogID")));
//		t.setContent(request.getParameter("formControlTextarea"));

		//request.setAttribute("bean", t);

		//JSPに遷移する
		RequestDispatcher disp = request.getRequestDispatcher("/CommentServlet");
		disp.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
