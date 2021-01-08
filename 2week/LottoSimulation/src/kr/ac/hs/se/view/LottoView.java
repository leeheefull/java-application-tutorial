package kr.ac.hs.se.view;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;

import kr.ac.hs.se.model.Lotto;
import kr.ac.hs.se.model.PurchasedLotto;

public class LottoView {

    private final PrintStream out = new PrintStream(System.out);

    public void showProgramTitle() {
        out.println("┌────────────────────────────────┐");
        out.println("│        Lotto Simulation        │");
        out.println("└────────────────────────────────┘");
    }

    public void showMenu() {
        out.print("1. 시뮬레이션 시작\t  2. 시뮬레이션 종료\n>> ");
    }

    public void inputNumberOfLotto() {
        out.print("시뮬레이션 할 복권의 수를 입력하세요.\n>> ");
    }

    public void winningLineBreak() {
        out.println("────────────당첨 번호──────────────");
    }

    public void purchasedLottoListLineBreak() {
        out.println("───────시뮬레이션된 복권 번호────────");
    }

    public void lineBreak() {
        out.println("──────────────────────────────────");
    }

    public void showErrorMassage() {
        out.println("프로그램중 오류가 발생했습니다.");
    }

    public <T extends Lotto> void showWinningLotto(T lotto) {
        out.println(lotto);
    }

    public void showPurchasedLottoList(List<PurchasedLotto> purchasedLottoList) {
        purchasedLottoList.forEach(out::println);
    }
}