package bean;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class ReconstructListBean
{
	private LocalDate todaysDate;

	private HashMap<LocalDate, List<String>> purchaseCalendar;
	private HashMap<LocalDate, List<String>> reconstructCalendar;

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



}
