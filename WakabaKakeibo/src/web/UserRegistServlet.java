package web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		// 現在日付
		LocalDate date = LocalDate.now();

		//コメントのrequestがあれば
		if(request.getParameter("formControlTextarea") != null) {
			//コメントのインサート
			insertUser(request, date);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void insertUser(HttpServletRequest request, LocalDate date){

		UsersDto uDto = new UsersDto();
		String monthString = String.format("%02d", request.getParameter("month"));
		String dayString = String.format("%02d", request.getParameter("day"));

		String birthString = request.getParameter("year") + monthString + dayString;
		LocalDate birth = convertToLocalDate(birthString, "yyyyMMdd");

		uDto.setUserID(Integer.valueOf(request.getParameter("userID")).intValue());
		uDto.setUserName(request.getParameter("userName"));
		uDto.setFeelingLevel(1);
		uDto.setSex(UserSexEnum.valueOf(request.getParameter("sex")));
		uDto.setPassword(request.getParameter("password"));
		uDto.setLastLogin(date);
		uDto.setPresentAmount(Integer.valueOf(request.getParameter("presentAmount")).intValue());
		uDto.setTargetAmount(Integer.valueOf(request.getParameter("targetAmount")).intValue());
		uDto.setRunningDays(1);
		uDto.setBirthday(birth);

		//サービスを取得
		UsersService service = new UsersService();
		//blogcomentsDBへinsert
		service.insertUser(uDto);

	}

	// 文字列の日付をフォーマット(yyyyMMddやyyyy/mm/ddなど)をもとにLocalDate型に変換するメソッド
	public static LocalDate convertToLocalDate(String date,String format) {

	                // シンプルにLocalDate型に変換された日付を返却
	        return LocalDate.parse(date, DateTimeFormatter.ofPattern(format));

	    }

}
