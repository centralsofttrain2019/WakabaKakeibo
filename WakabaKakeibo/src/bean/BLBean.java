package bean;

import java.sql.Timestamp;

import dto.BlogLikesDto;

public class BLBean {

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

	public void setDto(BlogLikesDto dto) {
		this.blogID = dto.getBlogID();
		this.likeDate = dto.getLikeDate();
		this.likeID = dto.getLikeID();
		this.userID = dto.getUserID();
	}
	@Override
	public String toString() {
		return "BLBean [likeID=" + likeID + ", userID=" + userID + ", blogID=" + blogID + ", likeDate=" + likeDate
				+ "]";
	}


}
