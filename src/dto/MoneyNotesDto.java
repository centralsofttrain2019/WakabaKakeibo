package dto;

import java.time.LocalDate;

public class MoneyNotesDto
{
	private int MoneyNoteID;
	private int UserID;
	private int ProductID;
	private LocalDate PurchaseDate;
	private int Type;
	private int PurchaseNumber;
	private int Amount;
	private int PurchaseIntervalDays;
	public int getMoneyNoteID() {
		return MoneyNoteID;
	}
	public void setMoneyNoteID(int moneyNoteID) {
		MoneyNoteID = moneyNoteID;
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public int getProductID() {
		return ProductID;
	}
	public void setProductID(int productID) {
		ProductID = productID;
	}
	public LocalDate getPurchaseDate() {
		return PurchaseDate;
	}
	public void setPurchaseDate(LocalDate purchaseDate) {
		PurchaseDate = purchaseDate;
	}
	public int getType() {
		return Type;
	}
	public void setType(int type) {
		Type = type;
	}
	public int getPurchaseNumber() {
		return PurchaseNumber;
	}
	public void setPurchaseNumber(int purchaseNumber) {
		PurchaseNumber = purchaseNumber;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	public int getPurchaseIntervalDays() {
		return PurchaseIntervalDays;
	}
	public void setPurchaseIntervalDays(int purchaseIntervalDays) {
		PurchaseIntervalDays = purchaseIntervalDays;
	}




}
