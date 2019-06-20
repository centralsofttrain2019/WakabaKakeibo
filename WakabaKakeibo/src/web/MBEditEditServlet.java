package web;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MBEditEditBean;
import domain.BlogCategoryEnum;
import service.BlogService;

/**
 * Servlet implementation class MBEditServlet
 */
@WebServlet("/MBEditEditServlet")
public class MBEditEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MBEditEditServlet() {
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

		//時間の取得
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		//コメントのrequestがあれば
		if(request.getParameter("blogIDUp") != null) {
			//コメントのインサート
			updateBlog(request, timestamp);

			//JSPに遷移
			RequestDispatcher disp = request.getRequestDispatcher("CommentServlet");
			disp.forward(request, response);
			return;

		}

		//contentの取得
		String userName = request.getParameter("userName");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String category = request.getParameter("category");
		String blogID = request.getParameter("blogID");

		MBEditEditBean mbEditBean = new MBEditEditBean();

		mbEditBean.setUserName(userName);
		mbEditBean.setTitle(title);
		mbEditBean.setCategory(category);
		mbEditBean.setContent(content);
		mbEditBean.setBlogID(blogID);

		request.setAttribute("bean", mbEditBean);


		//JSPに遷移
		RequestDispatcher disp = request.getRequestDispatcher("/mBEditEdit.jsp");
		disp.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	public void updateBlog(HttpServletRequest request, Timestamp timestamp) {
		//contentの取得
		String Content = request.getParameter("ContentUp");
		Content = Content.replaceAll("\r\n", "<br>");

		//contentの取得
		String title = request.getParameter("titleUp");
		//contentの取得
		BlogCategoryEnum category = BlogCategoryEnum.valueOf(request.getParameter("categoryUp"));
		int blogID = Integer.parseInt(request.getParameter("blogIDUp"));

//		//sessionからユーザーIDの取得
//		int userID = 1;//テストです。
		//image1
		String image1 = null;
		//image2
		String image2 = null;
		//ReblogID
		int ReblogID = 1;

		//サービスを取得
		BlogService service = new BlogService();
		//blogcomentsDBへinsert
		service.updateBlog(timestamp, title, Content, category, image1, image2, ReblogID, blogID);


	}

}
