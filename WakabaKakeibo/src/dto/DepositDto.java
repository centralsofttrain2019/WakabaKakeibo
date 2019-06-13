package dto;

import java.time.LocalDate;

public class DepositDto {

	private int depositID;
	private LocalDate date;
	private int balance;
	private int userID;
	private boolean isReal;


	public int getDepositID() {
		return depositID;
	}
	public void setDepositID(int depositID) {
		this.depositID = depositID;
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
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public boolean isReal() {
		return isReal;
	}
	public void setReal(boolean isReal) {
		this.isReal = isReal;
	}



}
