package dto;

import java.sql.Timestamp;

public class BlogLikesDto
{

	private int likeID;
	private int userID;
	private int blogID;
	private Timestamp likeDate;
	public int getLikeID()
	{
		return likeID;
	}
	public void setLikeID(int likeID)
	{
		this.likeID = likeID;
	}
	public int getUserID()
	{
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getBlogID() {
		return blogID;
	}
	public void setBlogID(int blogID) {
		this.blogID = blogID;
	}
	public Timestamp getLikeDate() {
		return likeDate;
	}
	public void setLikeDate(Timestamp likeDate) {
		this.likeDate = likeDate;
	}


}
