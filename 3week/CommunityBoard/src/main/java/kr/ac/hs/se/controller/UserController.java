package kr.ac.hs.se.controller;

import kr.ac.hs.se.exception.LoginException;
import kr.ac.hs.se.model.User;
import kr.ac.hs.se.service.UserService;
import kr.ac.hs.se.view.UserView;

import java.io.BufferedReader;
import java.io.IOException;

import static kr.ac.hs.se.util.BoardConstants.UserMenu.*;

public class UserController implements Controller {

    private final UserService userService = new UserService();
    private final UserView userView = new UserView();

    public String run(BufferedReader br) throws IOException, LoginException {
        while (true) {
            String menu = inputMenu(br);
            switch (menu) {
                case LOGIN:
                    User userToLogin = login(br);
                    userView.showLoginCompletion(userToLogin.getId());
                    return userToLogin.getId();
                case SIGNUP:
                    signUp(br);
                    break;
                case END_OF_PROGRAM:
                    return null;
                default:
                    userView.showNumberInputError();
            }
        }
    }

    private User login(BufferedReader br) throws IOException, LoginException {
        userView.showPageName("로그인");
        String id = inputId(br);
        String pw = inputPw(br);

        return userService.login(id, pw);
    }

    private void signUp(BufferedReader br) throws IOException {
        userView.showPageName("회원가입");
        String name = inputName(br);
        String id = inputId(br);
        String pw = inputPw(br);

        if (userService.signUp(new User(name, id, pw))) {
            userView.showSignUpCompletion(id);
        } else {
            userView.showFailedSignUp();
        }
    }

    @Override
    public String inputMenu(BufferedReader br) throws IOException {
        userView.showMenu();
        return br.readLine();
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
