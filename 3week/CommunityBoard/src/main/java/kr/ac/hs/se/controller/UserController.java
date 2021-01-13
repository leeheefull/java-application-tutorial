package kr.ac.hs.se.controller;

import kr.ac.hs.se.model.User;
import kr.ac.hs.se.service.UserService;
import kr.ac.hs.se.view.UserView;

import java.io.BufferedReader;
import java.io.IOException;

import static kr.ac.hs.se.util.BoardConstants.UserMenu.*;

public class UserController {

    private final UserService userService = new UserService();
    private final UserView userView = new UserView();

    public User run(BufferedReader br) throws IOException {
        while (true) {
            userView.showMenu();
            String menu = inputMenu(br);
            switch (menu) {
                case LOGIN:
                    userView.showPageName("로그인");

                    userView.showInput("아이디");
                    String idToLogin = inputId(br);

                    userView.showInput("비밀번호");
                    String pwToLogin = inputPw(br);

                    User userToLogin = userService.login(idToLogin, pwToLogin);

                    if (userToLogin != null) {
                        userView.showLoginCompletion(userToLogin.getId());
                        return userToLogin;
                    } else {
                        userView.showFailedLogin();
                    }
                    break;
                case SIGNUP:
                    userView.showPageName("회원가입");

                    userView.showInput("이름");
                    String name = br.readLine();

                    userView.showInput("아이디");
                    String idToSignUp = br.readLine();

                    userView.showInput("비밀번호");
                    String pwToSignUp = br.readLine();

                    userService.signUp(new User(name, idToSignUp, pwToSignUp));
                    userView.showSignUpCompletion(idToSignUp);
                    break;
                case END_OF_PROGRAM:
                    return null;
                default:
                    userView.showNumberInputError();
                    break;
            }
        }
    }

    private String inputMenu(BufferedReader br) throws IOException {
        return br.readLine();
    }

    private String inputId(BufferedReader br) throws IOException {
        return br.readLine();
    }

    private String inputPw(BufferedReader br) throws IOException {
        return br.readLine();
    }
}
