package bean;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import dto.MoneyNotesDto;

public class ReconstructListBean
{
	private LocalDate todaysDate;

	private HashMap<DayOfWeek, List<String>> purchaseCalendar;
	private HashMap<DayOfWeek, List<String>> reconstructCalendar;
	private List<ReconstructBean> purchaseList;
	private List<ReconstructBean> reconstructList;
	public LocalDate getTodaysDate()
	{
		return todaysDate;
	}
	public void setTodaysDate(LocalDate todaysDate)
	{
		this.todaysDate = todaysDate;
	}
	public HashMap<DayOfWeek, List<String>> getPurchaseCalendar()
	{
		return purchaseCalendar;
	}
	public void setPurchaseCalendar(HashMap<DayOfWeek, List<String>> purchaseCalendar)
	{
		this.purchaseCalendar = purchaseCalendar;
	}
	public HashMap<DayOfWeek, List<String>> getReconstructCalendar()
	{
		return reconstructCalendar;
	}
	public void setReconstructCalendar(HashMap<DayOfWeek, List<String>> reconstructCalendar)
	{
		this.reconstructCalendar = reconstructCalendar;
	}
	public List<ReconstructBean> getPurchaseList()
	{
		return purchaseList;
	}
	public void setPurchaseList(List<ReconstructBean> purchaseList)
	{
		this.purchaseList = purchaseList;
	}
	public List<ReconstructBean> getReconstructList()
	{
		return reconstructList;
	}
	public void setReconstructList(List<ReconstructBean> reconstructList)
	{
		this.reconstructList = reconstructList;
	}

	public void setValueFromDto(List<MoneyNotesDto> mnList, List<MoneyNotesDto> reconsList)
	{
		for(MoneyNotesDto dto: mnList)
		{
			ReconstructBean bean = new ReconstructBean();
			bean.setValueFromDto(dto);
			this.purchaseList.add(bean);
		}

		for(MoneyNotesDto dto: reconsList)
		{
			ReconstructBean bean = new ReconstructBean();
			bean.setValueFromDto(dto);
			this.reconstructList.add(bean);
		}

		//TODO カレンダー用のデータセットを後で作る
	}

}