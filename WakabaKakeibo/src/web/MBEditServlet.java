package web;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ChatBean;
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
		response.setContentType("text/html;charset=UTF-8");
		 request.setCharacterEncoding("UTF-8");


		ChatBean session = (ChatBean)request.getSession().getAttribute(ChatBean.USERINFO_SESSION_SAVE_NAME);
		if(session == null)
		{
			//JSPに遷移する
			RequestDispatcher disp = request.getRequestDispatcher("/index.html");
			disp.forward(request, response);
			return;
		}

		//時間の取得
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		//コメントのrequestがあれば
		if(request.getParameter("blogContent") != null) {
			//コメントのインサート
			insertBlog(request, timestamp, session);

//			//JSPに遷移
			RequestDispatcher disp = request.getRequestDispatcher("CommentServlet");
			disp.forward(request, response);
			return ;

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

	public void insertBlog(HttpServletRequest request, Timestamp timestamp, ChatBean session) {

		//contentの取得
		String blogContent = request.getParameter("blogContent");
		System.out.println(blogContent);
		blogContent = blogContent.replaceAll("\r\n", "<br>");
		//contentの取得
		String title = request.getParameter("title");
		//contentの取得
		BlogCategoryEnum category = BlogCategoryEnum.valueOf(request.getParameter("category"));

		//sessionからユーザーIDの取得
		int userID = session.getUserID();//テストです。
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
