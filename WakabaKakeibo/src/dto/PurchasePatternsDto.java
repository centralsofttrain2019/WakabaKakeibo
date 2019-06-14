package dto;

import java.time.LocalDate;

import domain.DatePatternTypeEnum;

public class PurchasePatternsDto
{
	private int purchasePatternID ;
	private int userID;
	private int productID;
	private String productName;
	private DatePatternTypeEnum datePatternType;
	private LocalDate lastPurchaseDate;
	private int numberPattern;
	private int amountPattern;
	public int getPurchasePatternID()
	{
		return purchasePatternID;
	}

	public void setPurchasePatternID(int purchasePatternID)
	{
		this.purchasePatternID = purchasePatternID;
	}
	public int getUserID()
	{
		return userID;
	}
	public void setUserID(int userID)
	{
		this.userID = userID;
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
	public LocalDate getLastPurchaseDate()
	{
		return lastPurchaseDate;
	}
	public void setLastPurchaseDate(LocalDate lastPurchaseDate)
	{
		this.lastPurchaseDate = lastPurchaseDate;
	}
	public int getNumberPattern()
	{
		return numberPattern;
	}
	public void setNumberPattern(int numberPattern)
	{
		this.numberPattern = numberPattern;
	}
	public int getAmountPattern()
	{
		return amountPattern;
	}
	public void setAmountPattern(int amountPattern)
	{
		this.amountPattern = amountPattern;
	}

	public DatePatternTypeEnum getDatePatternType()
	{
		return datePatternType;
	}

	public void setDatePatternType(DatePatternTypeEnum datePatternType)
	{
		this.datePatternType = datePatternType;
	}

	@Override
	public String toString()
	{
		return "PurchasePatternsDto [purchasePatternID=" + purchasePatternID + ", userID=" + userID + ", productID="
				+ productID + ", productName=" + productName + ", datePatternType=" + datePatternType
				+ ", lastPurchaseDate=" + lastPurchaseDate + ", numberPattern=" + numberPattern + ", amountPattern="
				+ amountPattern + "]";
	}

}
