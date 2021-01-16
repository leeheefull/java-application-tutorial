package kr.ac.hs.se.view;

import kr.ac.hs.se.model.Post;

import java.util.List;

public class PostView implements View {

    @Override
    public void showMenu() {
        out.println("## 1. 작성 / 2. 수정 / 3. 삭제 / 4. 뒤로가기 ##");
        out.print("입력할 번호 >> ");
    }

    public void showBoardTitle(String title) {
        out.println(title);
    }

    public void showTableAttribute() {
        out.println("번호\t\t작성한 날짜\t작성자\t글 제목\t내용");
    }

    public void lineBreak() {
        out.println("###########################################");
    }

    public void showPageName(String pageName) {
        out.println("############### 글 " + pageName + " 페이지 ###############");
    }

    public void showInput(String input) {
        out.print(input + " >> ");
    }

    public void showNumberInputError() {
        out.println(" -> 번호를 다시 입력하세요.");
    }

    public void showEnd() {
        out.println(" -> 글 관리가 끝났습니다.");
    }

    public void showBoardTable(List<Post> selectPostsByBoard) {
        selectPostsByBoard.forEach(out::print);
    }
}
