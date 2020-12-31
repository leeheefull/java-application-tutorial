package ac.hs.se.main;

import ac.hs.se.model.ToDo;
import ac.hs.se.resource.R;

public class ToDoConsole implements R {

	public static void main(String[] args) {
		try {
			listInit();
			toDoController.process();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void listInit() {
		toDoList.add(new ToDo("2020-12-20", "자바 공부하기"));
		toDoList.add(new ToDo("2020-12-22", "스프링 공부하기"));
		toDoList.add(new ToDo("2020-12-24", "디비 공부하기"));
		toDoList.add(new ToDo("2020-12-26", "알고리즘 문제풀기"));
	}
}