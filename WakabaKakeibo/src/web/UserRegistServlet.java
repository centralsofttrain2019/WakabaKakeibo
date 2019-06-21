package web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserRegistBean;
import domain.UserSexEnum;
import dto.UsersDto;
import service.UsersService;

/**
 * Servlet implementation class UserRegistServlet
 */
@WebServlet("/UserRegistServlet")
public class UserRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		 response.setContentType("text/html;charset=UTF-8");
		 request.setCharacterEncoding("UTF-8");

		// 現在日付
		LocalDate date = LocalDate.now();

		//コメントのrequestがあれば
		if(request.getParameter("password") != null) {
			//コメントのインサート
			insertUser(request, response, date);

		}else {
		//JSPに遷移する
		RequestDispatcher disp = request.getRequestDispatcher("/userRegist.jsp");
		disp.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void insertUser(HttpServletRequest request, HttpServletResponse response, LocalDate date) throws ServletException, IOException{

		int userID = Integer.valueOf(request.getParameter("userID")).intValue();
		String password = request.getParameter("password");

		//サービスを取得
		UsersService service = new UsersService();
		if(service.getUserOnNew(userID) != null) {

			UserRegistBean errorBean = new UserRegistBean();
			errorBean.setError(true);

			request.setAttribute("bean", errorBean);
//			System.out.println("null");
//			System.out.println(service.getUserOnNew(userID).toString());

			//JSPに遷移する
			RequestDispatcher disp = request.getRequestDispatcher("/userRegist_error.jsp");
			disp.forward(request, response);

		}else {
			System.out.println("exitst");

		UsersDto uDto = new UsersDto();
		String monthString = String.format("%02d", Integer.valueOf(request.getParameter("month")).intValue());
		String dayString = String.format("%02d", Integer.valueOf(request.getParameter("day")).intValue());

		String honorific;
		if(request.getParameter("sex").equals("MAN")) {
			honorific = "さん";
		}else {
			honorific = "ちゃん";
		}

		String birthString = request.getParameter("year") + monthString + dayString;
		LocalDate birth = convertToLocalDate(birthString, "yyyyMMdd");

		uDto.setUserID(userID);
		uDto.setUserName(request.getParameter("userName"));
		uDto.setFeelingLevel(1);
		uDto.setSex(UserSexEnum.valueOf(request.getParameter("sex")));
		uDto.setPassword(password);
		uDto.setLastLogin(date);
		uDto.setPresentAmount(Integer.valueOf(request.getParameter("presentAmount")).intValue());
		uDto.setTargetAmount(Integer.valueOf(request.getParameter("targetAmount")).intValue());
		uDto.setRunningDays(1);
		uDto.setBirthday(birth);
		uDto.setHonorific(honorific);

		//UsersTableへinsert
		service.insertUser(uDto);

		//JSPに遷移する
		RequestDispatcher disp = request.getRequestDispatcher("/index.html");
		disp.forward(request, response);

		}

	}

	// 文字列の日付をフォーマット(yyyyMMddやyyyy/mm/ddなど)をもとにLocalDate型に変換するメソッド
	public static LocalDate convertToLocalDate(String date,String format) {

	                // シンプルにLocalDate型に変換された日付を返却
	        return LocalDate.parse(date, DateTimeFormatter.ofPattern(format));

	    }

}
