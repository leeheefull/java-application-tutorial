package ac.hs.se.main;

import java.io.IOException;

import ac.hs.se.controller.ToDoController;

public class ToDoConsole {

	public static void main(String[] args) throws IOException {
		new ToDoController().run();
	}
}