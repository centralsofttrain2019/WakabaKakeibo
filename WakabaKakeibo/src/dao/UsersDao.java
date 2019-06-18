package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.UserSexEnum;
import dto.UsersDto;

public class UsersDao
{
	private Connection con;



	//コネクションをセットするコンストラクター
	public UsersDao(Connection con) {
		super();
		this.con = con;
	}


	private static final String FIND_BY_USERID =
			"SELECT * FROM Users WHERE UserID = ?";

	private static final String INSERT_USER =
			"INSERT INTO `wakaba_schema`.`users`\r\n" +
			"(`UserID`,\r\n" +
			"`Password`,\r\n" +
			"`UserName`,\r\n" +
			"`Sex`,\r\n" +
			"`Birthday`,\r\n" +
			"`TargetAmount`,\r\n" +
			"`PresentAmount`,\r\n" +
			"`LastLogin`,\r\n" +
			"`RunningDays`,\r\n" +
			"`FeelingLevel`,\r\n" +
			"`Honorific`,\r\n" +
			"`UserIcon`)\r\n" +
			"VALUES\r\n" +
			"( ?,\r\n" +
			" ?,\r\n" +
			" ?,\r\n" +
			" ?,\r\n" +
			" ?,\r\n" +
			" ?,\r\n" +
			" ?,\r\n" +
			" ?,\r\n" +
			" ?,\r\n" +
			" ?,\r\n" +
			" ?,\r\n" +
			" ?);";







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
				ud.setSex(UserSexEnum.valueOf(rs.getString("sex")));
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

	public void insertUser(UsersDto uDto) throws SQLException
	{
		System.out.println("hisdao-1");

		// オートクローズ版
				try( PreparedStatement stmt = con.prepareStatement( INSERT_USER ) )
				{
					stmt.setInt( 1, uDto.getUserID());
					stmt.setString( 2, uDto.getPassword());
					stmt.setString( 3, uDto.getUserName());
					stmt.setString( 4, uDto.getSex().toString());
					stmt.setDate( 5, java.sql.Date.valueOf(uDto.getBirthday()));
					stmt.setInt( 6, uDto.getTargetAmount());
					stmt.setInt( 7, uDto.getPresentAmount());
					stmt.setDate( 8, java.sql.Date.valueOf(uDto.getLastLogin()));
					stmt.setInt( 9, uDto.getRunningDays());
					stmt.setInt( 10, uDto.getFeelingLevel());
					stmt.setString( 11, uDto.getHonorific());
					stmt.setString( 12, null);
					stmt.executeUpdate();

				}

	}
}
