package kr.ac.hs.se.controller;

import kr.ac.hs.se.util.LoggingAnException;
import kr.ac.hs.se.menu.Board;
import kr.ac.hs.se.view.BoardView;

import java.io.*;

import static kr.ac.hs.se.menu.Board.*;

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
                while (true) {
                    Board menu = inputMenu(br);

                    if (menu.equals(LOGOUT)) {
                        boardView.showLogout();
                        break;
                    }

                    postController.run(br, menu, loginUserId);
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
