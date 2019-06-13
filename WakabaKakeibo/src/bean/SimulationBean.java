package bean;

import java.time.LocalDate;

public class SimulationBean {

	private LocalDate date;
	private int balance;
	private boolean isReal;
	private String strIsReal;
	private String hiddenName;


	public SimulationBean(LocalDate date, int balance, boolean isReal, String hiddenName) {
		super();
		this.date = date;
		this.balance = balance;
		this.isReal = isReal;
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

		strIsReal = String.valueOf(isReal);

		return strIsReal;
	}

	public void setReal(boolean isReal) {
		this.isReal = isReal;
	}

}
