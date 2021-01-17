package kr.ac.hs.se.view;

public class UserView implements View {

    @Override
    public void showMenu() {
        out.println("################ 로그인 메뉴 ################");
        out.println("1. 로그인 하기");
        out.println("2. 회원가입 하기");
        out.println("3. 프로그램 종료하기");
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

    public void showFailedSignUp() {
        out.println(" -> 이미 가입된 정보가 있습니다.");
    }
}
