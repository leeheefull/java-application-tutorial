package kr.ac.hs.se.controller;

import kr.ac.hs.se.model.Board;
import kr.ac.hs.se.model.User;
import kr.ac.hs.se.service.PostService;
import kr.ac.hs.se.view.PostView;

import java.io.BufferedReader;
import java.io.IOException;

import static kr.ac.hs.se.util.BoardConstants.PostMenu.*;

public class PostController {

    private final PostService postService = new PostService();
    private final PostView postView = new PostView();

    public void run(BufferedReader br, Board board, User user) throws IOException {
        while (true) {
            postView.showBoardTitle(board.getTitle());
            showTable(board);
            String menu = inputMenu(br);
            switch (menu) {
                case CREATE:
                    createPost(br, board, user);
                    break;
                case UPDATE:
                    updatePost(br, board, user);
                    break;
                case DELETE:
                    deletePost(br, board, user);
                    break;
                case END_OF_MANAGEMENT:
                    postView.showEnd();
                    return;
                default:
                    postView.showNumberInputError();
            }
        }
    }

    private String inputMenu(BufferedReader br) throws IOException {
        postView.showMenu();
        return br.readLine();
    }

    private void createPost(BufferedReader br, Board board, User user) throws IOException {
        postView.showPageName("작성");
        postView.showInput("글 제목");
        String titleToCreate = br.readLine();
        postView.showInput("글 내용");
        String contentToCreate = br.readLine();
        postService.createPost(board, titleToCreate, user.getId(), contentToCreate);
    }

    private void updatePost(BufferedReader br, Board board, User user) throws IOException {
        postView.showPageName("수정");
        postView.showInput("수정할 글 번호");
        int noToUpdate = Integer.parseInt(br.readLine());
        postView.showInput("수정할 내용");
        String contentToUpdate = br.readLine();
        postService.updatePost(noToUpdate, board, user.getId(), contentToUpdate);
    }

    private void deletePost(BufferedReader br, Board board, User user) throws IOException {
        postView.showPageName("삭제");
        postView.showInput("삭제할 글 번호");
        int noToDelete = Integer.parseInt(br.readLine());
        postService.deletePost(noToDelete, board, user.getId());
    }

    private void showTable(Board board) {
        postView.showTableAttribute();
        postService.getPostList().stream()
                .filter(post -> post.getBoard().equals(board))
                .forEach(System.out::print);  // 개선 필요: view로 분리하기
        postView.lineBreak();
    }
}
