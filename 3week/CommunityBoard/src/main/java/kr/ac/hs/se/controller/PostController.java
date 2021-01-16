package kr.ac.hs.se.controller;

import kr.ac.hs.se.model.Board;
import kr.ac.hs.se.service.PostService;
import kr.ac.hs.se.view.PostView;

import java.io.BufferedReader;
import java.io.IOException;

import static kr.ac.hs.se.util.BoardConstants.PostMenu.*;

public class PostController implements Controller {

    private final PostService postService = new PostService();
    private final PostView postView = new PostView();

    public void run(BufferedReader br, Board board, String userId) throws IOException {
        while (true) {
            postView.showBoardTitle(board.getTitle());
            showTable(board);
            if (board.equals(Board.ALL_POST_BOARD)) {
                return;
            } else {
                String menu = inputMenu(br);
                switch (menu) {
                    case CREATE:
                        createPost(br, board, userId);
                        break;
                    case UPDATE:
                        updatePost(br, board, userId);
                        break;
                    case DELETE:
                        deletePost(br, board, userId);
                        break;
                    case END_OF_MANAGEMENT:
                        postView.showEnd();
                        return;
                    default:
                        postView.showNumberInputError();
                }
            }
        }
    }

    @Override
    public String inputMenu(BufferedReader br) throws IOException {
        postView.showMenu();
        return br.readLine();
    }

    private void createPost(BufferedReader br, Board board, String userId) throws IOException {
        postView.showPageName("작성");

        postView.showInput("글 제목");
        String title = br.readLine();

        postView.showInput("글 내용");
        String content = br.readLine();

        postService.createPost(board, title, userId, content);
    }

    private void updatePost(BufferedReader br, Board board, String userId) throws IOException {
        postView.showPageName("수정");

        postView.showInput("수정할 글 번호");
        int no = Integer.parseInt(br.readLine());

        postView.showInput("수정할 내용");
        String content = br.readLine();

        postService.updatePost(no, board, userId, content);
    }

    private void deletePost(BufferedReader br, Board board, String userId) throws IOException {
        postView.showPageName("삭제");

        postView.showInput("삭제할 글 번호");
        int no = Integer.parseInt(br.readLine());

        postService.deletePost(no, board, userId);
    }

    private void showTable(Board board) {
        postView.showTableAttribute();
        postView.showBoardTable(postService.selectPostsByBoard(board));
        postView.lineBreak();
    }
}
