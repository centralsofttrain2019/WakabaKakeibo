package web;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.HistoryBean;
import bean.HistoryListBean;
import service.MoneyNotesService;

/**
 * Servlet implementation class HistoryServlet
 */
@WebServlet("/HistoryListServlet")
public class HistoryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//サービスを取得
		MoneyNotesService service = new MoneyNotesService();
		HistoryListBean bean = service.findAllHistoryList(1); //引数にユーザID

		if(request.getParameter("year") != null){
			bean.setHistory_year(Integer.valueOf(request.getParameter("year")).intValue());
			bean.setHistory_month(Integer.valueOf(request.getParameter("month")).intValue());
			System.out.println("getYear");
		}

		// categoryNameでグルーピングする
		Map<String, List<HistoryBean>> map = bean.getHistoryList().stream().collect(Collectors.groupingBy(o -> o.getCategoryName()));


		bean.setMap(map);

		System.out.println("HistoryServlet");
		request.setAttribute("bean",bean);

		//JSPに遷移
		RequestDispatcher disp = request.getRequestDispatcher("/historyList.jsp");
		disp.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
