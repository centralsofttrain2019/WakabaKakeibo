package web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MBCommentBean;
import bean.MBListBean;
import service.UsersService;

/**
 * Servlet implementation class MBListServlet
 */
@WebServlet("/MBListServlet")
public class MBListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MBListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		//CommentServletからのbeanを取得
		Map<Integer, List<MBCommentBean>> map = (Map<Integer, List<MBCommentBean>>)request.getAttribute("bean");

		//サービスを取得
		UsersService service = new UsersService();
		MBListBean mbBeanList = service.findAllBlog();

		//MBListBeanにMBCommentListBeanを持たせる
		mbBeanList.setMap(map);

		request.setAttribute("bean", mbBeanList);

		//JSPに遷移する
		RequestDispatcher disp = request.getRequestDispatcher("/mBlist.jsp");
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
