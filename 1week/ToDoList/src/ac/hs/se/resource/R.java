package ac.hs.se.resource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

import ac.hs.se.view.Delete;
import ac.hs.se.view.Insert;
import ac.hs.se.view.Menu;
import ac.hs.se.view.Print;
import ac.hs.se.view.Update;
import ac.hs.se.controller.ToDoController;
import ac.hs.se.model.ToDo;

public interface R {

	// Stream
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintStream out = System.out;

	// Model
	ArrayList<ToDo> toDoList = new ArrayList<ToDo>();

	// Controller
	ToDoController toDoController = new ToDoController();

	// View
	Menu menu = new Menu();
	Insert insert = new Insert();
	Update update = new Update();
	Delete delete = new Delete();
	Print print = new Print();
}
