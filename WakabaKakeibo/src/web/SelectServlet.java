package web;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MessageBean;
import bean.MessageEnum;


/**
 * Servlet implementation class IndexStartServlet
 */
@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("StartServletが実行されました。");

		//画面から入力したデータを取得する
//		String num1str = request.getParameter("num1");
//		//String num2str = request.getParameter("num2");
//
//		//計算のために数値に変換する
//		int num1 = Integer.parseInt(num1str);


//		//次の画面で表示するための入れ物を準備する
//		EmployeeBean bean = new EmployeeBean();
//
//		Employee eList = Main2.main(num1);
//
//		//計算結果と表示するメッセージを入れ物（bean)にセットする
//		bean.setMessage("ID情報");
//		bean.setRs(eList);
//
//		//beanをリクエストにセット キー名は「bean」とする
//		request.setAttribute("bean", bean);

		LocalDateTime ld = LocalDateTime.now();
		int hour = ld.getHour() / 8;

		MessageEnum mEnum = null;
		switch(hour) {
		case 0:
			mEnum = MessageEnum.morning;
			break;
		case 1:
			mEnum = MessageEnum.noon;
			break;
		case 2:
			mEnum = MessageEnum.night;
			break;
		}

		//MessageEnumの生成
//		MessageEnum mEnum = MessageEnum.morning;

		//MessageBeanの生成
		MessageBean mBean = new MessageBean(mEnum);

		//beanをリクエストにセット キー名は「bean」とする
		request.setAttribute("bean", mBean);

		//JSPに遷移する
		RequestDispatcher disp = request.getRequestDispatcher("/chat.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
