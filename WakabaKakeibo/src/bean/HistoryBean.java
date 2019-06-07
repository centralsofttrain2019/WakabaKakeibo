package bean;

import java.util.List;

public class HistoryBean
{
	private List<MoneyNotesBean>historyList;
	private String message;

	public List<MoneyNotesBean> getHistoryList() {
		return historyList;
	}

	public void setHistoryList(List<MoneyNotesBean> historyList)
	{
		this.historyList = historyList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}
