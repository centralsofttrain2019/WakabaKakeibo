package bean;

public class UserRegistBean {
	private boolean error;

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "UserRegistBean [error=" + error + "]";
	}


}
