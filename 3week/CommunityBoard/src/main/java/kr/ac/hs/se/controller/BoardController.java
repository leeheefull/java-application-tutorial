package kr.ac.hs.se.controller;

import kr.ac.hs.se.model.User;
import kr.ac.hs.se.util.BoardConstants;
import kr.ac.hs.se.view.BoardView;

import java.io.*;

import static kr.ac.hs.se.model.Board.*;

public class BoardController {

    private final UserController userController = new UserController();
    private final PostController postController = new PostController();
    private final BoardView boardView = new BoardView();

    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            FileOutputStream fos = new FileOutputStream("error.log", true);
            PrintStream ps = new PrintStream(fos);
            System.setErr(ps);

            while (true) {
                boardView.showProgramTitle();
                User loginUser = userController.run(br);
                if (loginUser == null) {
                    boardView.showProgramEnd();
                    return;
                }
                while (true) {
                    String menu = inputMenu(br);
                    if (menu.equals(FREE_BOARD.getNo())) {
                        postController.run(br, FREE_BOARD, loginUser);
                    } else if (menu.equals(GAME_BOARD.getNo())) {
                        postController.run(br, GAME_BOARD, loginUser);
                    } else if (menu.equals(MARKET_BOARD.getNo())) {
                        postController.run(br, MARKET_BOARD, loginUser);
                    } else if (menu.equals(BoardConstants.LOGOUT)) {
                        boardView.showLogout();
                        break;
                    } else {
                        boardView.showNumberInputError();
                    }
                }
                ps.close();
                fos.close();
            }
        } catch (Exception e) {
            boardView.showError();
            boardView.logging(e);
        }
    }

    private String inputMenu(BufferedReader br) throws IOException {
        boardView.showMenu();
        return br.readLine();
    }
}
