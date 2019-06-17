package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.UsersDto;

public class UsersDao
{
	private Connection con;

	private static final String FIND_BY_USERID =
			"SELECT * FROM Users WHERE UserID = ?";

	public UsersDto getUser(int id) throws SQLException
	{
		UsersDto ud = new UsersDto();

		try(PreparedStatement stmt = con.prepareStatement( FIND_BY_USERID ))
		{
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while(rs.next())
			{

				ud.setUserID(rs.getInt("userID"));
				ud.setPassword(rs.getString("password"));
				ud.setUserName(rs.getString("password"));
				ud.setSex(rs.getString("sex"));
				ud.setBirthday(rs.getDate("birthday").toLocalDate());
				ud.setTargetAmount(rs.getInt("targetAmount"));
				ud.setPresentAmount(rs.getInt("presentAmount"));
				ud.setLastLogin(rs.getDate("lastLogin").toLocalDate());
				ud.setRunningDays(rs.getInt("runningDays"));
				ud.setFeelingLevel(rs.getInt("feelingLevel"));
				ud.setHonorific(rs.getString("honorific"));

			}
		}


		return ud;
	}
}
