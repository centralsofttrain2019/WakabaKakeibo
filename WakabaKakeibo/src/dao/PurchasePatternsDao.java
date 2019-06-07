package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.PurchasePatternsDto;

public class PurchasePatternsDao
{
	private static final String DELETE_SQL =
			"DELETE "
			+ "FROM Employees " +
			"WHERE "
			+ "EmployeeID = ?";


	private static final String SELCT_SQL =
			"SELECT * "
			+ "FROM Employees "
			+ "WHERE EmployeeID = ?";

	private static final String SELECT_ALL_SQL =
			"SELECT * "
			+ "FROM Employees";

	private Connection con;

	public PurchasePatternsDao(Connection con)
	{
		super();
		this.con = con;
	}

	public void deleteEmployee( int id ) throws SQLException
	{
		//---------------------------------------
		// 処理を記述するところ

		// 送信すべきSQLの雛形を作成
		PreparedStatement stmt = con.prepareStatement( DELETE_SQL );
		stmt.setInt( 1, id );

		int r = stmt.executeUpdate();

		if( r!=1 )
			throw new RuntimeException("削除に失敗しました。");
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
			ret.setProductID(rs.getInt("ProductID"));
			ret.setDatePatternType(rs.getString("DatePatternType"));
			ret.setLastPurchaseDate(rs.getDate("LastPurchaseDate").toLocalDate());
			ret.setNumberPattern(rs.getInt("NumberPattern"));
			ret.setAmountPattern(rs.getInt("AmountPattern"));
		}

		return ret;
	}
}

