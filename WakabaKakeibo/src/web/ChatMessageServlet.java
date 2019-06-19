package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ChatBean;
import bean.MessageBean;

/**
 * Servlet implementation class ChatMessageServlet
 */
@WebServlet("/ChatMessageServlet")
public class ChatMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String massage=request.getParameter("chatMessage");

		HttpSession session = request.getSession();

		ChatBean bean=(ChatBean)session.getAttribute(ChatBean.USERINFO_SESSION_SAVE_NAME);

		MessageBean msBean = new MessageBean();
		msBean.setMessageContent(massage);
		bean.getMessageListBean().getmBeanList().add(msBean);


		//session.setAttribute(ChatBean.USERINFO_SESSION_SAVE_NAME);





		//JSPに遷移する
		RequestDispatcher disp = request.getRequestDispatcher("ChatServlet");
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
