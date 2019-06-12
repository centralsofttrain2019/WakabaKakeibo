package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.DatePatternTypeEnum;
import dto.PurchasePatternsDto;

public class PurchasePatternsDao
{
	private Connection con;
	public PurchasePatternsDao(Connection con)
	{
		super();
		this.con = con;
	}

	private static final String SELCT_SQL =
			"SELECT * "
			+ "FROM PurchasePatterns "
			+ "INNER JOIN Products "
			+ "ON PurchasePatterns.ProductID = Products.ProductID "
			+ "WHERE UserID = ?";
	public List<PurchasePatternsDto> findByUserID(int id) throws SQLException
	{
		PreparedStatement stmt = con.prepareStatement(SELCT_SQL);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		List<PurchasePatternsDto> list = new ArrayList<PurchasePatternsDto>();

		while(rs.next())
		{
			PurchasePatternsDto dto = new PurchasePatternsDto();
			dto.setPurchasePatternID(rs.getInt("PurchasePatternID"));
			dto.setUserID(rs.getInt("UserID"));
			dto.setProductID(rs.getInt("Products.ProductID"));
			dto.setDatePatternType(DatePatternTypeEnum.valueOf(rs.getString("DatePatternType")));
			dto.setLastPurchaseDate(rs.getDate("LastPurchaseDate").toLocalDate());
			dto.setNumberPattern(rs.getInt("NumberPattern"));
			dto.setAmountPattern(rs.getInt("AmountPattern"));
			list.add(dto);
		}
		return list;
	}
}

