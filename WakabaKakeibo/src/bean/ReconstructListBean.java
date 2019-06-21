package bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dto.MoneyNotesDto;

public class ReconstructListBean
{
	private LocalDate todaysDate;

	private HashMap<LocalDate, List<ReconstructBean>> purchaseCalendar;
	private HashMap<LocalDate, List<ReconstructBean>> reconstructCalendar;
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
	public HashMap<LocalDate, List<ReconstructBean>> getPurchaseCalendar()
	{
		return purchaseCalendar;
	}
	public void setPurchaseCalendar(HashMap<LocalDate, List<ReconstructBean>> purchaseCalendar)
	{
		this.purchaseCalendar = purchaseCalendar;
	}
	public HashMap<LocalDate, List<ReconstructBean>> getReconstructCalendar()
	{
		return reconstructCalendar;
	}
	public void setReconstructCalendar(HashMap<LocalDate, List<ReconstructBean>> reconstructCalendar)
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
		purchaseCalendar = new HashMap<LocalDate, List<ReconstructBean>>();
		reconstructCalendar = new HashMap<LocalDate, List<ReconstructBean>>();
		reconstructList = new ArrayList<ReconstructBean>();

		dispDay = new ArrayList<LocalDate>();
		for(int i=0; i<7; i++)
		{
			dispDay.add(today.minusDays(i));
			List<ReconstructBean> list = new ArrayList<ReconstructBean>();
			List<ReconstructBean> list2 = new ArrayList<ReconstructBean>();

			purchaseCalendar.put(today.minusDays(i),list);
			reconstructCalendar.put(today.minusDays(i),list2);
		}

		for(MoneyNotesDto dto: mnList)
		{
			ReconstructBean bean = new ReconstructBean();
			bean.setValueFromDto(dto);

			purchaseList.add(bean);
			if(purchaseCalendar.get(dto.getPurchaseDate()) != null)
				purchaseCalendar.get(dto.getPurchaseDate()).add(bean);
		}

		for(MoneyNotesDto dto: reconsList)
		{
			ReconstructBean bean = new ReconstructBean();
			bean.setValueFromDto(dto);

			reconstructList.add(bean);
			if(reconstructCalendar.get(dto.getPurchaseDate()) != null)
				reconstructCalendar.get(dto.getPurchaseDate()).add(bean);
		}


	}

}
