package bean;

import java.util.List;

import dto.UsersDto;

public class ChatBean
{
	private int userID;
	private String password;
	private MessageListBean messageListBean;
	private UsersDto usersDto;
	private List<String> log;

	public final static String USERINFO_SESSION_SAVE_NAME= "UserInfo";

	public int getUserID()
	{
		return userID;
	}

	public List<String> getLog() {
		return log;
	}

	public void setLog(String name, String content) {

		this.log.add(name + " : " + content);

	}

	public void setUserID(int userID)
	{
		this.userID = userID;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public MessageListBean getMessageListBean() {
		return messageListBean;
	}

	public void setMessageListBean(MessageListBean messageListBean) {
		this.messageListBean = messageListBean;
	}

	public UsersDto getUsersDto() {
		return usersDto;
	}

	public void setUsersDto(UsersDto usersDto) {
		this.usersDto = usersDto;
	}

	public static String getUserinfoSessionSaveName() {
		return USERINFO_SESSION_SAVE_NAME;
	}

	@Override
	public String toString() {
		return "ChatBean [userID=" + userID + ", password=" + password + ", messageListBean=" + messageListBean + "]";
	}


}
