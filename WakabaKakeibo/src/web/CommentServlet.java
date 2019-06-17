package web;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MBCommentBean;
import bean.MBCommentListBean;
import service.BlogService;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
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
			insertComment(request, timestamp);
		}

//		いいねのrequestがあれば
		if(request.getParameter("like") != null) {
			//いいねのDB更新
			changeLike(request, timestamp);
		}

//		全コメントの取得
		Map<Integer, List<MBCommentBean>> map = takeAllCommentToMap(request);

		request.setAttribute("bean", map);

		//JSPに遷移する
		RequestDispatcher disp = request.getRequestDispatcher("/MBListServlet");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void insertComment(HttpServletRequest request, Timestamp timestamp) {
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
		System.out.println("hello");
	}

	public Map<Integer, List<MBCommentBean>> takeAllCommentToMap(HttpServletRequest request) {
		//サービスを取得
		BlogService service = new BlogService();
		MBCommentListBean mbCBeanList = service.findAllComment();

		// aでグルーピングする
		Map<Integer, List<MBCommentBean>> map = mbCBeanList.getMbCList().stream().collect(Collectors.groupingBy(o -> o.getBlogID()));

		return map;
	}

	public void changeLike(HttpServletRequest request, Timestamp timestamp) {
		//いいねデータの取得
		String like = request.getParameter("like");
		//blogIDの取得
		int blogId = Integer.parseInt(request.getParameter("blogID"));
		//sessionからユーザーIDの取得
		int userId = 1;//テストです。
		//サービスを取得
		BlogService service = new BlogService();
		//blogcomentsDBへinsert
		service.changeLike(userId, blogId, timestamp, like);

	}

}
