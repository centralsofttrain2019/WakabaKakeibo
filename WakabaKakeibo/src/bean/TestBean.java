package bean;

public class TestBean {
	private int blogID;
	private String content;

	public TestBean() {

	}

	public int getBlogID() {
		return blogID;
	}

	public void setBlogID(int blogID) {
		this.blogID = blogID;
	}



	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "TestBean [blogID=" + blogID + ", content=" + content + "]";
	}


}
