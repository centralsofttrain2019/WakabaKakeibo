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
import dto.UsersDto;
import service.DepositService;

/**
 * Servlet implementation class UpdateSimulationListServlet
 */
@WebServlet("/UpdateSimulationListServlet")
public class UpdateSimulationListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public UpdateSimulationListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("ta-01");

		SimulationListBean bean = new SimulationListBean();
		bean.setTargetAmount(Integer.parseInt(request.getParameter("targetAmount")) * 10000);




		//セッション取得
		ChatBean cBean =(ChatBean)request.getSession().getAttribute(ChatBean.USERINFO_SESSION_SAVE_NAME);

		UsersDto dto = cBean.getUsersDto();
		dto.setTargetAmount(bean.getTargetAmount());

		DepositService service = new DepositService();
		service.updateTargetAmount(cBean.getUsersDto());


		List<DepositDto> list = service.getDepositandSimulation(cBean.getUsersDto() );

		for(int i = 0; i < list.size(); i++) {

			bean.add(list.get(i), "Deposit" + i);

		}

		//beanをリクエストにセット キー名は「bean」とする
		request.setAttribute("bean", bean);

		//simulationList.jspに遷移する
        RequestDispatcher disp = request.getRequestDispatcher("/simulationList.jsp");
        disp.forward(request, response);


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
