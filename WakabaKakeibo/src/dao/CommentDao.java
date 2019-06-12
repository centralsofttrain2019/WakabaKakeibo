package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.MBCommentBean;
import dto.MBCommentDto;

public class CommentDao {
	private static final String FIND_ALL =
			"SELECT * FROM BlogComments";

	private static final String FIND_BY_ID =
			"SELECT * FROM BlogComments WHERE MessageID = ?";

	private Connection con = null;

	public CommentDao(Connection con)
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

//	public static LocalDate date2LocalDate(LocalDate date) {
//		  return date.toLocalDateTime();
//		}
}
