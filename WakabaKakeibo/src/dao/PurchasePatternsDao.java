package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.PurchasePatternsDto;

public class PurchasePatternsDao
{
	private static final String SELCT_SQL =
			"SELECT * "
			+ "FROM PurchasePatterns "
			+ "WHERE PurchasePatternID = ? "
			+ "INNER JOIN Products "
			+ "ON PurchasePatterns.ProductID = Products.ProductID";

	private Connection con;

	public PurchasePatternsDao(Connection con)
	{
		super();
		this.con = con;
	}

	//-------------------------------
	public PurchasePatternsDto findByKey(int id) throws SQLException
	{
		PreparedStatement stmt = con.prepareStatement(SELCT_SQL);
		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();

		PurchasePatternsDto ret = new PurchasePatternsDto();

		while(rs.next())
		{
			ret.setPurchasePatternID(rs.getInt("PurchasePatternID"));
			ret.setUserID(rs.getInt("UserID"));
			ret.setProductID(rs.getInt("Products.ProductID"));
			ret.setDatePatternType(rs.getString("DatePatternType"));
			ret.setLastPurchaseDate(rs.getDate("LastPurchaseDate").toLocalDate());
			ret.setNumberPattern(rs.getInt("NumberPattern"));
			ret.setAmountPattern(rs.getInt("AmountPattern"));
		}

		return ret;
	}
}

