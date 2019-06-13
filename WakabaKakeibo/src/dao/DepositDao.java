package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.DepositDto;

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


}
