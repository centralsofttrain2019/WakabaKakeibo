package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import bean.MBBean;
import domain.BlogCategoryEnum;
import domain.EventTypeEnum;
import domain.MessageTypeEnum;
import dto.BlogsDto;
import dto.MessageDto;

public class BlogsDao {

	private static final String FIND_ALL_BLOGS =
			"SELECT `blogs`.`blogID`,\r\n" +
			"    `blogs`.`UserID`,\r\n" +
			"    `blogs`.`CreateDate`,\r\n" +
			"    `blogs`.`Title`,\r\n" +
			"    `blogs`.`Content`,\r\n" +
			"    `blogs`.`Category`,\r\n" +
			"    `blogs`.`Image1`,\r\n" +
			"    `blogs`.`Image2`,\r\n" +
			"    `blogs`.`ReblogID`,\r\n" +
			"    users.UserName\r\n" +
			"FROM `wakaba_schema`.`blogs`,\r\n" +
			"users\r\n" +
			"WHERE\r\n" +
			"blogs.UserID = users.UserID;";



	private static final String FIND_BLOG_BY_ID =
			"SELECT * FROM BLOGS WHERE MessageID = ?";

	private static final String INSERT_BLOG = "INSERT INTO blogs(UserID, CreateDate, Title, Content, Category, image1, image2, ReblogID) VALUES\r\n" +
			"(?, ?, ?, ?, ?, ?, ?, ?);";

	private static final String UPDATE_BLOG = "UPDATE `wakaba_schema`.`blogs`\r\n" +
			"SET\r\n" +
			"`CreateDate` = ?,\r\n" +
			"`Title` = ?,\r\n" +
			"`Content` = ?,\r\n" +
			"`Category` = ?,\r\n" +
			"`Image1` = ?,\r\n" +
			"`Image2` = ?,\r\n" +
			"`ReblogID` = ?\r\n" +
			"WHERE `blogID` = ?;";

	private Connection con = null;

	public BlogsDao(Connection con)
	{
		super();
		this.con = con;
	}


	public List<MBBean> selectAllBlog() throws SQLException
	{
		PreparedStatement stmt = con.prepareStatement( FIND_ALL_BLOGS );

		System.out.println("hisdao-1");

		try {
			ResultSet rs = stmt.executeQuery();

			List<MBBean> beanList = new ArrayList<MBBean>();
			//System.out.println("hisdao-2");
			while(rs.next())
			{
				BlogsDto bDto = new BlogsDto();
				MBBean mbBean = new MBBean();


				bDto.setUserId(rs.getInt("UserID"));
				bDto.setBlogID(rs.getInt("BlogID"));
				bDto.setCreateDate(rs.getTimestamp("CreateDate"));
				bDto.setTitle(rs.getString("Title"));
				bDto.setContent(rs.getString("Content"));
				bDto.setCategory(BlogCategoryEnum.valueOf(rs.getString("Category")));
				bDto.setImage1(rs.getString("Image1"));
				bDto.setImage2(rs.getString("Image2"));
				bDto.setReblogID(rs.getInt("ReblogID"));
				bDto.setUserName(rs.getString("UserName"));

				mbBean.setDto(bDto);

				beanList.add(mbBean);
			}

			return beanList;
		}
		finally
		{
			if(stmt != null)
				stmt.close();
		}
	}

	public MessageDto findBlogById(int id) throws SQLException
	{
		MessageDto ret = new MessageDto();

		// オートクローズ版
		try( PreparedStatement stmt = con.prepareStatement( FIND_BLOG_BY_ID ) )
		{
			stmt.setInt( 1, id );
			ResultSet rs= stmt.executeQuery();

			while( rs.next() )
			{
				//ret.setEmployeeID( rs.getInt( "EmployeeID" ) );

				ret.setMessageId(rs.getInt("MessageID"));
				ret.setMessageCount(rs.getString("MessageContent"));
				ret.setMessageType(MessageTypeEnum.valueOf(rs.getString("MessageType")));
				ret.setEventType(EventTypeEnum.valueOf(rs.getString("EventType")));
			}
		}

		return ret;
	}

	public void insertBlog(int UserID, Timestamp CreateDate, String Title, String Content, BlogCategoryEnum Category, String image1, String image2, int ReblogID) throws SQLException
	{
//		PreparedStatement stmt = con.prepareStatement(INSERT_COMMENT);

		System.out.println("hisdao-1");

		// オートクローズ版
				try( PreparedStatement stmt = con.prepareStatement( INSERT_BLOG ) )
				{

					stmt.setInt( 1, UserID);
					stmt.setTimestamp( 2, CreateDate);
					stmt.setString( 3, Title);
					stmt.setString( 4, Content);
					stmt.setString( 5, Category.toString());
					stmt.setString( 6, image1);
					stmt.setString( 7, image2);
					stmt.setInt( 8, ReblogID);
					stmt.executeUpdate();

				}
	}

	public void updateBlog(Timestamp CreateDate, String Title, String Content, BlogCategoryEnum Category, String image1, String image2, int ReblogID, int blogID) throws SQLException
	{
//		PreparedStatement stmt = con.prepareStatement(INSERT_COMMENT);

		System.out.println("hisdao-1");

		// オートクローズ版
				try( PreparedStatement stmt = con.prepareStatement( UPDATE_BLOG ) )
				{
					stmt.setTimestamp( 1, CreateDate);
					stmt.setString( 2, Title);
					stmt.setString( 3, Content);
					stmt.setString( 4, Category.toString());
					stmt.setString( 5, image1);
					stmt.setString( 6, image2);
					stmt.setInt( 7, ReblogID);
					stmt.setInt( 8, blogID);
					stmt.executeUpdate();

				}
	}



	public static LocalDate date2LocalDate(Date date) {
		  return date.toLocalDate();
		}






}
