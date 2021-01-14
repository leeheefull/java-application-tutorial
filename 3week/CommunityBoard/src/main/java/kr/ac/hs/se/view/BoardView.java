package kr.ac.hs.se.view;

import kr.ac.hs.se.model.Board;

import java.io.PrintStream;
import java.util.Date;

public class BoardView {

    private final PrintStream out = new PrintStream(System.out);

    public void showProgramTitle() {
        out.println("############# Community Board #############");
    }

    public void showMenu() {
        out.println("################ 게시판 선택 ################");
        out.println("####### " + Board.FREE_BOARD.getNo() + ". " + Board.FREE_BOARD.getName() + " / "
                + Board.GAME_BOARD.getNo() + ". " + Board.GAME_BOARD.getName() + " #######" + "\n"
                + "######## " + Board.MARKET_BOARD.getNo() + ". " + Board.MARKET_BOARD.getName() + " / "
                + "4. 로그아웃 #########");
        out.print("입력할 번호 >> ");
    }

    public void showProgramEnd() {
        out.println("############## 프로그램 종료 ################");
    }

    public void showError() {
        out.println("################# 오류 발생 #################");
    }

    public void showNumberInputError() {
        out.println("-> 번호를 다시 입력하세요.");
    }

    public void showLogout() {
        out.println("###########################################\n -> 로그아웃 되었습니다.");
    }

    public void logging(Exception e) {
        System.err.println("---------------------------------------------------------------------------------------------------------");
        System.err.println("예외발생시간: " + new Date());
        e.printStackTrace(System.err);
        System.err.println("예외 메세지: " + e.getMessage());
        System.err.println("---------------------------------------------------------------------------------------------------------");
    }
}
