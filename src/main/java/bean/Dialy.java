package bean;

public class Dialy {
	private String title;
	private String text;
	private String userId;
	
	public Dialy() {}
	public Dialy(String title, String text, String userId) {
		this.title = title;
		this.text = text;
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
