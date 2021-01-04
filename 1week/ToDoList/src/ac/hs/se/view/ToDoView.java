package ac.hs.se.view;

import java.util.List;

import ac.hs.se.model.ToDo;
import ac.hs.se.model.ToDoStatus;
import ac.hs.se.util.ToDoConstants.Menu;

public class ToDoView {

	public void showMenu() {
		System.out.print("\n\n");
		System.out.println("┌─────────────────────────────────────────┐");
		System.out.println("│                   Menu                  │");
		System.out.println("└─────────────────────────────────────────┘");
		System.out.println("1. 할 일 추가");
		System.out.println("2. 할 일 수정");
		System.out.println("3. 할 일 삭제");
		System.out.println("4. 할 일 조회");
		System.out.println("5. 끝내기");
		System.out.print(">> ");
	}

	public void showInput(String menu) {
		switch (menu) {
		case Menu.INSERT:
			System.out.print("1. 추가할 내용을 입력하시오.\n>> ");
			break;
		case Menu.UPDATE:
			System.out.print("2. 수정할 번호을 입력하시오.\n>> ");
			break;
		case Menu.DELETE:
			System.out.print("3. 삭제할 번호을 입력하시오.\n>> ");
			break;
		}
	}

	public void showAttribute(ToDoStatus todo) {
		System.out.println(todo);
		System.out.println("번호\t날짜\t\t할 일");
	}

	public void showToDoList(List<ToDo> list) {
		list.forEach(System.out::println);
	}

	public void lineBreak() {
		System.out.println("────────────────────────────────────────");
	}

	public void showMessage(String message) {
		System.out.println("───────────────────" + message + "──────────────────");
	}
}
