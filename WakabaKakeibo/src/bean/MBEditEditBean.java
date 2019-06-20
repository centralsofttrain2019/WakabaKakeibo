package bean;

public class MBEditEditBean {

	private String userName;
	private String content;
	private String title;
	private String category;
	private String BlogID;



	public String getBlogID() {
		return BlogID;
	}
	public void setBlogID(String blogID) {
		BlogID = blogID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "MBEditEditBean [userName=" + userName + ", content=" + content + ", title=" + title + ", category="
				+ category + ", BlogID=" + BlogID + "]";
	}



}
