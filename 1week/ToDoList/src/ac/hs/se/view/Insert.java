package ac.hs.se.view;

import java.io.IOException;

import ac.hs.se.model.ToDo;

public class Insert implements View {

	private void insert(String content) {
		toDoList.add(new ToDo(content));
	}

	@Override
	public void show() {
		try {
			print.lineBreak("");
			out.print("1. 추가할 내용을 입력하시오.\n>> ");
			insert(br.readLine());
			print.lineBreak("");
		} catch (IOException e) {
			print.lineBreak("Error");
		}
	}
}