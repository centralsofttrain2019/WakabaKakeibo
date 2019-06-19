package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ChatBean;
import bean.SimulationListBean;
import bean.UpdateSimulationListBean;
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

		UpdateSimulationListBean updateBean = new UpdateSimulationListBean();
		updateBean.setTargetAmount(Integer.parseInt(request.getParameter("targetAmount")));

		UsersDto dto = new UsersDto();
		dto.setTargetAmount(updateBean.getTargetAmount());

		//session  修正
		HttpSession session;
		ChatBean cBean = new ChatBean();
		//cBean = (ChatBean)session.getAttribute("UserInfo");


		//あとで削除
		UsersDto ud = new UsersDto();
		ud.setTargetAmount(dto.getTargetAmount());
		ud.setUserID(1);
		//ここまで

		DepositService service = new DepositService();
		service.updateTargetAmount(ud);					//修正 udをcBean


		SimulationListBean bean = new SimulationListBean();





		List<DepositDto> list = service.getDepositandSimulation( ud );  //後でセッションから取り出す

		for(int i = 0; i < list.size(); i++) {

			bean.add(list.get(i), "Deposit" + i);

		}

		bean.setTargetAmount(updateBean.getTargetAmount());

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
