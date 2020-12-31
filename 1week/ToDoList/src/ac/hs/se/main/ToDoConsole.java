package ac.hs.se.main;

import ac.hs.se.viewController.ToDoViewController;

public class ToDoConsole {

	public static void main(String[] args) {
		try {
			ToDoViewController list = new ToDoViewController();
			list.executeMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}