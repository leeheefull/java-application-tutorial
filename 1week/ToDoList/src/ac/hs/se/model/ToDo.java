package ac.hs.se.model;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class ToDo {

	private int id; // Primary Key
	private String content;
	private String date;
	private String status;

	public ToDo() {
	}

	public ToDo(int id, String content) {
		this.id = id;
		this.date = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
		this.content = content;
		this.status = "TODO";
	}

	public ToDo(int id, String date, String content) {
		this.id = id;
		this.date = date;
		this.content = content;
		this.status = "TODO";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return getId() + "\t" + getDate() + "\t" + getContent();
	}
}