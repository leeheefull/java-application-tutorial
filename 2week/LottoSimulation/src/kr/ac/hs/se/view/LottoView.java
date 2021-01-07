package kr.ac.hs.se.view;

import java.io.PrintStream;

import kr.ac.hs.se.model.PurchasedLotto;
import kr.ac.hs.se.model.WinningLotto;

public class LottoView {
	
	PrintStream out = new PrintStream(System.out);

	public void showProgramTitle() {
		out.println("┌────────────────────────────────────────────────────┐");
		out.println("│                   Lotto Simulation                 │");
		out.println("└────────────────────────────────────────────────────┘");
	}

	public void showInput() {
		out.print("시뮬레이션 할 복권의 수를 입력하세요.\n>> ");
	}
	
	public void winningLineBreak() {
		out.println("───────────────────────당첨 번호────────────────────────");
	}
	
	public void purchasedLottoListLineBreak() {
		out.println("───────────────────시뮬레이션된 복권 번호───────────────────");
	}
	
	public void lineBreak() {
		out.println("──────────────────────────────────────────────────────");
	}

	public void showErrorMassage() {
		out.println("프로그램중 오류가 발생했습니다.");
	}

	public void showWinningLotto(WinningLotto winningLotto) {
		System.out.println(winningLotto);
	}
	
	public void showPurchasedLotto(PurchasedLotto purchasedLotto) {
		System.out.println(purchasedLotto);
	}
}