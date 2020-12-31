package ac.hs.se.viewController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import ac.hs.se.model.ToDo;

public class ToDoViewController {
	private ArrayList<ToDo> toDoList;
	private int cnt = 1;

	public ToDoViewController() {
		this.toDoList = new ArrayList<ToDo>();
		this.init();
	}

	public void init() {
		toDoList.add(new ToDo(cnt++, "2020-12-20", "자바 공부하기"));
		toDoList.add(new ToDo(cnt++, "2020-12-22", "스프링 공부하기"));
		toDoList.add(new ToDo(cnt++, "2020-12-24", "디비 공부하기"));
		toDoList.add(new ToDo(cnt++, "2020-12-26", "알고리즘 문제풀기"));
	}

	public void printMenu() {
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

	public void executeMenu() {
		boolean keepLoop = true;
		while (keepLoop) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				this.printMenu();
				int menu;
				menu = Integer.parseInt(br.readLine());
				switch (menu) {
				case 1:
					this.add();
					break;
				case 2:
					this.update();
					break;
				case 3:
					this.delete();
					break;
				case 4:
					this.print();
					break;
				case 5:
					System.out.println("────────────────────END────────────────────");
					keepLoop = false;
					break;
				default:
					System.out.println("────────────────────오류────────────────────");
				}
			} catch (NumberFormatException | IOException e) {
				System.out.println("────────────────────오류────────────────────");
			}
		}
	}

	private void add(String content) {
		toDoList.add(new ToDo(cnt++, content));
	}

	public void add() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("\n───────────────────────────────────────────");
			System.out.print("1. 추가할 내용을 입력하시오.\n>> ");
			this.add(br.readLine());
			System.out.println("───────────────────────────────────────────");
		} catch (IOException e) {
			System.out.println("────────────────────오류────────────────────");
		}
	}

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

	public void update() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			this.print();
			System.out.print("2. 수정할 번호를 입력하시오.\n>> ");
			this.update(Integer.parseInt(br.readLine()));
			System.out.println("───────────────────────────────────────────");
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("────────────────────오류────────────────────");
		}
	}

	private void delete(int id) {
		for (int i = 0; i < toDoList.size(); i++) {
			if (toDoList.get(i).getId() == id) {
				toDoList.remove(i);
			}
		}
	}

	public void delete() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			this.print();
			System.out.print("3. 삭제할 번호를 입력하시오.\n>> ");
			this.delete(Integer.parseInt(br.readLine()));
			System.out.println("───────────────────────────────────────────");
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("────────────────────오류────────────────────");
		}
	}

	public void print() {

		System.out.println("\n───────────────────────────────────────────");
		System.out.println("\t\tToDo");
		System.out.println("번호\t날짜\t\t할 일");
		for (int i = 0; i < toDoList.size(); i++) {
			if (toDoList.get(i).getStatus().equals("toDo")) {
				System.out.println(toDoList.get(i));
			}
		}
		System.out.println("───────────────────────────────────────────");
		System.out.println("\t\tDoing");
		System.out.println("번호\t날짜\t\t할 일");
		for (int i = 0; i < toDoList.size(); i++) {
			if (toDoList.get(i).getStatus().equals("doing")) {
				System.out.println(toDoList.get(i));
			}
		}
		System.out.println("───────────────────────────────────────────");
		System.out.println("\t\tDone");
		System.out.println("번호\t날짜\t\t할 일");
		for (int i = 0; i < toDoList.size(); i++) {
			if (toDoList.get(i).getStatus().equals("done")) {
				System.out.println(toDoList.get(i));
			}
		}
		System.out.println("───────────────────────────────────────────");
	}
}