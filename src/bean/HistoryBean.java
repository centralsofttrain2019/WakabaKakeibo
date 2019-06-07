package bean;

import java.util.List;

public class HistoryBean
{
	private List<MoneyNoteBean>historyList;
	private String message;

	public List<MoneyNoteBean> getHistoryList() {
		return historyList;
	}

	public void setHistoryList(List<MoneyNoteBean> historyList)
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





