package bean;

import java.util.ArrayList;
import java.util.List;

import dto.MoneyNotesDto;

public class HistoryListBean
{
	private List<HistoryBean> historyList;

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
}
