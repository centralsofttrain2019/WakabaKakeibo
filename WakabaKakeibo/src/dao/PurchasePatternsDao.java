package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
			dto.setProductName(rs.getString("ProductName"));
			dto.setDatePatternType(DatePatternTypeEnum.valueOf(rs.getString("DatePatternType")));
			dto.setLastPurchaseDate(rs.getDate("LastPurchaseDate").toLocalDate());
			dto.setNumberPattern(rs.getInt("NumberPattern"));
			dto.setAmountPattern(rs.getInt("AmountPattern"));
			list.add(dto);
		}
		return list;
	}

	private static final String INSERT_SQL =
			"INSERT INTO PurchasePatterns "
			+ "(UserID, ProductID, DatePatternType, LastPurchaseDate, NumberPattern, AmountPattern) VALUES "
			+ "(?,?,?,?,?,?)";
	public void insertData(PurchasePatternsDto dto ) throws SQLException
	{
		PreparedStatement stmt = con.prepareStatement(INSERT_SQL);
		stmt.setInt(1, dto.getUserID());
		stmt.setInt(2, dto.getProductID());
		stmt.setString(3, dto.getDatePatternType().toString());
		stmt.setDate(4, java.sql.Date.valueOf(dto.getLastPurchaseDate()));
		stmt.setInt(5, dto.getNumberPattern());
		stmt.setInt(6, dto.getAmountPattern());
		stmt.executeUpdate();
	}
	public void insertData(int userID, int productID, DatePatternTypeEnum pattern , LocalDate lastPurchaseDate, int amountPattern, int numberPattern) throws SQLException
	{
		PreparedStatement stmt = con.prepareStatement(INSERT_SQL);
		stmt.setInt(1, userID);
		stmt.setInt(2, productID);
		stmt.setString(3, pattern.toString());
		stmt.setDate(4, java.sql.Date.valueOf(lastPurchaseDate));
		stmt.setInt(5, numberPattern);
		stmt.setInt(6, amountPattern);
		stmt.executeUpdate();
	}

	private static final String UPDATE_SQL_HEAD = "UPDATE PurchasePatterns ";

	private static final String UPDATE_SQL_FOOT = " WHERE UserID = ? AND ProductID = ?";
	public void updateData(int userID, int productID, DatePatternTypeEnum pattern , LocalDate lastPurchaseDate, int amountPattern, int numberPattern)
			throws SQLException
	{
		String sqlBody = "SET ";

		if(lastPurchaseDate != null) {
			sqlBody += "LastPurchaseDate = '" + lastPurchaseDate.toString() + "'";
		}
		if(amountPattern != -1) {
			if(!sqlBody.equals("SET ")) {
				sqlBody += ", ";
			}
			sqlBody += " AmountPattern = " + amountPattern;
		}
		if(numberPattern != -1) {
			if(!sqlBody.equals("SET ")) {
				sqlBody += ", ";
			}
			sqlBody += " NumberPattern = " + numberPattern;
		}
		if(numberPattern != -1) {
			if(!sqlBody.equals("SET ")) {
				sqlBody += ", ";
			}
			sqlBody += " DatePatternType = '" + pattern.toString() + "'";
		}

		PreparedStatement stmt = con.prepareStatement(UPDATE_SQL_HEAD + sqlBody + UPDATE_SQL_FOOT);
		stmt.setInt(1, userID);
		stmt.setInt(2, productID);

		int res = stmt.executeUpdate();

		//更新が失敗したため、インサートする
		if(res == 0) {
			insertData(userID, productID, pattern , lastPurchaseDate, amountPattern, numberPattern);
		}
	}

	private static final String DELETE_SQL =
			"DELETE FROM PurchasePatterns "
			+ "WHERE UserID = ? AND ProductID = ?";
	public void deleteData(int userID, int productID) throws SQLException
	{
		PreparedStatement stmt = con.prepareStatement(DELETE_SQL);
		stmt.setInt(1, userID);
		stmt.setInt(2, productID);

		System.out.println("Delete Pattern Table :" + stmt);
		stmt.executeUpdate();
	}

}

