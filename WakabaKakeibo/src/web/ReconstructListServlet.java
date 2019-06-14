package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ReconstructListBean;
import service.MoneyNotesService;

/**
 * Servlet implementation class ReconstructServlet
 */
@WebServlet("/ReconstructListServlet")
public class ReconstructListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReconstructListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReconstructListBean bean = new ReconstructListBean();
		MoneyNotesService service = new MoneyNotesService();

		bean = service.getReconstructListBean(1);

		request.setAttribute("bean", bean);
		RequestDispatcher disp = request.getRequestDispatcher("/reconstructList.jsp");
		disp.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
