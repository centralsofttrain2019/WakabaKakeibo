package bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dto.MoneyNotesDto;

public class ReconstructListBean
{
	private LocalDate todaysDate;

	private HashMap<LocalDate, List<String>> purchaseCalendar;
	private HashMap<LocalDate, List<String>> reconstructCalendar;
	private List<ReconstructBean> purchaseList;
	private List<ReconstructBean> reconstructList;
	private List<LocalDate> dispDay;

	public List<LocalDate> getDispDay()
	{
		return dispDay;
	}
	public void setDispDay(List<LocalDate> dispDay)
	{
		this.dispDay = dispDay;
	}
	public LocalDate getTodaysDate()
	{
		return todaysDate;
	}
	public void setTodaysDate(LocalDate todaysDate)
	{
		this.todaysDate = todaysDate;
	}
	public HashMap<LocalDate, List<String>> getPurchaseCalendar()
	{
		return purchaseCalendar;
	}
	public void setPurchaseCalendar(HashMap<LocalDate, List<String>> purchaseCalendar)
	{
		this.purchaseCalendar = purchaseCalendar;
	}
	public HashMap<LocalDate, List<String>> getReconstructCalendar()
	{
		return reconstructCalendar;
	}
	public void setReconstructCalendar(HashMap<LocalDate, List<String>> reconstructCalendar)
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

	public void setValueFromDto(List<MoneyNotesDto> mnList, List<MoneyNotesDto> reconsList, LocalDate today)
	{
		purchaseList = new ArrayList<ReconstructBean>();
		purchaseCalendar = new HashMap<LocalDate, List<String>>();
		reconstructCalendar = new HashMap<LocalDate, List<String>>();
		reconstructList = new ArrayList<ReconstructBean>();

		dispDay = new ArrayList<LocalDate>();
		for(int i=0; i<7; i++)
		{
			dispDay.add(today.minusDays(i));
			List<String> list = new ArrayList<String>();
			List<String> list2 = new ArrayList<String>();

			purchaseCalendar.put(today.minusDays(i),list);
			reconstructCalendar.put(today.minusDays(i),list2);
		}

		for(MoneyNotesDto dto: mnList)
		{
			ReconstructBean bean = new ReconstructBean();
			bean.setValueFromDto(dto);

			purchaseList.add(bean);
			purchaseCalendar.get(dto.getPurchaseDate()).add(dto.getProductName());
		}

		for(MoneyNotesDto dto: reconsList)
		{
			ReconstructBean bean = new ReconstructBean();
			bean.setValueFromDto(dto);

			reconstructList.add(bean);
			reconstructCalendar.get(dto.getPurchaseDate()).add(dto.getProductName());
		}


	}

}
