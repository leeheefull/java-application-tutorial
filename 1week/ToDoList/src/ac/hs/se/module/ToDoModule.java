package ac.hs.se.module;

import java.util.ArrayList;
import java.util.List;

import ac.hs.se.model.ToDo;
import ac.hs.se.model.ToDoStatus;

public class ToDoModule {

	private List<ToDo> toDoList = new ArrayList<>();
	private int id = 0;

	public void init() {
		toDoList.add(new ToDo(id++, "2020-12-20", "자바 공부하기"));
		toDoList.add(new ToDo(id++, "2020-12-22", "스프링 공부하기"));
		toDoList.add(new ToDo(id++, "2020-12-24", "디비 공부하기"));
		toDoList.add(new ToDo(id++, "2020-12-26", "알고리즘 문제풀기"));
	}

	public void insertToDo(String content) {
		toDoList.add(new ToDo(id++, content));
	}

	public void changeStatus(int id) {
		for (ToDo toDo : this.toDoList) {
			if (toDo.getStatus().equals(ToDoStatus.TODO) && toDo.getId() == id) {
				toDo.setStatus(ToDoStatus.DOING);
				return;
			} else if (toDo.getStatus().equals(ToDoStatus.DOING) && toDo.getId() == id) {
				toDo.setStatus(ToDoStatus.DONE);
				return;
			}
		}
	}

	public void deleteToDo(int id) {
		for (int i = 0; i < toDoList.size(); i++) {
			if (toDoList.get(i).getId() == id) {
				toDoList.remove(i);
			}
		}
	}

	public List<ToDo> selectToDoList(ToDoStatus status) {
		List<ToDo> list = new ArrayList<>();
		for (ToDo toDo : this.toDoList) {
			if (toDo.getStatus().equals(status)) {
				list.add(toDo);
			}
		}
		return list;
	}
}