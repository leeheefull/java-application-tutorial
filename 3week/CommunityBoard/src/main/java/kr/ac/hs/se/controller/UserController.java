package kr.ac.hs.se.controller;

import kr.ac.hs.se.model.User;
import kr.ac.hs.se.service.UserService;

import java.io.BufferedReader;
import java.io.IOException;

import static kr.ac.hs.se.util.BoardConstants.UserMenu.*;

public class UserController {

    private final UserService userService = new UserService();

    public User run(BufferedReader br) throws IOException {
        while (true) {
            System.out.println("################ 로그인 메뉴 ################");
            System.out.println("##### 1. 로그인 / 2. 회원가입 / 3. 종료 ######");
            System.out.print("입력할 번호 >> ");
            String menu = br.readLine();
            switch (menu) {
                case LOGIN:
                    System.out.println("############### 로그인 페이지 ################");
                    System.out.print("아이디 >> ");
                    String IdToLogin = br.readLine();
                    System.out.print("비밀번호 >> ");
                    String pwToLogin = br.readLine();
                    System.out.println("-> " + IdToLogin + "님이 로그인하셨습니다.");
                    return userService.login(IdToLogin, pwToLogin);
                case SIGNUP:
                    System.out.println("############## 회원가입 페이지 ##############");
                    System.out.print("이름 >> ");
                    String name = br.readLine();
                    System.out.print("아이디 >> ");
                    String idToSignUp = br.readLine();
                    System.out.print("비밀번호 >> ");
                    String pwToSignUp = br.readLine();
                    userService.signUp(new User(name, idToSignUp, pwToSignUp));
                    System.out.println("-> " + idToSignUp + "님 환영합니다.");
                    break;
                case END:
                    return null;
                default:
                    System.out.println("-> 번호를 다시 입력하세요.");
                    break;
            }
        }
    }
}
