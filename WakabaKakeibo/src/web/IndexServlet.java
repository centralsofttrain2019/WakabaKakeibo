package web;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MessageBean;
import bean.MessageListBean;
import service.UsersService;


/**
 * Servlet implementation class IndexStartServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


				//ユーザの好感度の取得
				//ここではユーザの好感度は0－2を考えている
				//とりあえず0を代入する
				int userFeelingLevel = 0;

				//Userの好感度をMessageIdへ代入
				//0:嫌い 1:好き 2:普通
				int messageId = 0;

				//時間の取得
				LocalDateTime ld = LocalDateTime.now();

				//MessageListBeanの生成
				MessageListBean mListBean = new MessageListBean();

				//Message用のListの生成
				List<MessageBean> mList = new ArrayList();



				//サービスを取得
				UsersService service = new UsersService();

				//ユーザーの誕生日の取り出し
				//Dtoからユーザの誕生日を取り出す
				LocalDateTime userBirthDay = LocalDateTime.now();


				mList.add(getGreeting(service, ld, messageId));
				mList.add(getBirth(service, ld, userBirthDay, userFeelingLevel));

				//MessageBeanのListをMessageListBeanへset
				mListBean.setmBeanList(mList);

				request.setAttribute("bean", mListBean);

				//JSPに遷移する
				RequestDispatcher disp = request.getRequestDispatcher("/index.jsp");
				disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	//挨拶の取得
	public MessageBean getGreeting(UsersService service, LocalDateTime ld, int messageId) {

		//朝、昼、夜によって、messageIdの値を変える
		//朝1－3、昼4－6、夜7－9
		if(6 < ld.getHour() && ld.getHour() < 12) {
			messageId += 0;
		}else if(12 < ld.getHour() && ld.getHour() < 18) {
			messageId += 3;
		}else{
			messageId += 6;
		};

		//挨拶メッセージの取得
		MessageBean beanGreeting = service.findById(messageId);

		return beanGreeting;

	}

	//誕生日メッセージの取得
	public MessageBean getBirth(UsersService service, LocalDateTime ld, LocalDateTime userBirthDay, int userFeelingLevel) {

		MessageBean beanBirth = null;

		//今日がユーザの誕生日ならば誕生日コメントを取得
		if(userBirthDay.getDayOfMonth() == ld.getDayOfMonth() &&
				userBirthDay.getMonth() == ld.getMonth()) {

			//誕生日メッセージのIDが10－12のため10を足す
			beanBirth = service.findById(userFeelingLevel + 10);

		}
		return beanBirth;
	}

}
