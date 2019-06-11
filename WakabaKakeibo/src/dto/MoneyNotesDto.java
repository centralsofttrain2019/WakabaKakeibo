package dto;

import java.time.LocalDate;

public class MoneyNotesDto
{
	private int MoneyNoteID;
	private int UserID;
	private LocalDate PurchaseDate;
	private String Type;
	private int ProductID;
	private int CategoryID;
	private int NumberOfPurchase;
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
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
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
	public int getCategoryID() {
		return CategoryID;
	}
	public void setCategoryID(int categoryID) {
		CategoryID = categoryID;
	}
	public int getNumberOfPurchase() {
		return NumberOfPurchase;
	}
	public void setNumberOfPurchase(int numberOfPurchase) {
		NumberOfPurchase = numberOfPurchase;
	}




}
