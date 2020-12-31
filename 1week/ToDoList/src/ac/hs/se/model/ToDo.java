package ac.hs.se.model;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class ToDo {

	static int cnt = 1;
	private int id; // Primary Key
	private String status;
	private String content;
	private String date;

	public ToDo() {
	}

	public ToDo(String content) {
		this.id = cnt++;
		this.status = "toDo";
		this.date = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
		this.content = content;
	}

	public ToDo(String date, String content) {
		this.id = cnt++;
		this.status = "toDo";
		this.date = date;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	@Override
	public String toString() {
		return getId() + "\t" + getDate() + "\t" + getContent();
	}
}