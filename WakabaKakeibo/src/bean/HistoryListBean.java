package bean;

import java.util.ArrayList;
import java.util.List;

import dto.MoneyNotesDto;

public class HistoryListBean
{
	private List<HistoryBean> historyList;
	private int history_year = 0;
	private int history_month = 0;



	public int getHistory_year() {
		return history_year;
	}

	public void setHistory_year(int history_year) {
		this.history_year = history_year;
	}

	public int getHistory_month() {
		return history_month;
	}

	public void setHistory_month(int history_month) {
		this.history_month = history_month;
	}

	public List<HistoryBean> getHistoryList()
	{
		return historyList;
	}

	public void setHistoryList(List<HistoryBean> historyList)
	{
		this.historyList = historyList;
	}

	public void setValueFromDto(List<MoneyNotesDto> dtoList)
	{
		historyList = new ArrayList<HistoryBean>();
		for(MoneyNotesDto dto: dtoList)
		{
			HistoryBean bean = new HistoryBean();
			bean.setValueFromDto(dto);
			historyList.add(bean);
		}
	}

	@Override
	public String toString() {
		return "HistoryListBean [historyList=" + historyList + ", history_year=" + history_year + ", history_month="
				+ history_month + "]";
	}
}
