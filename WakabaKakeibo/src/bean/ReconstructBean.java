package bean;

import java.time.LocalDate;

import dto.MoneyNotesDto;

public class ReconstructBean
{
	private LocalDate purchaseDate;
	private String productName;
	private int numberOfPurchase;
	private int amount;

	public LocalDate getPurchaseDate()
	{
		return purchaseDate;
	}
	public void setPurchaseDate(LocalDate purchaseDate)
	{
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

	public void setValueFromDto(MoneyNotesDto dto)
	{
		this.purchaseDate = dto.getPurchaseDate();
		this.productName = dto.getProductName();
		this.numberOfPurchase = dto.getNumberOfPurchase();
		this.amount = dto.getAmount();
	}
}
