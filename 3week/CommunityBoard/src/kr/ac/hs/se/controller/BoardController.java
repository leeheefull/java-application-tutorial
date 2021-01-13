package kr.ac.hs.se.controller;

import kr.ac.hs.se.board.BoardService;
import kr.ac.hs.se.login.LoginService;
import kr.ac.hs.se.login.SignUpService;
import kr.ac.hs.se.model.User;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static kr.ac.hs.se.util.BoardConstants.LoginMenu.*;

public class BoardController {

    private SignUpService signUpService;
    private LoginService loginService;
    private BoardService boardService;

    public BoardController() {
        this.signUpService = new SignUpService();
        this.loginService = new LoginService();
        this.boardService = new BoardService();
    }

    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("##### Community Board #####");
            System.out.println("## 1. Login / 2. sign up ##\n>> ");
            String menu = br.readLine();
            if (menu.equals(LOGIN)) {
                System.out.print("ID: ");
                String id = br.readLine();
                System.out.print("PW: ");
                String pw = br.readLine();
                loginService.login(id, pw);
            } else if (menu.equals(SIGNUP)) {
                System.out.print("name: ");
                String name = br.readLine();
                System.out.print("ID: ");
                String id = br.readLine();
                System.out.print("PW: ");
                String pw = br.readLine();
                signUpService.signUp(new User(id, name, pw));
            } else {
                System.out.println("##### Error #####");
            }

        } catch (Exception e) {
            System.out.println("##### Error #####");
            e.printStackTrace();
        }
    }
}
