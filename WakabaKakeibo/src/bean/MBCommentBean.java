package bean;

import java.sql.Timestamp;

import dto.MBCommentDto;

public class MBCommentBean {


	private int commentID;
	private int userID;
	private int blogID;
	private Timestamp commentDate;
	private String Content;
	private String userName;


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getCommentID() {
		return commentID;
	}
	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}
	public int getUserID() {
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
	public Timestamp getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Timestamp commentDate) {
		this.commentDate = commentDate;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	@Override
	public String toString() {
		return "MBCommentBean [commentID=" + commentID + ", userID=" + userID + ", blogID=" + blogID + ", commentDate="
				+ commentDate + ", Content=" + Content + ", userName=" + userName + "]";
	}

	public void setDto(MBCommentDto mbCDto) {
		this.blogID = mbCDto.getBlogID();
		this.commentDate = mbCDto.getCommentDate();
		this.commentID = mbCDto.getCommentID();
		this.Content = mbCDto.getContent();
		this.userID = mbCDto.getUserID();
		this.userName = mbCDto.getUserName();
	}
}
