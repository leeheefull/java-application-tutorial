package kr.ac.hs.se.view;

import kr.ac.hs.se.util.Board;

public class BoardView implements View {

    @Override
    public void showMenu() {
        out.println("################ 게시판 선택 ################");
        out.println(Board.ALL_POST.getNo() + ". " + Board.ALL_POST.getName());
        out.println(Board.MY_POST.getNo() + ". " + Board.MY_POST.getName());
        out.println(Board.FREE_BOARD.getNo() + ". " + Board.FREE_BOARD.getName());
        out.println(Board.GAME_BOARD.getNo() + ". " + Board.GAME_BOARD.getName());
        out.println(Board.MARKET_BOARD.getNo() + ". " + Board.MARKET_BOARD.getName());
        out.println(Board.LOGOUT.getNo() + ". " + Board.LOGOUT.getName());
        out.print("입력할 번호 >> ");
    }

    public void showProgramTitle() {
        out.println("############# Community Board #############");
    }

    public void showError() {
        out.println(" -> 프로그램이 종료되었습니다.");
    }

    public void showNumberInputError() {
        out.println("-> 번호를 다시 입력하세요.");
    }

    public void showLogout() {
        out.println(" -> 로그아웃 되었습니다.");
    }
}
