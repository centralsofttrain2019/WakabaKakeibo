package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ChatBean;
import bean.SimulationListBean;
import dto.DepositDto;
import service.DepositService;

/**
 * Servlet implementation class SimulationListServlet
 */
@WebServlet("/SimulationListServlet")
public class SimulationListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimulationListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());


		//セッション取得
		ChatBean cBean =(ChatBean)request.getSession().getAttribute(ChatBean.USERINFO_SESSION_SAVE_NAME);

		if(cBean == null)
		{
			//JSPに遷移する
			RequestDispatcher disp = request.getRequestDispatcher("/index.html");
			disp.forward(request, response);
			return;
		}


		SimulationListBean bean = new SimulationListBean();
		DepositService service = new DepositService();

		List<DepositDto> list = service.getDepositandSimulation(cBean.getUsersDto());  //後でセッションから取り出す  修正：udをcBean

		for(int i = 0; i < list.size(); i++) {

			bean.add(list.get(i), "Deposit" + i);

		}


		bean.setTargetAmount(cBean.getUsersDto().getTargetAmount());
		//beanをリクエストにセット キー名は「bean」とする
		request.setAttribute("bean", bean);

		//simulationList.jspに遷移する
        RequestDispatcher disp = request.getRequestDispatcher("/simulationList.jsp");
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
