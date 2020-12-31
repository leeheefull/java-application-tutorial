package ac.hs.se.view;

public class Menu implements View {

	@Override
	public void show() {
		out.print("\n\n");
		out.println("┌─────────────────────────────────────────┐");
		out.println("│                   Menu                  │");
		out.println("└─────────────────────────────────────────┘");
		out.println("1. 할 일 추가");
		out.println("2. 할 일 수정");
		out.println("3. 할 일 삭제");
		out.println("4. 할 일 조회");
		out.println("5. 끝내기");
		out.print(">> ");
	}
}