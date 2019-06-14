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


	public MoneyNotesDto()
	{
		super();
	}

	public MoneyNotesDto(
			int moneyNoteID,
			int userID,
			LocalDate purchaseDate,
			MoneyNoteTypeEnum type,
			int productID,
			String productName,
			int categoryID,
			int numberOfPurchase,
			int amount,
			int purchaseIntervalDays,
			String categoryName)
	{
		super();
		this.moneyNoteID = moneyNoteID;
		this.userID = userID;
		this.purchaseDate = purchaseDate;
		this.type = type;
		this.productID = productID;
		this.productName = productName;
		this.categoryID = categoryID;
		this.numberOfPurchase = numberOfPurchase;
		this.amount = amount;
		this.purchaseIntervalDays = purchaseIntervalDays;
		this.categoryName = categoryName;
	}
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

	@Override
	public String toString()
	{
		return "MoneyNotesDto [moneyNoteID=" + moneyNoteID + ", userID=" + userID + ", purchaseDate=" + purchaseDate
				+ ", type=" + type + ", productID=" + productID + ", productName=" + productName + ", categoryID="
				+ categoryID + ", numberOfPurchase=" + numberOfPurchase + ", amount=" + amount
				+ ", purchaseIntervalDays=" + purchaseIntervalDays + ", categoryName=" + categoryName + "]";
	}


}
