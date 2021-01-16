package kr.ac.hs.se.view;

import kr.ac.hs.se.model.Board;

public class BoardView implements View {

    @Override
    public void showMenu() {
        out.println("################ 게시판 선택 ################");
        out.println("####### " + Board.ALL_POST_BOARD.getNo() + ". " + Board.ALL_POST_BOARD.getName() + " / "
                + Board.FREE_BOARD.getNo() + ". " + Board.FREE_BOARD.getName() + " #######" + "\n"
                + "####### " + Board.GAME_BOARD.getNo() + ". " + Board.GAME_BOARD.getName() + " / "
                + Board.MARKET_BOARD.getNo() + ". " + Board.MARKET_BOARD.getName() + " #######" + "\n"
                + "################ 5. 로그아웃 ################");
        out.print("입력할 번호 >> ");
    }

    public void showProgramTitle() {
        out.println("############# Community Board #############");
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
}
