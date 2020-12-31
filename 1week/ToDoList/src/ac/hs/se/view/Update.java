package ac.hs.se.view;

import java.io.IOException;

public class Update implements View {

	private void update(int id) {
		for (int i = 0; i < toDoList.size(); i++) {
			if (toDoList.get(i).getStatus().equals("toDo") && toDoList.get(i).getId() == id) {
				toDoList.get(i).setStatus("doing");
			} else if (toDoList.get(i).getStatus().equals("doing") && toDoList.get(i).getId() == id) {
				toDoList.get(i).setStatus("done");
				return;
			}
		}
	}

	@Override
	public void show() {
		try {
			print.show();
			out.print("2. 수정할 번호를 입력하시오.\n>> ");
			update(Integer.parseInt(br.readLine()));
			print.lineBreak("");
		} catch (NumberFormatException | IOException e) {
			print.lineBreak("Error");
		}
	}
}