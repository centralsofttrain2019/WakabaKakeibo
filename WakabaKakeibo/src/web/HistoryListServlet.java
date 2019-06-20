package web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ChatBean;
import bean.HistoryBean;
import bean.HistoryListBean;
import domain.MoneyNoteTypeEnum;
import service.MoneyNotesService;

/**
 * Servlet implementation class HistoryServlet
 */
@WebServlet("/HistoryListServlet")
public class HistoryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ChatBean session = (ChatBean)request.getSession().getAttribute(ChatBean.USERINFO_SESSION_SAVE_NAME);
		if(session == null)
		{
			//JSPに遷移する
			RequestDispatcher disp = request.getRequestDispatcher("/index.html");
			disp.forward(request, response);
			return;
		}

		//サービスを取得
		MoneyNotesService service = new MoneyNotesService();
		HistoryListBean bean = null;
		//HistoryListBean bean = service.findAllHistoryList(1); //引数にユーザID


//		年月の更新があればその月だけのデータを表示
		if(request.getParameter("year") != null){

			String year = request.getParameter("year");
			int month = Integer.valueOf(request.getParameter("month")).intValue();
			int nextMonth = month + 1;
			String day = "01";

			LocalDate sinceLd = convertToLocalDate(year + String.format("%02d", month) + day, "yyyyMMdd");
			LocalDate untilLd = convertToLocalDate(year + String.format("%02d", nextMonth) + day, "yyyyMMdd");

			System.out.println("getYear");
			System.out.println(request.getParameter("year"));

//			ユーザID1で決め打ち
			bean = service.getHistoryListBeanByDate(1, sinceLd, untilLd);

			bean.setHistory_year(Integer.valueOf(request.getParameter("year")).intValue());
			bean.setHistory_month(Integer.valueOf(request.getParameter("month")).intValue());

//			incomeとexpenseの購入カテゴリでグルーピングしたマップを返す
			setMap(bean, request);
			//incomeとexpenseのtotalの計算
			totalCalculation(bean);
			//incomeとexpenseの合計

			System.out.println("HistoryServlet");
			request.setAttribute("bean",bean);

			//JSPに遷移
			RequestDispatcher disp = request.getRequestDispatcher("/historyList.jsp");
			disp.forward(request, response);

//			requestのデータが何もなければ全件表示
		}else {

//			ユーザID1で決め打ち
			bean = service.findAllHistoryList(1); //引数にユーザID

//			incomeとexpenseの購入カテゴリでグルーピングしたマップを返す
			setMap(bean, request);
			//incomeとexpenseのtotalの計算
			totalCalculation(bean);

			System.out.println("HistoryServlet");
			request.setAttribute("bean",bean);

			//JSPに遷移
			RequestDispatcher disp = request.getRequestDispatcher("/historyList.jsp");
			disp.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	// 文字列の日付をフォーマット(yyyyMMddやyyyy/mm/ddなど)をもとにLocalDate型に変換するメソッド
	public static LocalDate convertToLocalDate(String date,String format) {

                // シンプルにLocalDate型に変換された日付を返却
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(format));

    }

	public HistoryListBean setMap(HistoryListBean bean, HttpServletRequest request) {
		//incomeとexpense用のリストを作成
				List<HistoryBean> incomeList = new ArrayList<>();
				List<HistoryBean> expenseList = new ArrayList<>();
				//incomeとexpenseにそれぞれ代入
				for(HistoryBean hb: bean.getHistoryList()) {
					if(hb.getType().compareTo(MoneyNoteTypeEnum.INCOME) == 0) {
						incomeList.add(hb);
					}else {
						expenseList.add(hb);
					}
				}
				//beanへincome,expenseのListをセット
				bean.setExpenseList(expenseList);
				bean.setIncomeList(incomeList);

				// categoryNameでそれぞれグルーピングする
				Map<String, List<HistoryBean>> incomeMap = incomeList.stream().collect(Collectors.groupingBy(o -> o.getCategoryName()));
				Map<String, List<HistoryBean>> expenseMap = expenseList.stream().collect(Collectors.groupingBy(o -> o.getCategoryName()));


				bean.setExpenseMap(expenseMap);
				bean.setIncomeMap(incomeMap);

				return bean;
	}

	public void totalCalculation(HistoryListBean bean) {
		int amountTotal = 0;
		int sumIncome = 0;
		int sumExpense = 0;

		Map<String, Integer> incomeTotal = new HashMap<String, Integer>();
		Map<String, Integer> expenseTotal = new HashMap<String, Integer>();

		for (String key : bean.getIncomeMap().keySet()) {
			 System.out.println(key + " => " + bean.getIncomeMap().get(key));
			 for(HistoryBean hb: bean.getIncomeMap().get(key)) {
				 amountTotal += hb.getAmount();
			 }
			 incomeTotal.put(key, amountTotal);
			 sumIncome += amountTotal;
			 amountTotal = 0;
    	}

		for (String key : bean.getExpenseMap().keySet()) {
			 System.out.println(key + " => " + bean.getExpenseMap().get(key));
			 for(HistoryBean hb: bean.getExpenseMap().get(key)) {
				 amountTotal += hb.getAmount();
			 }
			 incomeTotal.put(key, amountTotal);
			 sumExpense += amountTotal;
			 amountTotal = 0;
		}

		bean.setIncomeTotal(incomeTotal);
		bean.setExpenseTotal(expenseTotal);

		bean.setIncomeSum(sumIncome);
		bean.setExpenseSum(sumExpense);

	}

}
