package kr.ac.hs.se.controller;

import kr.ac.hs.se.exception.LoggingAnException;
import kr.ac.hs.se.util.BoardConstants;
import kr.ac.hs.se.view.BoardView;

import java.io.*;

import static kr.ac.hs.se.model.Board.*;

public class BoardController implements Controller {

    private final UserController userController = new UserController();
    private final PostController postController = new PostController();
    private final BoardView boardView = new BoardView();

    public void run() {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                PrintStream log = new PrintStream(new FileOutputStream("error.log", true))
        ) {
            System.setErr(log);
            while (true) {
                boardView.showProgramTitle();
                String loginUserId = userController.run(br);
                if (loginUserId == null) {
                    boardView.showProgramEnd();
                    return;
                }
                while (true) {
                    String menu = inputMenu(br);
                    if (menu.equals(ALL_POST_BOARD.getNo())) {
                        postController.run(br, ALL_POST_BOARD, loginUserId);
                    } else if (menu.equals(FREE_BOARD.getNo())) {
                        postController.run(br, FREE_BOARD, loginUserId);
                    } else if (menu.equals(GAME_BOARD.getNo())) {
                        postController.run(br, GAME_BOARD, loginUserId);
                    } else if (menu.equals(MARKET_BOARD.getNo())) {
                        postController.run(br, MARKET_BOARD, loginUserId);
                    } else if (menu.equals(BoardConstants.LOGOUT)) {
                        boardView.showLogout();
                        break;
                    } else {
                        boardView.showNumberInputError();
                    }
                }
            }
        } catch (Exception e) {
            boardView.showError();
            LoggingAnException.logging(e);
        }
    }

    @Override
    public String inputMenu(BufferedReader br) throws IOException {
        boardView.showMenu();
        return br.readLine();
    }
}
