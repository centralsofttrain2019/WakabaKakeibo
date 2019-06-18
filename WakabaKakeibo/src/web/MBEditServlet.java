package web;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BlogCategoryEnum;
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
		if(request.getParameter("blogContent") != null) {
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

		//contentの取得
		String blogContent = request.getParameter("blogContent");
		//contentの取得
		String title = request.getParameter("title");
		//contentの取得
		BlogCategoryEnum category = BlogCategoryEnum.valueOf(request.getParameter("category"));

		//sessionからユーザーIDの取得
		int userID = 1;//テストです。
		//image1
		String image1 = null;
		//image2
		String image2 = null;
		//ReblogID
		int ReblogID = 1;

		//サービスを取得
		BlogService service = new BlogService();
		//blogcomentsDBへinsert
		service.insertBlog(userID, timestamp, title, blogContent, category, image1, image2, ReblogID);


	}

}
