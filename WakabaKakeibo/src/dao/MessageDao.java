package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.EventTypeEnum;
import domain.MessageTypeEnum;
import dto.MessageDto;

public class MessageDao {

	private static final String FIND_ALL =
			"SELECT * FROM MESSAGES";

	private static final String FIND_BY_ID =
			"SELECT * FROM MESSAGES WHERE MessageID = ?";

	private Connection con = null;

	public MessageDao(Connection con)
	{
		super();
		this.con = con;
	}


	public List<MessageDto> selectAll() throws SQLException
	{
		PreparedStatement stmt = con.prepareStatement( FIND_ALL );

		System.out.println("hisdao-1");

		try {
			ResultSet rs = stmt.executeQuery();

			List<MessageDto> dtoList = new ArrayList<MessageDto>();
			//System.out.println("hisdao-2");
			while(rs.next())
			{
				MessageDto md = new MessageDto();
				md.setMessageId(rs.getInt("MessageID"));
				md.setMessageCount(rs.getString("MessageContent"));
				md.setMessageType(MessageTypeEnum.valueOf(rs.getString("MessageType")));
				md.setEventType(EventTypeEnum.valueOf(rs.getString("EventType")));


				dtoList.add(md);
			}

			return dtoList;
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

	private static final String FIND_BY_TYPE =
			"SELECT * FROM MESSAGES WHERE "
			+ "MessageType = ? "
			+ "EventType = ?";

	public MessageDto findByType(EventTypeEnum eventType, MessageTypeEnum messageType) throws SQLException
	{
		MessageDto ret = new MessageDto();

		// オートクローズ版
		try( PreparedStatement stmt = con.prepareStatement( FIND_BY_TYPE ) )
		{
			stmt.setString( 1, messageType.toString() );
			stmt.setString(2, eventType.toString());
			ResultSet rs= stmt.executeQuery();

			if( rs.next() )
			{
				//ret.setEmployeeID( rs.getInt( "EmployeeID" ) );

				ret.setMessageId(rs.getInt("MessageID"));
				ret.setMessageCount(rs.getString("MessageContent"));
				ret.setMessageType(MessageTypeEnum.valueOf(rs.getString("MessageType")));
				ret.setEventType(EventTypeEnum.valueOf(rs.getString("EventType")));
			}
			else
			{
				return null;
			}
		}

		return ret;
	}


}
