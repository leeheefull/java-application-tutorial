package ac.hs.se.model;

public enum ToDoStatus {

	TODO("TODO"), DOING("DOING"), DONE("DONE");

	private final String status;

	ToDoStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}