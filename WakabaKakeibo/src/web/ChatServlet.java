package web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ChatBean;
import bean.MessageBean;
import bean.MessageListBean;
import domain.EventTypeEnum;
import domain.MessageTypeEnum;
import service.UsersService;


/**
 * Servlet implementation class IndexStartServlet
 */
@WebServlet("/ChatServlet")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException
	{
		ChatBean session = (ChatBean)request.getSession().getAttribute(ChatBean.USERINFO_SESSION_SAVE_NAME);
		//sessionが切れたときの処理
		if(session == null)
		{
			//JSPに遷移する
			RequestDispatcher disp = request.getRequestDispatcher("/index.html");
			disp.forward(request, response);
			// あとで、ログイオン画面にエラー表示を行う。あるいはそのまま（ログインできないだけ）

			return;
		}

		//サービスを取得
		UsersService service = new UsersService();

		//ユーザーの誕生日の取り出し
		//Dtoからユーザの誕生日を取り出す
		LocalDate userBirthDay = session.getUsersDto().getBirthday();

		//ユーザの好感度から好感度タイプの生成
		int userFeelingLevel = session.getUsersDto().getFeelingLevel();
		MessageTypeEnum mesType;
		if(userFeelingLevel == 0)
		{
			mesType = MessageTypeEnum.DISLIKE;
		}else if(userFeelingLevel == 7)
		{
			mesType = MessageTypeEnum.LIKE;
		}
		else
		{
			mesType = MessageTypeEnum.NORMAL;
		}

		//時間の取得
		LocalDateTime nowTime = LocalDateTime.now();

		//Message用のListの生成
		List<MessageBean> mList = new ArrayList<MessageBean>();


		//定型文の処理
		EventTypeEnum greetingMessage = (EventTypeEnum)request.getAttribute("greeting_message");
		//チャットメッセージの処理から遷移してきた場合のチャットメッセージ
		String mes = (String)request.getAttribute("wakaba_message");
		if(greetingMessage != null)
		{
			MessageBean yourMes = new MessageBean();
			if(greetingMessage == EventTypeEnum.MORNING)
			{
				yourMes.setMessageContent("おはよう");
			}
			else if(greetingMessage == EventTypeEnum.NOON)
			{
				yourMes.setMessageContent("こんにちは");
			}
			else if(greetingMessage == EventTypeEnum.NIGHT)
			{
				yourMes.setMessageContent("こんばんは");
			}
			yourMes.setSpeakerName(session.getUsersDto().getUserName());
			mList.add(yourMes);

			MessageBean wakabaMes = this.getGreeting(service, greetingMessage, mesType);
			mList.add(wakabaMes);
		}else if(mes != null) {
			String mesMe = (String)request.getAttribute("your_message");
			if(mesMe != null)
			{
				MessageBean yourMes = new MessageBean();
				yourMes.setMessageContent(mesMe);
				yourMes.setSpeakerName(session.getUsersDto().getUserName());
				mList.add(yourMes);
			}

			MessageBean wakabaMes = new MessageBean();
			wakabaMes.setMessageContent(mes);
			wakabaMes.setSpeakerName("わかば");
			mList.add(wakabaMes);
		}else {
			//挨拶メッセージの生成
			MessageBean greetingMes = getGreeting(service, nowTime, mesType);
			if(greetingMes != null) mList.add(greetingMes);

			//誕生日の際に誕生日メッセージを出す
			MessageBean birthMes = getBirth(service, userBirthDay, mesType);
			if(birthMes != null) mList.add(birthMes);
		}

		//MessageBeanのListをMessageListBeanへset
		MessageListBean mListBean = new MessageListBean();
		mListBean.setmBeanList( mList );

		ChatBean bean = new ChatBean();
		bean.setMessageListBean( mListBean );

		System.out.println(bean.getMessageListBean());
		request.setAttribute("bean", bean);

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

	//-------------------------------------------------------------------
	//挨拶の取得
	public MessageBean getGreeting(UsersService service, LocalDateTime ld, MessageTypeEnum messageType) {

		//朝、昼、夜によって、messageIdの値を変える
		//朝1－3、昼4－6、夜7－9
		EventTypeEnum eventType;
		if(6 <= ld.getHour() && ld.getHour() < 12) {
			eventType = EventTypeEnum.MORNING;
		}else if(12 <= ld.getHour() && ld.getHour() < 18) {
			eventType = EventTypeEnum.NOON;
		}else{
			eventType = EventTypeEnum.NIGHT;
		}

		MessageBean beanGreeting = service.findMessageByType(eventType, messageType);
		return beanGreeting;
	}

	public MessageBean getGreeting(UsersService service, EventTypeEnum eventType, MessageTypeEnum messageType) {
		MessageBean beanGreeting = service.findMessageByType(eventType, messageType);
		return beanGreeting;
	}

	//誕生日メッセージの取得
	public MessageBean getBirth(UsersService service, LocalDate userBirthDay, MessageTypeEnum messageType) {

		MessageBean beanBirth = null;
		LocalDate today = LocalDate.now();

		//今日がユーザの誕生日ならば誕生日コメントを取得
		if(userBirthDay.getDayOfMonth() == today.getDayOfMonth() &&
				userBirthDay.getMonth() == today.getMonth()) {
			beanBirth = service.findMessageByType(EventTypeEnum.BIRTHDAY, messageType);
		}
		return beanBirth;
	}

}
