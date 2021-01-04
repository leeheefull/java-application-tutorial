package ac.hs.se.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ac.hs.se.model.ToDoStatus;
import ac.hs.se.module.ToDoModule;
import ac.hs.se.view.ToDoView;

import static ac.hs.se.util.ToDoConstants.Menu.*;

public class ToDoController {

	private ToDoModule service;
	private ToDoView view;

	public ToDoController() {
		this.service = new ToDoModule();
		this.view = new ToDoView();
		this.service.init();
	}

	public void run() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			while (true) {
				view.showMenu();
				String menu = br.readLine();
				switch (menu) {
				case INSERT:
					insertToDo(br);
					break;
				case UPDATE:
					updateToDo(br);
					break;
				case DELETE:
					deleteToDo(br);
					break;
				case SHOW:
					showList();
					break;
				case EXIT:
					view.showMessage("END");
					return;
				}
			}
		} catch (Exception e) {
			view.showMessage("ERROR");
			e.printStackTrace();
		}
	}

	private void insertToDo(BufferedReader br) throws IOException {
		view.lineBreak();
		view.showInput(INSERT);
		String content = br.readLine();
		service.insertToDo(content);
		view.lineBreak();
	}

	private void updateToDo(BufferedReader br) throws NumberFormatException, IOException {
		showList();
		view.showInput(UPDATE);
		int id = Integer.parseInt(br.readLine());
		service.changeStatus(id);
		view.lineBreak();
	}

	private void deleteToDo(BufferedReader br) throws NumberFormatException, IOException {
		showList();
		view.showInput(DELETE);
		int id = Integer.parseInt(br.readLine());
		service.deleteToDo(id);
		view.lineBreak();
	}

	private void showList() {
		view.lineBreak();
		view.showAttribute(ToDoStatus.TODO);
		view.showToDoList(service.selectToDoList(ToDoStatus.TODO));

		view.lineBreak();
		view.showAttribute(ToDoStatus.DOING);
		view.showToDoList(service.selectToDoList(ToDoStatus.DOING));

		view.lineBreak();
		view.showAttribute(ToDoStatus.DONE);
		view.showToDoList(service.selectToDoList(ToDoStatus.DONE));
		view.lineBreak();
	}
}