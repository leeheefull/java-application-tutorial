import java.sql.Date;
import java.text.SimpleDateFormat;

public class ToDo {

	private int id;
	private String status;
	private String content;
	private String date;
	
	public ToDo() {}
	
	public ToDo(String content) {
		this.date = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
		this.content = content;
	}
	
	public ToDo(String date, String content) {
		this.date = date;
		this.content = content;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return getDate() + " " + getContent();
	}
}