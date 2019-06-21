package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dto.DepositDto;
import dto.UsersDto;


public class DepositDao {

	private Connection con;

	private static final String GET_DEPOSIT_SQL = "SELECT "
			+ "* "
			+ "FROM "
			+ "Deposits "
			+ "WHERE "
			+ "UserID = ? "
			+ "ORDER BY "
			+ "Date ";

	private static final String INSERT_DEPOSIT = "insert into wakaba_schema.deposits(Date,Balance,UserID)\r\n"
			+"values("
			+"?,"
			+"?,"
			+"?);";

	public DepositDao(Connection con) {
		super();
		this.con = con;
	}

	public List<DepositDto> getDepositList(int userID) throws SQLException{

		PreparedStatement stmt = con.prepareStatement(GET_DEPOSIT_SQL);
		stmt.setInt(1, userID);
		List<DepositDto> list = new ArrayList<DepositDto>();
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			DepositDto dto = new DepositDto();

			dto.setDepositID(rs.getInt("DepositID"));
			dto.setDate(rs.getDate("Date").toLocalDate());
			dto.setBalance(rs.getInt("Balance"));
			dto.setUserID(userID);

			list.add(dto);
		}

		return list;

	}

	public void indertRecord(UsersDto uDto) throws SQLException
	{
		PreparedStatement stmt = con.prepareStatement(INSERT_DEPOSIT);

		System.out.println("local:");
		LocalDate local = LocalDate.now();
		//Date date = new Date();

		System.out.println("local:"+local);

		stmt.setDate( 1, (java.sql.Date.valueOf(local)) );
		stmt.setInt( 2, uDto.getPresentAmount());
		stmt.setInt( 3, uDto.getUserID());
		stmt.executeUpdate();


	}

	public void insertDeposit(int amount, int userID) throws SQLException
	{
		PreparedStatement stmt = con.prepareStatement(INSERT_DEPOSIT);

		System.out.println("local:");
		LocalDate local = LocalDate.now();
		//Date date = new Date();

		System.out.println("local:"+local);

		stmt.setDate( 1, (java.sql.Date.valueOf(local)) );
		stmt.setInt( 2, amount);
		stmt.setInt( 3, userID);
		stmt.executeUpdate();


	}

}
