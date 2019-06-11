package web;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MessageBean2;
import bean.MessageListBean;
import domain.EventTypeEnum;
import domain.MessageTypeEnum;
import service.UsersService;


/**
 * Servlet implementation class IndexStartServlet
 */
@WebServlet("/IndexServlet2")
public class IndexServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet2() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("StartServletが実行されました。");

//		UsersServiceからselectAllですべてのメッセージをとってくる
		//サービスを取得
		UsersService service = new UsersService();
		MessageListBean bean = service.findAll();


		LocalDateTime ld = LocalDateTime.now();
		int hour = ld.getHour() / 8;

		EventTypeEnum mEnum = null;
		switch(hour) {
		case 0:
			mEnum = EventTypeEnum.MORNING;
			break;
		case 1:
			mEnum = EventTypeEnum.NOON;
			break;
		case 2:
			mEnum = EventTypeEnum.NIGHT;
			break;
		}


		MessageTypeEnum tEnum = MessageTypeEnum.LIKE;
		//MessageEnumの生成
//		MessageEnum mEnum = MessageEnum.morning;

		//MessageBeanの生成
		MessageBean2 mBean = new MessageBean2(mEnum, tEnum);

		//beanをリクエストにセット キー名は「bean」とする
		request.setAttribute("bean", mBean);

		//メッセージテスト用のリクエスト
		//消してよし
		request.setAttribute("bean", bean);

		//JSPに遷移する
//		RequestDispatcher disp = request.getRequestDispatcher("/index.jsp");
		RequestDispatcher disp = request.getRequestDispatcher("/test.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
