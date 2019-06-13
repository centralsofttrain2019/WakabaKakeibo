package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import domain.MoneyNoteTypeEnum;
import dto.MoneyNotesDto;

public class MoneyNotesDao {
	private Connection con = null;
	public MoneyNotesDao(Connection con)
	{
		super();
		this.con = con;
	}

	private static final String FIND_ALL =
			"SELECT * FROM MONEYNOTES";
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
			mnd.setType(MoneyNoteTypeEnum.valueOf(rs.getString("type")));
			mnd.setProductID(rs.getInt("productID"));
			mnd.setCategoryID(rs.getInt("categoryID"));
			mnd.setNumberOfPurchase(rs.getInt("NumberOfPurchase"));
			mnd.setAmount(rs.getInt("amount"));
			mnd.setPurchaseIntervalDays(rs.getInt("PARCHASEINTERVALDAYS"));

			dtoList.add(mnd);
		}
		stmt.close();
		return dtoList;
	}

	private static final String FIND_BY_USERID =
			"SELECT * FROM MONEYNOTES WHERE UserID = ?";
	public List<MoneyNotesDto> findByUserID(int userID) throws SQLException
	{
		PreparedStatement stmt = con.prepareStatement( FIND_BY_USERID );
		stmt.setInt(1, userID);
		ResultSet rs = stmt.executeQuery();

		List<MoneyNotesDto> dtoList = new ArrayList<MoneyNotesDto>();
		while(rs.next())
		{
			MoneyNotesDto mnd = new MoneyNotesDto();
			mnd.setMoneyNoteID(rs.getInt("moneyNoteID"));
			mnd.setUserID(rs.getInt("userID"));
			mnd.setPurchaseDate(rs.getDate("purchaseDate").toLocalDate());
			mnd.setType(MoneyNoteTypeEnum.valueOf(rs.getString("type")));
			mnd.setProductID(rs.getInt("productID"));
			mnd.setCategoryID(rs.getInt("categoryID"));
			mnd.setNumberOfPurchase(rs.getInt("NumberOfPurchase"));
			mnd.setAmount(rs.getInt("amount"));
			mnd.setPurchaseIntervalDays(rs.getInt("PARCHASEINTERVALDAYS"));

			dtoList.add(mnd);
		}
		stmt.close();
		return dtoList;
	}

	private static final String FIND_BY_USERID_WITH_ID_NAME =
		"SELECT * FROM MONEYNOTES "
		+ "INNER JOIN Products ON MoneyNotes.ProductID = Products.ProductID "
		+ "INNER JOIN MoneyCategorys ON MoneyNotes.CategoryID = MoneyCategorys.MoneyCategorysID "
		+ "WHERE UserID = ?";
	public List<MoneyNotesDto> findByUserIDWithIDName(int userID) throws SQLException
	{
		PreparedStatement stmt = con.prepareStatement( FIND_BY_USERID_WITH_ID_NAME );
		stmt.setInt(1, userID);
		ResultSet rs = stmt.executeQuery();


		List<MoneyNotesDto> dtoList = new ArrayList<MoneyNotesDto>();
		while(rs.next())
		{
			MoneyNotesDto mnd = new MoneyNotesDto();
			mnd.setProductName(rs.getString("Products.ProductName"));
			mnd.setMoneyNoteID(rs.getInt("moneyNoteID"));
			mnd.setUserID(rs.getInt("userID"));
			mnd.setPurchaseDate(rs.getDate("purchaseDate").toLocalDate());
			mnd.setType(MoneyNoteTypeEnum.valueOf(rs.getString("type")));
			mnd.setProductID(rs.getInt("productID"));
			mnd.setCategoryID(rs.getInt("categoryID"));
			mnd.setNumberOfPurchase(rs.getInt("NumberOfPurchase"));
			mnd.setAmount(rs.getInt("amount"));
			mnd.setPurchaseIntervalDays(rs.getInt("PurchaseIntervalDays"));
			mnd.setCategoryName(rs.getString("MoneyCategorys.CategoryName"));
			dtoList.add(mnd);

		}
		if(stmt != null) stmt.close();
		return dtoList;
	}

	private static final String FIND_BY_USERID_DATE =
			"SELECT * FROM MONEYNOTES "
			+ "INNER JOIN Products ON MoneyNotes.ProductID = Products.ProductID "
			+ "INNER JOIN MoneyCategorys ON MoneyNotes.CategoryID = MoneyCategorys.MoneyCategorysID "
			+ "WHERE UserID = ? "
			+ "AND PurchaseDate >= ? AND PurchaseDate <= ?";
		public List<MoneyNotesDto> findByDate(int userID,LocalDate sinceDate, LocalDate untilDate) throws SQLException
		{
			PreparedStatement stmt = con.prepareStatement( FIND_BY_USERID_DATE );
			stmt.setInt(1, userID);
			stmt.setString(2, sinceDate.toString());
			stmt.setString(3, untilDate.toString());
			ResultSet rs = stmt.executeQuery();

			List<MoneyNotesDto> dtoList = new ArrayList<MoneyNotesDto>();
			while(rs.next())
			{
				MoneyNotesDto mnd = new MoneyNotesDto();
				mnd.setProductName(rs.getString("Products.ProductName"));
				mnd.setMoneyNoteID(rs.getInt("moneyNoteID"));
				mnd.setUserID(rs.getInt("userID"));
				mnd.setPurchaseDate(rs.getDate("purchaseDate").toLocalDate());
				mnd.setType(MoneyNoteTypeEnum.valueOf(rs.getString("type")));
				mnd.setProductID(rs.getInt("productID"));
				mnd.setCategoryID(rs.getInt("categoryID"));
				mnd.setNumberOfPurchase(rs.getInt("NumberOfPurchase"));
				mnd.setAmount(rs.getInt("amount"));
				mnd.setPurchaseIntervalDays(rs.getInt("PurchaseIntervalDays"));
				mnd.setCategoryName(rs.getString("MoneyCategorys.CategoryName"));
				dtoList.add(mnd);
			}
			if(stmt != null) stmt.close();
			return dtoList;
		}
}
