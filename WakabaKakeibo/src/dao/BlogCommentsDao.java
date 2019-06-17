package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import bean.MBCommentBean;
import dto.MBCommentDto;

public class BlogCommentsDao {
//	private static final String FIND_ALL =
//			"SELECT * FROM BlogComments";

	private static final String FIND_ALL =
			"SELECT `blogcomments`.`commentID`,\r\n" +
			"    `blogcomments`.`UserID`,\r\n" +
			"    `blogcomments`.`BlogID`,\r\n" +
			"    `blogcomments`.`CommentDate`,\r\n" +
			"    `blogcomments`.`Content`,\r\n" +
			"    users.UserName\r\n" +
			"FROM `wakaba_schema`.`blogcomments`,\r\n" +
			"users\r\n" +
			"where\r\n" +
			"blogcomments.UserID = users.UserID;";

	private static final String FIND_BY_ID =
			"SELECT * FROM BlogComments WHERE MessageID = ?";

	private static final String INSERT_COMMENT = "INSERT INTO blogcomments(UserID, BLogID, CommentDate, Content) VALUES\r\n" +
	"(?, ?, ?, ?);";

	private Connection con = null;

	public BlogCommentsDao(Connection con)
	{
		super();
		this.con = con;
	}


	public List<MBCommentBean> selectAll() throws SQLException
	{
		PreparedStatement stmt = con.prepareStatement( FIND_ALL );

		System.out.println("hisdao-1");

		try {
			ResultSet rs = stmt.executeQuery();

			List<MBCommentBean> beanList = new ArrayList<MBCommentBean>();
			//System.out.println("hisdao-2");
			while(rs.next())
			{
				MBCommentDto cDto = new MBCommentDto();
				MBCommentBean cBean = new MBCommentBean();


				cDto.setCommentID(rs.getInt("CommentID"));
				cDto.setBlogID(rs.getInt("UserID"));
				cDto.setBlogID(rs.getInt("BlogID"));
				cDto.setCommentDate(rs.getTimestamp("CommentDate"));
				cDto.setContent(rs.getString("Content"));
				cDto.setUserName(rs.getString("UserName"));

				cBean.setDto(cDto);

				beanList.add(cBean);
			}

			return beanList;
		}
		finally
		{
			if(stmt != null)
				stmt.close();
		}
	}

	public void insertComment(int UserID, int BLogID, Timestamp CommentDate, String Content) throws SQLException
	{
//		PreparedStatement stmt = con.prepareStatement(INSERT_COMMENT);

		System.out.println("hisdao-1");

		// オートクローズ版
				try( PreparedStatement stmt = con.prepareStatement( INSERT_COMMENT ) )
				{
					stmt.setInt( 1, UserID);
					stmt.setInt( 2, BLogID);
					stmt.setTimestamp( 3, CommentDate);
					stmt.setString( 4, Content);
					stmt.executeUpdate();

				}
	}

//	public static LocalDate date2LocalDate(LocalDate date) {
//		  return date.toLocalDateTime();
//		}
}
