import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class List {

	private ArrayList<ToDo> toDoList;
	private ArrayList<ToDo> doingList;
	private ArrayList<ToDo> doneList;

	public List() {
		this.toDoList = new ArrayList<ToDo>();
		this.doingList = new ArrayList<ToDo>();
		this.doneList = new ArrayList<ToDo>();
	}

	public void init() {
		toDoList.add(new ToDo("2020-12-20", "자바 공부하기"));
		toDoList.add(new ToDo("2020-12-22", "스프링 공부하기"));
		toDoList.add(new ToDo("2020-12-24", "디비 공부하기"));
		toDoList.add(new ToDo("2020-12-26", "알고리즘 문제풀기"));
	}

	public int menuInput() throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\n\n");
		System.out.println("┌───────────────────────────────┐");
		System.out.println("│              Menu             │");
		System.out.println("└───────────────────────────────┘");
		System.out.println(" > 1. 할 일 추가");
		System.out.println(" > 2. 할 일 수정");
		System.out.println(" > 3. 할 일 삭제");
		System.out.println(" > 4. 할 일 조회");
		System.out.println(" > 5. 끝내기");
		System.out.print(" >> ");
		return Integer.parseInt(br.readLine());
	}

	private void add(String content) {
		toDoList.add(new ToDo(content));
	}

	public void add() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\n─────────────────────────────────");
		System.out.print(" 추가할 내용 > ");
		this.add(br.readLine());
		System.out.println("─────────────────────────────────");
	}

	private void update(String content) {

		for (ToDo item : doingList) {
			if (item.getContent().equals(content)) {
				doingList.remove(item);
				doneList.add(item);
				System.out.println(" ** \"" + content + "\" 다 했습니다!");
				return;
			}
		}
		for (ToDo item : toDoList) {
			if (item.getContent().equals(content)) {
				toDoList.remove(item);
				doingList.add(item);
				System.out.println(" ** \"" + content + "\"하는 중입니다!");
				return;
			}
		}
	}

	public void update() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\n─────────────────────────────────");
		System.out.print(" 수정할 내용 > ");
		this.update(br.readLine());
		System.out.println("─────────────────────────────────");
	}

	private void delete(String content) {

		for (ToDo item : doneList) {
			if (item.getContent().equals(content)) {
				doneList.remove(item);
				System.out.println(" ** \"" + content + "\" 삭제했습니다!");
				return;
			}
		}
		for (ToDo item : doingList) {
			if (item.getContent().equals(content)) {
				doingList.remove(item);
				System.out.println(" ** \"" + content + "\" delete!");
				return;
			}
		}
		for (ToDo item : toDoList) {
			if (item.getContent().equals(content)) {
				toDoList.remove(item);
				System.out.println(" ** \"" + content + "\" delete!");
				return;
			}
		}
	}

	public void delete() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("\n─────────────────────────────────");
		System.out.print(" 삭제할 내용 > ");
		this.delete(br.readLine());
		System.out.println("─────────────────────────────────");
	}

	public void print() {

		System.out.println("\n─────────────────────────────────");
		System.out.println(" ** ToDo **");
		for (ToDo item : toDoList) {
			System.out.println(" ** " + item);
		}
		System.out.println("─────────────────────────────────");
		System.out.println(" ** Doing **");
		for (ToDo item : doingList)
			System.out.println(" ** " + item);
		System.out.println("─────────────────────────────────");
		System.out.println(" ** Done **");
		for (ToDo item : doneList)
			System.out.println(" ** " + item);
		System.out.println("─────────────────────────────────");
	}
}
