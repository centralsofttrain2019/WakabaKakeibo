package dto;

import java.time.LocalDate;

import domain.MoneyNoteTypeEnum;

public class MoneyNotesDto
{
	private int moneyNoteID;
	private int userID;
	private LocalDate purchaseDate;
	private MoneyNoteTypeEnum type;
	private int productID;
	private String productName;
	private int categoryID;
	private int numberOfPurchase;
	private int amount;
	private int purchaseIntervalDays;
	private String categoryName;

	public int getMoneyNoteID()
	{
		return moneyNoteID;
	}
	public void setMoneyNoteID(int moneyNoteID)
	{
		this.moneyNoteID = moneyNoteID;
	}
	public int getUserID()
	{
		return userID;
	}
	public void setUserID(int userID)
	{
		this.userID = userID;
	}
	public LocalDate getPurchaseDate()
	{
		return purchaseDate;
	}
	public void setPurchaseDate(LocalDate purchaseDate)
	{
		this.purchaseDate = purchaseDate;
	}

	public MoneyNoteTypeEnum getType()
	{
		return type;
	}
	public void setType(MoneyNoteTypeEnum type)
	{
		this.type = type;
	}
	public int getProductID()
	{
		return productID;
	}
	public void setProductID(int productID)
	{
		this.productID = productID;
	}
	public String getProductName()
	{
		return productName;
	}
	public void setProductName(String productName)
	{
		this.productName = productName;
	}
	public int getCategoryID()
	{
		return categoryID;
	}
	public void setCategoryID(int categoryID)
	{
		this.categoryID = categoryID;
	}
	public int getNumberOfPurchase()
	{
		return numberOfPurchase;
	}
	public void setNumberOfPurchase(int numberOfPurchase)
	{
		this.numberOfPurchase = numberOfPurchase;
	}
	public int getAmount()
	{
		return amount;
	}
	public void setAmount(int amount)
	{
		this.amount = amount;
	}
	public int getPurchaseIntervalDays()
	{
		return purchaseIntervalDays;
	}
	public void setPurchaseIntervalDays(int purchaseIntervalDays)
	{
		this.purchaseIntervalDays = purchaseIntervalDays;
	}
	public String getCategoryName()
	{
		return categoryName;
	}
	public void setCategoryName(String categoryName)
	{
		this.categoryName = categoryName;
	}



}
