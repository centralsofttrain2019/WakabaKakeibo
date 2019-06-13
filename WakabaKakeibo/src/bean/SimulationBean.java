package bean;

import java.time.LocalDate;

public class SimulationBean {

	private LocalDate date;
	private int balance;
	private String strIsReal;
	private String hiddenName;


	public SimulationBean(LocalDate date, int balance, String strIsReal, String hiddenName) {
		super();
		this.date = date;
		this.balance = balance;
		this.strIsReal = strIsReal;
		this.hiddenName = hiddenName;
	}

	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public int getBalance() {
		return balance;
	}


	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getHiddenName() {
		return hiddenName;
	}


	public void setHiddenName(String hiddenName) {
		this.hiddenName = hiddenName;
	}

	public String getStrIsReal() {
		return strIsReal;
	}

	public void setStrIsReal(String strIsReal) {
		this.strIsReal = strIsReal;
	}

}
