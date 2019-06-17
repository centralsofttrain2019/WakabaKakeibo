package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import bean.BLBean;
import dto.BlogLikesDto;

public class BlogLikesDao {


	private static final String FIND_ALL_LIKES =
			"SELECT * FROM wakaba_schema.bloglikes;";

	private static final String DELETE_LIKE =
			"DELETE FROM `wakaba_schema`.`bloglikes`" +
			"WHERE UserID=? AND BlogID=? ";

	private static final String INSERT_LIKE =
			"INSERT INTO `wakaba_schema`.`bloglikes`\r\n" +
			"(`UserID`,\r\n" +
			"`BlogID`,\r\n" +
			"`LikeDate`)\r\n" +
			"VALUES\r\n" +
			"(?, \r\n" +
			"?, \r\n" +
			"?);";

	private Connection con = null;

	public BlogLikesDao(Connection con)
	{
		super();
		this.con = con;
	}


	public List<BLBean> selectAllLikes() throws SQLException
	{
		PreparedStatement stmt = con.prepareStatement( FIND_ALL_LIKES );

		System.out.println("hisdao-1");

		try {
			ResultSet rs = stmt.executeQuery();

			List<BLBean> blList = new ArrayList<BLBean>();
			//System.out.println("hisdao-2");
			while(rs.next())
			{
				BlogLikesDto bDto = new BlogLikesDto();
				BLBean blBean = new BLBean();


				bDto.setUserID(rs.getInt("UserID"));
				bDto.setBlogID(rs.getInt("BlogID"));
				bDto.setLikeDate(rs.getTimestamp("LikeDate"));

				blBean.setDto(bDto);

				blList.add(blBean);
			}

			return blList;
		}
		finally
		{
			if(stmt != null)
				stmt.close();
		}
	}

	public void changeLike(int UserID, int BLogID, Timestamp likeDate, String like) throws SQLException
	{
//		PreparedStatement stmt = con.prepareStatement(INSERT_COMMENT);

		System.out.println("hisdao-1");
		if(like.equals("like")) {
		// オートクローズ版
				try( PreparedStatement stmt = con.prepareStatement( INSERT_LIKE ) )
				{
					stmt.setInt( 1, UserID);
					stmt.setInt( 2, BLogID);
					stmt.setTimestamp( 3, likeDate);
					stmt.executeUpdate();

				}
		}else {

			try( PreparedStatement stmt = con.prepareStatement( DELETE_LIKE ) )
			{
				stmt.setInt( 1, UserID);
				stmt.setInt( 2, BLogID);
				stmt.executeUpdate();

			}
		}
	}
}
