package kr.ac.hs.se.controller;

import kr.ac.hs.se.exception.LoggingAnException;
import kr.ac.hs.se.util.Board;
import kr.ac.hs.se.view.BoardView;

import java.io.*;

import static kr.ac.hs.se.util.Board.*;

public class BoardController {

    private final UserController userController = new UserController();
    private final PostController postController = new PostController();
    private final BoardView boardView = new BoardView();

    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            PrintStream log = new PrintStream(new FileOutputStream("error.log", true));
            System.setErr(log);

            while (true) {
                boardView.showProgramTitle();
                String loginUserId = userController.run(br);
                logout:
                while (true) {
                    Board menu = inputMenu(br);
                    switch (menu) {
                        case ALL_POST:
                            postController.run(br, ALL_POST, loginUserId);
                            break;
                        case MY_POST:
                            postController.run(br, MY_POST, loginUserId);
                            break;
                        case FREE_BOARD:
                            postController.run(br, FREE_BOARD, loginUserId);
                            break;
                        case GAME_BOARD:
                            postController.run(br, GAME_BOARD, loginUserId);
                            break;
                        case MARKET_BOARD:
                            postController.run(br, MARKET_BOARD, loginUserId);
                            break;
                        case LOGOUT:
                            boardView.showLogout();
                            break logout;
                    }
                }
            }
        } catch (Exception e) {
            boardView.showError();
            LoggingAnException.logging(e);
        }
    }

    public Board inputMenu(BufferedReader br) throws IOException {
        boardView.showMenu();
        return Board.of(br.readLine());
    }
}
