package kr.ac.hs.se.controller;

import kr.ac.hs.se.model.User;
import kr.ac.hs.se.util.BoardConstants;
import kr.ac.hs.se.view.BoardView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static kr.ac.hs.se.model.Board.*;

public class BoardController {

    private final UserController userController = new UserController();
    private final PostController postController = new PostController();
    private final BoardView boardView = new BoardView();

    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                boardView.showProgramTitle();
                User user = userController.run(br);
                if (user == null) {
                    boardView.showProgramEnd();
                    return;
                }
                while (true) {
                    boardView.showMenu();
                    String menu = inputMenu(br);
                    if (menu.equals(FREE_BOARD.getNo())) {
                        postController.run(br, FREE_BOARD, user);
                    } else if (menu.equals(GAME_BOARD.getNo())) {
                        postController.run(br, GAME_BOARD, user);
                    } else if (menu.equals(MARKET_BOARD.getNo())) {
                        postController.run(br, MARKET_BOARD, user);
                    } else if (menu.equals(BoardConstants.LOGOUT)) {
                        boardView.lineBreak();
                        boardView.showLogout();
                        break;
                    } else {
                        boardView.showNumberInputError();
                    }
                }
            }
        } catch (Exception e) {
            boardView.showError();
            e.printStackTrace();
        }
    }

    private String inputMenu(BufferedReader br) throws IOException {
        return br.readLine();
    }
}
