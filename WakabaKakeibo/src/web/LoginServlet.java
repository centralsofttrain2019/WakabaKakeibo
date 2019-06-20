package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ChatBean;
import dto.UsersDto;
import service.UsersService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//ログインでuserID,passwordが間違っている場合の処理
		String userIDstr = request.getParameter("userID");
		String password = request.getParameter("password");
		if( userIDstr != null && password!=null)
		{
			//ログイン処理
			boolean isLoginOK = logIn(request);
			if( !isLoginOK )
			{
				RequestDispatcher disp = request.getRequestDispatcher("/loginError.jsp");
				disp.forward(request, response);
				return;
			}
		}else
		{
			RequestDispatcher disp = request.getRequestDispatcher("/loginError.jsp");
			disp.forward(request, response);
			return;
		}

		RequestDispatcher disp = request.getRequestDispatcher("/ChatServlet");
		disp.forward(request, response);
		return;
	}

	//-------------------------------------------------------------------
	private boolean logIn(
			HttpServletRequest request
			)
					throws ServletException, IOException
	{
		UsersService service = new UsersService();

		String userIDstr = request.getParameter("userID");
		String password = request.getParameter("password");

		int userID = Integer.MAX_VALUE ;
		try {
			userID = Integer.parseInt(userIDstr);
		}
		catch( NumberFormatException e )
		{
			// あとで、ログイオン画面にエラー表示を行う。あるいはそのまま（ログインできないだけ）
			return false;
		}

		//ログインIDとパスワードを渡して、ユーザDTOを検索し、取得する
		UsersDto usersDto = service.getUser(userID, password );
		if( usersDto == null )
		{
			//ログインエラー画面に飛ぶ
			return false;
		}

		service.updateLoginDate(usersDto);

		//ログイン情報をセッションに保存する
		ChatBean bean = new ChatBean();
		bean.setUserID(userID);
		bean.setPassword(password);
		bean.setUsersDto(usersDto);
		request.getSession().setAttribute( ChatBean.USERINFO_SESSION_SAVE_NAME, bean );

		return true;
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
