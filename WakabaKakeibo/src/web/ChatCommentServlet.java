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
import domain.EventTypeEnum;
import domain.MoneyNoteTypeEnum;
import domain.SqlOrderJudgement;
import dto.MoneyNotesDto;
import service.MoneyNotesService;
import service.UsersService;

/**
 * Servlet implementation class ChatCommentServlet
 */
@WebServlet("/ChatCommentServlet")
public class ChatCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatCommentServlet() {
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

		//家計簿データの登録をした場合
		if(request.getParameter("MoneyNoteSubmit") != null) {
			this.addMoneyNote(request,session);
		}

		//定型文送信場合
		String chatValue = request.getParameter("greeting");
		if(chatValue != null) {
			System.out.println(chatValue);
			request.setAttribute("greeting_message", EventTypeEnum.valueOf(chatValue));
		}

		//チャットメッセージ送信時
		String messageTmp=request.getParameter("chatMessage");
		if(messageTmp != null)
		{
			byte[] bi = messageTmp.getBytes("iso-8859-1");
			String message = new String( bi, "UTF-8" );

			request.setAttribute("your_message", message);

			MoneyNotesService service = new MoneyNotesService();
			MoneyNotesDto dto = service.getLastMoneyNoteData(session.getUserID(), message);

			if(dto == null) {
				request.setAttribute("wakaba_message", "「" + message + "」はよくわからないや。");
			}
			else
			{
				SqlOrderJudgement judge = service.insertMoneyNotes(session.getUserID(), dto.getProductName(), dto.getType(), dto.getCategoryID(),dto.getNumberOfPurchase(), dto.getAmount(), dto.getPurchaseDate());
				if(judge == SqlOrderJudgement.SUCCESS)
				{
					request.setAttribute("wakaba_message",
							"過去のデータから" +
							dto.getProductName() + "を" + dto.getNumberOfPurchase() + "個" + dto.getAmount() + "円で記録しといたよ");
				}else
				{
					request.setAttribute("wakaba_message",dto.getProductName() + "を家計簿に記録しようとしたけどできなかったよ。");
				}
			}
		}

		//貯金データの登録をした場合
		if(request.getParameter("DepositSubmit") != null) {
			this.addDeposit(request,session);
		}

		//JSPに遷移する
		RequestDispatcher disp = request.getRequestDispatcher("/ChatServlet");
		disp.forward(request, response);
	}

	private void addMoneyNote(HttpServletRequest request, ChatBean session)
	{
		try
		{
			String productName = request.getParameter("product-name");
			int categoryID = Integer.parseInt(request.getParameter("category-id"));
			//int categoryID = Integer.parseInt(request.getParameter("category-id"));
			int year =  Integer.parseInt(request.getParameter("purchase-year"));
			int month =  Integer.parseInt(request.getParameter("purchase-month"));
			int day =  Integer.parseInt(request.getParameter("purchase-day"));
			LocalDate purchaseDate = LocalDate.of(year, month, day);
			int amount = Integer.parseInt(request.getParameter("amount"));
			int numberOfPurchase = Integer.parseInt(request.getParameter("number-of-purchase"));

			MoneyNoteTypeEnum type = null;
			if(categoryID >= 10 && categoryID <= 19)
			{
				type = MoneyNoteTypeEnum.EXPENSE;
			}
			else if(categoryID >=20 && categoryID <= 29)
			{
				type = MoneyNoteTypeEnum.INCOME;
			}

			request.setAttribute("your_message",
					year + "年" + month + "月" + day + "日に" +
					productName + "を" + numberOfPurchase + "個" + amount + "円で買ったよ。");

			MoneyNotesService service = new MoneyNotesService();
			SqlOrderJudgement judge = service.insertMoneyNotes(session.getUserID(), productName, type, categoryID,numberOfPurchase, amount, purchaseDate);

			if(judge == SqlOrderJudgement.SUCCESS) {
				request.setAttribute("wakaba_message","家計簿に記録しておいたよ。");
			}else if(judge == SqlOrderJudgement.FAILURE)
			{
				request.setAttribute("wakaba_message","家計簿に登録できなかったよ。商品データベースに商品が無いよ。");
			}

		}catch(NumberFormatException e)
		{
			request.setAttribute("wakaba_message", "記入に誤りがあるよ。");
			return;
		}
	}

	private void addDeposit(HttpServletRequest request, ChatBean session)
	{
		int amount = Integer.parseInt(request.getParameter("amount"));

		UsersService service = new UsersService();
		service.updatePresentAmount(session.getUserID(), amount);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
