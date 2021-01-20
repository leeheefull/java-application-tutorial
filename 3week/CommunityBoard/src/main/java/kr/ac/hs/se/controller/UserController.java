package kr.ac.hs.se.controller;

import kr.ac.hs.se.exception.ExitException;
import kr.ac.hs.se.exception.LoginException;
import kr.ac.hs.se.model.User;
import kr.ac.hs.se.service.UserService;
import kr.ac.hs.se.menu.UserMenu;
import kr.ac.hs.se.view.UserView;

import java.io.BufferedReader;
import java.io.IOException;

public class UserController {

    private final UserService userService = new UserService();
    private final UserView userView = new UserView();

    public String run(BufferedReader br) throws IOException, LoginException, ExitException {
        while (true) {
            UserMenu menu = inputMenu(br);
            switch (menu) {
                case LOGIN:
                    User user = login(br);
                    userView.showLoginCompletion(user.getId());
                    return user.getId();
                case SIGNUP:
                    signUp(br);
                    break;
                case END_OF_PROGRAM:
                    throw new ExitException();
            }
        }
    }

    private User login(BufferedReader br) throws IOException, LoginException {
        userView.showUserMenuTitle(UserMenu.LOGIN.getTitle());
        String id = inputId(br);
        String pw = inputPw(br);

        return userService.login(id, pw);
    }

    private void signUp(BufferedReader br) throws IOException {
        userView.showUserMenuTitle(UserMenu.SIGNUP.getTitle());
        String name = inputName(br);
        String id = inputId(br);
        String pw = inputPw(br);

        if (userService.signUp(name, id, pw)) {
            userView.showSignUpCompletion(id);
            return;
        }
        userView.showFailedSignUp();
    }

    public UserMenu inputMenu(BufferedReader br) throws IOException {
        userView.showMenu();
        return UserMenu.of(br.readLine());
    }

    private String inputName(BufferedReader br) throws IOException {
        userView.showInput("이름");
        return br.readLine();
    }

    private String inputId(BufferedReader br) throws IOException {
        userView.showInput("아이디");
        return br.readLine();
    }

    private String inputPw(BufferedReader br) throws IOException {
        userView.showInput("비밀번호");
        return br.readLine();
    }
}
