package bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dto.MoneyNotesDto;

public class HistoryListBean
{
	private List<HistoryBean> historyList;
	private List<HistoryBean> incomeList;
	private List<HistoryBean> expenseList;

	private int history_year = 0;
	private int history_month = 0;
	private Map<String, List<HistoryBean>> incomeMap;
	private Map<String, List<HistoryBean>> expenseMap;

	private Map<String, Integer> incomeTotal;
	private Map<String, Integer> expenseTotal;

	int incomeSum = 0;
	int expenseSum = 0;



	public int getIncomeSum() {
		return incomeSum;
	}

	public void setIncomeSum(int incomeSum) {
		this.incomeSum = incomeSum;
	}

	public int getExpenseSum() {
		return expenseSum;
	}

	public void setExpenseSum(int expenseSum) {
		this.expenseSum = expenseSum;
	}

	public Map<String, Integer> getIncomeTotal() {
		return incomeTotal;
	}

	public void setIncomeTotal(Map<String, Integer> incomeTotal) {
		this.incomeTotal = incomeTotal;
	}

	public Map<String, Integer> getExpenseTotal() {
		return expenseTotal;
	}

	public void setExpenseTotal(Map<String, Integer> expenseTotal) {
		this.expenseTotal = expenseTotal;
	}

	public List<HistoryBean> getIncomeList() {
		return incomeList;
	}

	public void setIncomeList(List<HistoryBean> incomeList) {
		this.incomeList = incomeList;
	}

	public List<HistoryBean> getExpenseList() {
		return expenseList;
	}

	public void setExpenseList(List<HistoryBean> expenseList) {
		this.expenseList = expenseList;
	}

	public Map<String, List<HistoryBean>> getIncomeMap() {
		return incomeMap;
	}

	public void setIncomeMap(Map<String, List<HistoryBean>> incomeMap) {
		this.incomeMap = incomeMap;
	}

	public Map<String, List<HistoryBean>> getExpenseMap() {
		return expenseMap;
	}

	public void setExpenseMap(Map<String, List<HistoryBean>> expenseMap) {
		this.expenseMap = expenseMap;
	}

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
		return "HistoryListBean [historyList=" + historyList + ", incomeList=" + incomeList + ", expenseList="
				+ expenseList + ", history_year=" + history_year + ", history_month=" + history_month + ", incomeMap="
				+ incomeMap + ", expenseMap=" + expenseMap + ", incomeTotal=" + incomeTotal + ", expenseTotal="
				+ expenseTotal + "]";
	}
}
