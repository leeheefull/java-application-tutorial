package ac.hs.se.view;

import java.io.IOException;

public class Delete implements View {

	private void delete(int id) {
		for (int i = 0; i < toDoList.size(); i++) {
			if (toDoList.get(i).getId() == id) {
				toDoList.remove(i);
			}
		}
	}

	@Override
	public void show() {
		try {
			print.show();
			out.print("3. 삭제할 번호를 입력하시오.\n>> ");
			delete(Integer.parseInt(br.readLine()));
			print.lineBreak("");
		} catch (NumberFormatException | IOException e) {
			print.lineBreak("Error");
		}
	}
}