package kr.ac.hs.se.view;

public class LottoView {

	public void showProgramTitle() {
		System.out.println("┌────────────────────────────────────────────────────┐");
		System.out.println("│                   Lotto Simulation                 │");
		System.out.println("└────────────────────────────────────────────────────┘");
	}

	public void showInput() {
		System.out.print("시뮬레이션 할 복권의 수를 입력하세요.\n>> ");
	}

	public void showLottoList(Object o) {
		System.out.println(o);
	}

	public void showErrorMassage() {
		System.out.println("프로그램중 오류가 발생했습니다.");
	}
}