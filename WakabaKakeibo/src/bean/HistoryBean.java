package bean;

import java.time.LocalDate;

import domain.MoneyNoteTypeEnum;
import dto.MoneyNotesDto;

public class HistoryBean
{
	private String productName;
	private LocalDate purchaseDate;
	private MoneyNoteTypeEnum type;
	private int categoryID;
	private int amount;
	private String categoryName;

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getProductName()
	{
		return productName;
	}
	public void setProductName(String productName)
	{
		this.productName = productName;
	}
	public MoneyNoteTypeEnum getType()
	{
		return type;
	}
	public void setType(MoneyNoteTypeEnum type)
	{
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

	public boolean isAccount(int year, int month) {

		if((this.purchaseDate.getYear() == year) && (this.purchaseDate.getMonthValue() == month)) {
			return true;
		}

		return false;
	}
	@Override
	public String toString() {
		return "HistoryBean [productName=" + productName + ", purchaseDate=" + purchaseDate + ", type=" + type
				+ ", categoryID=" + categoryID + ", amount=" + amount + ", categoryName=" + categoryName + "]";
	}




}
