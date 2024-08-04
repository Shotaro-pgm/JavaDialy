package model;

public class Contribution {
	private String id;
	private String title;
	private String text;
	private String userId;
	private String createdDatetime;
	private String updateDatetime;
	
	public Contribution() {}
	public Contribution(String id, String title, String createdDatetime) {
		this.id = id;
		this.title = title;
		this.createdDatetime = createdDatetime;
	}
	public Contribution(String id, String title, String text, String userId, String createdDatetime) {
		this.id = id;
		this.title = title;
		this.text = text;
		this.userId = userId;
		this.createdDatetime = createdDatetime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getCreatedDatetime() {
		return createdDatetime;
	}
	public void setCreatedDatetime(String createdDatetime) {
		this.createdDatetime = createdDatetime;
	}
	public String getUpdateDatetime() {
		return updateDatetime;
	}
	public void setUpdateDatetime(String updateDatetime) {
		this.updateDatetime = updateDatetime;
	}

}
