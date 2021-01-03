package ac.hs.se.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ac.hs.se.module.ToDoModule;
import ac.hs.se.util.ToDoConstants.Menu;
import ac.hs.se.util.ToDoConstants.Status;
import ac.hs.se.view.ToDoView;

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
				case Menu.INSERT:
					insertToDo(br);
					break;
				case Menu.UPDATE:
					updateToDo(br);
					break;
				case Menu.DELETE:
					deleteToDo(br);
					break;
				case Menu.SHOW:
					showList();
					break;
				case Menu.EXIT:
					view.showMessage("END");
					return;
				}
			}
		} catch (Exception e) {
			view.showMessage("ERROR");
		}
	}

	private void insertToDo(BufferedReader br) throws IOException {
		view.lineBreak();
		view.showInput(Menu.INSERT);
		String content = br.readLine();
		service.insertToDo(content);
		view.lineBreak();
	}

	private void updateToDo(BufferedReader br) throws NumberFormatException, IOException {
		showList();
		view.showInput(Menu.UPDATE);
		int id = Integer.parseInt(br.readLine());
		service.changeStatus(id);
		view.lineBreak();
	}

	private void deleteToDo(BufferedReader br) throws NumberFormatException, IOException {
		showList();
		view.showInput(Menu.DELETE);
		int id = Integer.parseInt(br.readLine());
		service.selectToDo(id);
		view.lineBreak();
	}

	private void showList() {
		view.lineBreak();
		view.showAttribute(Status.TODO);
		view.showToDoList(service.selectToDoList(Status.TODO));

		view.lineBreak();
		view.showAttribute(Status.DOING);
		view.showToDoList(service.selectToDoList(Status.DOING));

		view.lineBreak();
		view.showAttribute(Status.DONE);
		view.showToDoList(service.selectToDoList(Status.DONE));
		view.lineBreak();
	}
}