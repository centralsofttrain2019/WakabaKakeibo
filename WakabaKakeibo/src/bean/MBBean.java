package bean;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import domain.BlogCategoryEnum;
import dto.BlogsDto;

public class MBBean {

	private int blogID;
	private int userId;
	private String createDate;
	private String title;
	private String content;
	private BlogCategoryEnum category;
	private int reblogID;
	private String image1;
	private String image2;
	private String userName;

	public String getImage1() {
		return image1;
	}
	public void setImage1(String image1) {
		this.image1 = image1;
	}
	public String getImage2() {
		return image2;
	}
	public void setImage2(String image2) {
		this.image2 = image2;
	}


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
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		this.createDate = sdf.format(createDate);
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

	public BlogCategoryEnum getCategory()
	{
		return category;
	}
	public void setCategory(BlogCategoryEnum category)
	{
		this.category = category;
	}
	public int getReblogID()
	{
		return reblogID;
	}
	public void setReblogID(int reblogID)
	{
		this.reblogID = reblogID;
	}
	public int getReblog() {
		return reblogID;
	}
	public void setReblog(int reblogID) {
		this.reblogID = reblogID;
	}



	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setDto(BlogsDto bDto) {
		this.blogID = bDto.getBlogID();
		this.category = bDto.getCategory();
		this.content = bDto.getContent();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		this.createDate = sdf.format(bDto.getCreateDate());

		this.reblogID = bDto.getReblogID();
		this.title = bDto.getTitle();
		this.userId = bDto.getUserId();
		this.image1 = bDto.getImage1();
		this.image2 = bDto.getImage2();
		this.userName = bDto.getUserName();
	}

	@Override
	public String toString() {
		return "MBBean [blogID=" + blogID + ", userId=" + userId + ", createDate=" + createDate + ", title=" + title
				+ ", content=" + content + ", category=" + category + ", reblogID=" + reblogID + ", image1=" + image1
				+ ", image2=" + image2 + "]";
	}


}
