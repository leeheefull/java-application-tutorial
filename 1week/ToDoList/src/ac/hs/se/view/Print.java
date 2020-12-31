package ac.hs.se.view;

public class Print implements View {

	@Override
	public void show() {
		print.lineBreak("");
		out.println("\t\tToDo");
		out.println("번호\t날짜\t\t할 일");
		for (int i = 0; i < toDoList.size(); i++) {
			if (toDoList.get(i).getStatus().equals("toDo")) {
				out.println(toDoList.get(i));
			}
		}
		print.lineBreak("");
		out.println("\t\tDoing");
		out.println("번호\t날짜\t\t할 일");
		for (int i = 0; i < toDoList.size(); i++) {
			if (toDoList.get(i).getStatus().equals("doing")) {
				out.println(toDoList.get(i));
			}
		}
		print.lineBreak("");
		out.println("\t\tDone");
		out.println("번호\t날짜\t\t할 일");
		for (int i = 0; i < toDoList.size(); i++) {
			if (toDoList.get(i).getStatus().equals("done")) {
				out.println(toDoList.get(i));
			}
		}
		print.lineBreak("");
	}
	
	public void lineBreak(String output) {
		out.println("────────────────────" + output + "────────────────────");
	}
}