package bean;

import java.time.LocalDate;

import dto.MoneyNotesDto;

public class HistoryBean
{
	private String productName;
	private LocalDate purchaseDate;
	private String type;
	private int categoryID;
	private int amount;
	private String categoryName;

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setValueFromDto(MoneyNotesDto dto) {
		this.productName = dto.getProductName();
		this.purchaseDate = dto.getPurchaseDate();
		this.type = dto.getType();
		this.categoryID = dto.getCategoryID();
		this.amount = dto.getAmount();
		this.categoryName = dto.getCategoryName();
	}




}
