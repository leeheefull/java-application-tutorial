package kr.ac.hs.se.controller;

import kr.ac.hs.se.model.Board;
import kr.ac.hs.se.model.User;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BoardController {

    private final UserController userController = new UserController();
    private final PostController postController = new PostController();

    public BoardController() {
    }

    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("############# Community Board #############");
                User user = userController.run(br);
                if (user == null) {
                    System.out.println("############## 프로그램 종료 ################");
                    return;
                }
                System.out.println("################ 게시판 선택 ################");
                System.out.println("1. " + Board.FREE_BOARD.getName());
                System.out.println("2. " + Board.GAME_BOARD.getName());
                System.out.println("3. " + Board.MARKET_BOARD.getName());
                System.out.print("입력할 번호 >> ");
                String menu = br.readLine();
                Board boardToSelect = null;
                if (menu.equals(Board.FREE_BOARD.getNo())) {
                    boardToSelect = Board.FREE_BOARD;
                } else if (menu.equals(Board.GAME_BOARD.getNo())) {
                    boardToSelect = Board.GAME_BOARD;
                } else if (menu.equals(Board.MARKET_BOARD.getNo())) {
                    boardToSelect = Board.MARKET_BOARD;
                } else {
                    System.out.println("############# 잘못 누르셨습니다. #############");
                } // 메소드로 빼고 리턴으로 받기 (while 문)
                assert boardToSelect != null;
                postController.run(br, boardToSelect, user);
            }
        } catch (Exception e) {
            System.out.println("################# 오류 발생 #################");
            e.printStackTrace();
        }
    }
}
