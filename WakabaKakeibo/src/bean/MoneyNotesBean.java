package bean;

import java.time.LocalDate;
import java.util.List;

import dto.MoneyNotesDto;

public class MoneyNotesBean
{
	private List<MoneyNotesDto>dtoList;
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
	public List<MoneyNotesDto> getDtoList() {
		return dtoList;
	}
	public void setDtoList(List<MoneyNotesDto> dtoList) {
		this.dtoList = dtoList;
	}




}
