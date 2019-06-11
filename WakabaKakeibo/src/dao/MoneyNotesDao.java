package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.MoneyNotesDto;

public class MoneyNotesDao {

	private static final String FIND_ALL =
			"SELECT * FROM MONEYNOTES";

	private Connection con = null;

	public MoneyNotesDao(Connection con)
	{
		super();
		this.con = con;
	}


	public List<MoneyNotesDto> selectAll() throws SQLException
	{
		PreparedStatement stmt = con.prepareStatement( FIND_ALL );
		ResultSet rs = stmt.executeQuery();

		List<MoneyNotesDto> dtoList = new ArrayList<MoneyNotesDto>();
		while(rs.next())
		{
			MoneyNotesDto mnd = new MoneyNotesDto();
			mnd.setMoneyNoteID(rs.getInt("moneyNoteID"));
			mnd.setUserID(rs.getInt("userID"));
			mnd.setPurchaseDate(rs.getDate("purchaseDate").toLocalDate());
			mnd.setType(rs.getString("type"));
			mnd.setProductID(rs.getInt("productID"));
			mnd.setCategoryID(rs.getInt("categoryID"));
			mnd.setNumberOfPurchase(rs.getInt("NumberOfParchase"));
			mnd.setAmount(rs.getInt("amount"));
			mnd.setPurchaseIntervalDays(rs.getInt("PARCHASEINTERVALDAYS"));

			dtoList.add(mnd);
		}
		stmt.close();
		return dtoList;

	}

	private static final String FIND_ALL_WITH_ID_NAME =
		"SELECT * FROM MONEYNOTES "
		+ "INNER JOIN Products ON MoneyNotes.ProductID = Products.ProductID "
		+ "INNER JOIN MoneyCategorys ON MoneyNotes.CategoryID = MoneyCategorys.MoneyCategorysID";

	public List<MoneyNotesDto> selectAllWithIDName() throws SQLException
	{
		PreparedStatement stmt = con.prepareStatement( FIND_ALL_WITH_ID_NAME );
		ResultSet rs = stmt.executeQuery();

		List<MoneyNotesDto> dtoList = new ArrayList<MoneyNotesDto>();
		while(rs.next())
		{
			MoneyNotesDto mnd = new MoneyNotesDto();
			mnd.setProductName(rs.getString("Products.ProductName"));
			mnd.setMoneyNoteID(rs.getInt("moneyNoteID"));
			mnd.setUserID(rs.getInt("userID"));
			mnd.setPurchaseDate(rs.getDate("purchaseDate").toLocalDate());
			mnd.setType(rs.getString("type"));
			mnd.setProductID(rs.getInt("productID"));
			mnd.setCategoryID(rs.getInt("categoryID"));
			mnd.setNumberOfPurchase(rs.getInt("NumberOfParchase"));
			mnd.setAmount(rs.getInt("amount"));
			mnd.setPurchaseIntervalDays(rs.getInt("PurchaseIntervalID"));
			mnd.setCategoryName(rs.getString("MoneyCategorys.CategoryName"));

			dtoList.add(mnd);
		}


		if(stmt != null) stmt.close();
		return dtoList;
	}
}
