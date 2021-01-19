package kr.ac.hs.se.view;

import kr.ac.hs.se.util.Board;

public class BoardView implements View {

    @Override
    public void showMenu() {
        out.println("################ 게시판 선택 ################");
        Board.selectMenuByName()
                .forEach(out::println);
        out.print("입력할 번호 >> ");
    }

    public void showProgramTitle() {
        out.println("############# Community Board #############");
    }

    public void showError() {
        out.println(" -> 프로그램이 종료되었습니다.");
    }

    public void showLogout() {
        out.println(" -> 로그아웃 되었습니다.");
    }
}
