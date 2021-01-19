package kr.ac.hs.se.view;

import kr.ac.hs.se.util.UserMenu;

public class UserView implements View {

    @Override
    public void showMenu() {
        out.println("################ 로그인 메뉴 ################");
        UserMenu.selectMenuByName()
                .forEach(out::println);
        out.print("입력할 번호 >> ");
    }

    public void showUserMenuTitle(String title) {
        out.println(title);
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

    public void showFailedSignUp() {
        out.println(" -> 이미 가입된 정보가 있습니다.");
    }
}
