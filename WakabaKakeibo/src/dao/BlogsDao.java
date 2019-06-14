package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	private static final String FIND_ALL =
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

	private static final String FIND_BY_ID =
			"SELECT * FROM BLOGS WHERE MessageID = ?";

	private static final String INSERT_BLOG = "INSERT INTO blogcomments(UserID, CreateDate, Title, Content, Category, image1, image2, ReblogID) VALUES\r\n" +
			"(?, ?, ?, ?, ?, ?, ?, ?);";

	private Connection con = null;

	public BlogsDao(Connection con)
	{
		super();
		this.con = con;
	}


	public List<MBBean> selectAll() throws SQLException
	{
		PreparedStatement stmt = con.prepareStatement( FIND_ALL );

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
				bDto.setCreateDate(date2LocalDate( rs.getDate("CreateDate")));
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

	public MessageDto findById(int id) throws SQLException
	{
		MessageDto ret = new MessageDto();

		// オートクローズ版
		try( PreparedStatement stmt = con.prepareStatement( FIND_BY_ID ) )
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

	public static LocalDate date2LocalDate(Date date) {
		  return date.toLocalDate();
		}



}
