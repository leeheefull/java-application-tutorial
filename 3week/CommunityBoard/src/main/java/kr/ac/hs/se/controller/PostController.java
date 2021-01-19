package kr.ac.hs.se.controller;

import kr.ac.hs.se.util.Board;
import kr.ac.hs.se.service.PostService;
import kr.ac.hs.se.util.PostMenu;
import kr.ac.hs.se.view.PostView;

import java.io.BufferedReader;
import java.io.IOException;

public class PostController {

    private final PostService postService = new PostService();
    private final PostView postView = new PostView();

    public void run(BufferedReader br, Board board, String userId) throws IOException {
        while (true) {
            postView.showBoardTitle(board.getTitle());
            if (board.equals(Board.ALL_POST)) {
                showPostTable(board);
                return;
            } else if (board.equals(Board.MY_POST)) {
                showMyPostTable(userId);
                return;
            }
            showPostTable(board);
            PostMenu menu = inputMenu(br);
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
                case BACK:
                    postView.showEnd();
                    return;
            }
        }
    }

    public PostMenu inputMenu(BufferedReader br) throws IOException {
        postView.showMenu();
        return PostMenu.of(br.readLine());
    }

    private void createPost(BufferedReader br, Board board, String userId) throws IOException {
        postView.showPostMenuTitle(PostMenu.CREATE.getTitle());

        postView.showInput("글 제목");
        String title = br.readLine();

        postView.showInput("글 내용");
        String content = br.readLine();

        postService.createPost(board, title, userId, content);
    }

    private void updatePost(BufferedReader br, Board board, String userId) throws IOException {
        postView.showPostMenuTitle(PostMenu.UPDATE.getTitle());

        postView.showInput("수정할 글 번호");
        int no = Integer.parseInt(br.readLine());

        postView.showInput("수정할 내용");
        String content = br.readLine();

        postService.updatePost(no, board, userId, content);
    }

    private void deletePost(BufferedReader br, Board board, String userId) throws IOException {
        postView.showPostMenuTitle(PostMenu.DELETE.getTitle());

        postView.showInput("삭제할 글 번호");
        int no = Integer.parseInt(br.readLine());

        postService.deletePost(no, board, userId);
    }

    private void showPostTable(Board board) {
        postView.showTableAttribute();
        postView.showBoardTable(postService.selectPostsByBoard(board));
        postView.lineBreak();
    }

    private void showMyPostTable(String userId) {
        postView.showTableAttribute();
        postView.showBoardTable(postService.selectPostsById(userId));
        postView.lineBreak();
    }
}
