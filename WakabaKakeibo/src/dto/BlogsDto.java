package dto;

import java.time.LocalDate;

public class BlogsDto
{
	private int blogID;
	private int userId;
	private LocalDate createDate;
	private String title;
	private String content;
	private String categoryID;
	private int reblogID;
	public int getBlogID()
	{
		return blogID;
	}
	public void setBlogID(int blogID){
		this.blogID = blogID;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public LocalDate getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}
	public int getReblog() {
		return reblogID;
	}
	public void setReblog(int reblogID) {
		this.reblogID = reblogID;
	}











}
