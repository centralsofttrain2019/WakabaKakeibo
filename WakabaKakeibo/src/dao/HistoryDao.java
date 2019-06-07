package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.MoneyNotesDto;

public class HistoryDao {

	private static final String FIND_ALL =
			"SELECT * FROM MONEYNOTES";

	private Connection con = null;

	public HistoryDao(Connection con)
	{
		super();
		this.con = con;
	}


	public List<MoneyNotesDto> selectAll() throws SQLException
	{
		PreparedStatement stmt = con.prepareStatement( FIND_ALL );

		System.out.println("hisdao-1");

		try {
			ResultSet rs = stmt.executeQuery();

			List<MoneyNotesDto> dtoList = new ArrayList<MoneyNotesDto>();
			System.out.println("hisdao-2");
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

			return dtoList;
		}
		finally
		{
			if(stmt != null)
				stmt.close();
		}
	}

}
