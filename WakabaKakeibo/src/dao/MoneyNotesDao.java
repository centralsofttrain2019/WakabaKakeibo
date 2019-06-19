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

	//家計簿データの内容をdtoにコピーする
	private void SetMoneyNotesResultSet(MoneyNotesDto dto, ResultSet rs)
			throws SQLException
	{
		dto.setMoneyNoteID(rs.getInt("MoneyNoteID"));
		dto.setUserID(rs.getInt("UserID"));
		dto.setPurchaseDate(rs.getDate("PurchaseDate").toLocalDate());
		dto.setType(MoneyNoteTypeEnum.valueOf(rs.getString("Type")));
		dto.setProductID(rs.getInt("ProductID"));
		dto.setCategoryID(rs.getInt("CategoryID"));
		dto.setNumberOfPurchase(rs.getInt("NumberOfPurchase"));
		dto.setAmount(rs.getInt("Amount"));
		dto.setPurchaseIntervalDays(rs.getInt("PurchaseIntervalDays"));
	}

	//家計簿データを全件取得する
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

			this.SetMoneyNotesResultSet(mnd, rs);

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
			this.SetMoneyNotesResultSet(mnd, rs);

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
			this.SetMoneyNotesResultSet(mnd, rs);
			mnd.setProductName(rs.getString("Products.ProductName"));

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


	//一人のユーザの家計簿データのうちある期間だけを商品名、カテゴリ名を付けた状態で取得する
	private static final String FIND_BY_USERID_DATE_SORT =
			"SELECT * FROM MONEYNOTES "
			+ "INNER JOIN Products ON MoneyNotes.ProductID = Products.ProductID "
			+ "INNER JOIN MoneyCategorys ON MoneyNotes.CategoryID = MoneyCategorys.MoneyCategorysID "
			+ "WHERE UserID = ? "
			+ "AND PurchaseDate >= ? AND PurchaseDate <= ? "
			+ "ORDER BY ProductID ASC, PurchaseDate DESC";
	public List<MoneyNotesDto> findByDateWithSorted(int userID,LocalDate sinceDate, LocalDate untilDate) throws SQLException
	{
		PreparedStatement stmt = con.prepareStatement( FIND_BY_USERID_DATE_SORT );
		stmt.setInt(1, userID);
		stmt.setString(2, sinceDate.toString());
		stmt.setString(3, untilDate.toString());
		ResultSet rs = stmt.executeQuery();

		List<MoneyNotesDto> dtoList = new ArrayList<MoneyNotesDto>();
		while(rs.next())
		{
			MoneyNotesDto mnd = new MoneyNotesDto();
			this.SetMoneyNotesResultSet(mnd, rs);
			mnd.setProductName(rs.getString("Products.ProductName"));
			mnd.setCategoryName(rs.getString("MoneyCategorys.CategoryName"));
			dtoList.add(mnd);
		}
		if(stmt != null) stmt.close();
		return dtoList;
	}

	//一人のユーザの家計簿データのうちある商品の購入履歴を取得
	private static final String FIND_BY_USERID_PRODUCTID_SORT =
			"SELECT * FROM MONEYNOTES "
			+ "INNER JOIN Products ON MoneyNotes.ProductID = Products.ProductID "
			+ "INNER JOIN MoneyCategorys ON MoneyNotes.CategoryID = MoneyCategorys.MoneyCategorysID "
			+ "WHERE UserID = ? "
			+ "AND Products.ProductID = ? "
			+ "ORDER BY PurchaseDate DESC";
	public List<MoneyNotesDto> findByProductIDWithSorted(int userID,int productID) throws SQLException
	{
		PreparedStatement stmt = con.prepareStatement( FIND_BY_USERID_PRODUCTID_SORT );
		stmt.setInt(1, userID);
		stmt.setInt(2, productID);
		ResultSet rs = stmt.executeQuery();

		List<MoneyNotesDto> dtoList = new ArrayList<MoneyNotesDto>();
		while(rs.next())
		{
			MoneyNotesDto mnd = new MoneyNotesDto();
			this.SetMoneyNotesResultSet(mnd, rs);
			mnd.setProductName(rs.getString("Products.ProductName"));
			mnd.setCategoryName(rs.getString("MoneyCategorys.CategoryName"));
			dtoList.add(mnd);
		}
		if(stmt != null) stmt.close();
		return dtoList;
	}

	//一人のユーザの家計簿データのある期間内に購入した商品ID一覧を取得
	private static final String FIND_BY_USERID_DATE_PRODUCTID =
			"SELECT ProductID FROM MONEYNOTES "
			+ "WHERE UserID = ? "
			+ "AND PurchaseDate >= ? AND PurchaseDate <= ? "
			+ "GROUP BY ProductID "
			+ "ORDER BY ProductID ASC";
	public List<Integer> getProductIDsByDate(int userID,LocalDate sinceDate, LocalDate untilDate) throws SQLException
	{
		PreparedStatement stmt = con.prepareStatement( FIND_BY_USERID_DATE_PRODUCTID );
		stmt.setInt(1, userID);
		stmt.setString(2, sinceDate.toString());
		stmt.setString(3, untilDate.toString());
		ResultSet rs = stmt.executeQuery();

		List<Integer> idList = new ArrayList<Integer>();
		while(rs.next())
		{
			int id = rs.getInt("ProductID");
			idList.add(id);
		}
		if(stmt != null) stmt.close();

		return idList;
	}


	//ユーザのある商品の最終購入日を取得
	private static final String GET_LAST_PURCHASE_DATE =
			"SELECT * FROM MoneyNotes "
			+ "WHERE UserID = ? AND ProductID = ? "
			+ "ORDER BY PurchaseDate DESC";
	public LocalDate getLastPurchaseDate(int userID, int productID) throws SQLException
	{
		PreparedStatement stmt = con.prepareStatement( GET_LAST_PURCHASE_DATE );
		stmt.setInt(1, userID);
		stmt.setInt(2, productID);
		ResultSet rs = stmt.executeQuery();

		if(rs.next())
		{
			LocalDate date = rs.getDate("PurchaseDate").toLocalDate();
			return date;
		}else
		{
			throw new RuntimeException();
		}
	}

	//過去の購入情報からカテゴリIDを検索する
	private static final String GET_CATEGORY_ID_BY_PRODUCT_ID=
			"SELECT CategoryID FROM MoneyNotes "
			+ "WHERE ProductID = ? AND TYPE = 'EXPENSE' ";

	public int getCategoryID(int productID) throws SQLException
	{
		PreparedStatement stmt = con.prepareStatement( GET_CATEGORY_ID_BY_PRODUCT_ID );
		stmt.setInt(1, productID);
		ResultSet rs = stmt.executeQuery();

		if(rs.next()) {
			int id = rs.getInt("CategoryID");
			return id;
		}else
		{
			return -1;
		}
	}

	//商品を挿入する
	private static final String INSERT_MONEY_NOTE=
			"INSERT INTO MoneyNotes " +
			"(UserID,PurchaseDate,type,ProductID,CategoryID,NumberOfPurchase,Amount,PurchaseIntervalDays) VALUES " +
			"(?,?,?,?,?,?,?,?)";

	public int insertMoneyNotes(MoneyNotesDto dto) throws SQLException
	{
		PreparedStatement stmt = con.prepareStatement( INSERT_MONEY_NOTE );
		stmt.setInt(1, dto.getUserID());
		stmt.setDate(2, java.sql.Date.valueOf(dto.getPurchaseDate()));
		stmt.setString(3,  dto.getType().toString());
		stmt.setInt(4, dto.getProductID());
		stmt.setInt(5, dto.getCategoryID());
		stmt.setInt(6, dto.getNumberOfPurchase());
		stmt.setInt(7, dto.getAmount());
		stmt.setInt(8, dto.getPurchaseIntervalDays());

		int res = stmt.executeUpdate();
		return res;
	}

	//商品名から商品IDを検索
	private static final String GET_PRODUCT_ID_BY_NAME=
			"SELECT ProductID FROM Products "
			+ "WHERE ProductName = ?";
	public int findProductID(String productName) throws SQLException
	{
		PreparedStatement stmt = con.prepareStatement( GET_PRODUCT_ID_BY_NAME );
		stmt.setString(1,productName);
		System.out.println(stmt.toString());

		ResultSet rs = stmt.executeQuery();

		if(rs.next())
		{
			int id = rs.getInt("ProductID");
			return id;
		}else
		{
			System.out.println("商品未登録");
			return -1;
		}
	}


}

