package web;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	            service.insertMoneyNotes(1, name, number, amount, date);
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
