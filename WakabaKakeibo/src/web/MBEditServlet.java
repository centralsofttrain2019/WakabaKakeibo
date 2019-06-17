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
 * Servlet implementation class MBEditServlet
 */
@WebServlet("/MBEditServlet")
public class MBEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MBEditServlet() {
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

		//コメントのrequestがあれば
		if(request.getParameter("formControlTextarea") != null) {
			//コメントのインサート
			insertBlog(request, timestamp);
		}


		//JSPに遷移
		RequestDispatcher disp = request.getRequestDispatcher("/mBEdit.jsp");
		disp.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	public void insertBlog(HttpServletRequest request, Timestamp timestamp) {
		//blogIDの取得
		int blogId = Integer.parseInt(request.getParameter("blogID"));
		//contentの取得
		String blogContent = request.getParameter("formControlTextarea");
		//sessionからユーザーIDの取得
		int userId = 1;//テストです。

		//サービスを取得
		BlogService service = new BlogService();
		//blogcomentsDBへinsert
		service.innerComment(userId, blogId, timestamp, blogContent);
	}

}
