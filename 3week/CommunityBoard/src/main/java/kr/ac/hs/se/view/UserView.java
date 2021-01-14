package kr.ac.hs.se.view;

import java.io.PrintStream;

public class UserView {

    private final PrintStream out = new PrintStream(System.out);

    public void showMenu() {
        out.println("################ 로그인 메뉴 ################");
        out.println("##### 1. 로그인 / 2. 회원가입 / 3. 종료 ######");
        out.print("입력할 번호 >> ");
    }

    public void showPageName(String pageName) {
        out.println("############### " + pageName + " 페이지 ################");
    }

    public void showInput(String input) {
        out.print(input + " >> ");
    }

    public void showLoginCompletion(String idToLogin) {
        out.println("-> " + idToLogin + "님이 로그인 하셨습니다.");
    }

    public void showSignUpCompletion(String idToSignUp) {
        out.println("-> " + idToSignUp + "님 환영합니다.");
    }

    public void showNumberInputError() {
        out.println("-> 번호를 다시 입력하세요.");
    }

    public void showFailedLogin() {
        out.println(" -> 회원가입이 필요합니다.");
    }
}
