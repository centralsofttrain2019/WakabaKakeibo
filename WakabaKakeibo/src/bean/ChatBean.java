package bean;

public class ChatBean
{
	private int userID;
	private String password;
	private MessageListBean messageListBean;

	public final static String USERINFO_SESSION_SAVE_NAME= "UserInfo";

	public int getUserID()
	{
		return userID;
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


}
