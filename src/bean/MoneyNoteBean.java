package bean;

import java.time.LocalDate;

public class MoneyNoteBean
{

	private LocalDate PurchaseDate;
	private int Type;
	private int CategoryID;
	private int Amount;
	private String CategoryName;
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
	public int getCategoryID() {
		return CategoryID;
	}
	public void setCategoryID(int categoryID) {
		CategoryID = categoryID;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}




}
