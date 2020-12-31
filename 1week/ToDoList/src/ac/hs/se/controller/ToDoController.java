package ac.hs.se.controller;

import java.io.IOException;

import ac.hs.se.resource.R;

public class ToDoController implements R {

	public void process() {
		boolean keepLoop = true;
		while (keepLoop) {
			try {
				menu.show();
				int menu;
				menu = Integer.parseInt(br.readLine());
				switch (menu) {
				case 1:
					insert.show();
					break;
				case 2:
					update.show();
					break;
				case 3:
					delete.show();
					break;
				case 4:
					print.show();
					break;
				case 5:
					print.lineBreak("END");
					keepLoop = false;
					break;
				default:
					print.lineBreak("Error");
				}
			} catch (NumberFormatException | IOException e) {
				print.lineBreak("Error");
			}
		}
	}
}