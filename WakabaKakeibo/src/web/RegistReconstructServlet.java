package web;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ChatBean;
import domain.MoneyNoteTypeEnum;
import service.MoneyNotesService;

/**
 * Servlet implementation class RegistReconstructServlet
 */
@WebServlet("/RegistReconstructServlet")
public class RegistReconstructServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistReconstructServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ChatBean chatSession = (ChatBean)request.getSession().getAttribute(ChatBean.USERINFO_SESSION_SAVE_NAME);
		if(chatSession == null)
		{
			//JSPに遷移する
			RequestDispatcher disp = request.getRequestDispatcher("/index.html");
			disp.forward(request, response);
			return;
		}

        request.setCharacterEncoding("UTF-8");
        String isRegist = request.getParameter("regist");

        String select[ ] = request.getParameterValues("select");
        MoneyNotesService service = new MoneyNotesService();

        if(select != null)
        {
	        for (String name : select)
	        {
	            LocalDate date = LocalDate.parse(request.getParameter("date_" + name));
	            int amount = Integer.parseInt(request.getParameter("amount_" + name));
	            int number = Integer.parseInt(request.getParameter("num_" + name));
	            service.insertMoneyNotes(chatSession.getUserID(), name, MoneyNoteTypeEnum.EXPENSE ,number, amount, date);
	        }
        }

		RequestDispatcher disp = request.getRequestDispatcher("/ReconstructListServlet");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
