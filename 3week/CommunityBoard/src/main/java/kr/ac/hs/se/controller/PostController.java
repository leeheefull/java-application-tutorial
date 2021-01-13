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
            postView.showTableAttribute();
            showTable(board);

            postView.lineBreak();
            postView.showMenu();
            String menu = inputMenu(br);
            switch (menu) {
                case CREATE:
                    postView.showPageName("작성");
                    postView.showInput("글 제목");
                    String titleToCreate = inputTitle(br);
                    postView.showInput("글 내용");
                    String contentToCreate = inputContent(br);
                    postService.createPost(board, titleToCreate, user.getId(), contentToCreate);
                    break;
                case UPDATE:
                    postView.showPageName("수정");
                    postView.showInput("수정할 글 번호");
                    int noToUpdate = Integer.parseInt(br.readLine());
                    postView.showInput("수정할 내용");
                    String contentToUpdate = br.readLine();
                    postService.updatePost(noToUpdate, board, user.getId(), contentToUpdate);
                    break;
                case DELETE:
                    postView.showPageName("삭제");
                    postView.showInput("삭제할 글 번호");
                    int noToDelete = Integer.parseInt(br.readLine());
                    postService.deletePost(noToDelete, board, user.getId());
                    break;
                case END_OF_MANAGEMENT:
                    postView.showEnd();
                    return;
                default:
                    postView.showNumberInputError();
            }
        }
    }

    private void showTable(Board board) {
        postService.getPostList().stream()
                .filter(post -> post.getBoard().equals(board))
                .forEach(System.out::print);
    }

    private String inputMenu(BufferedReader br) throws IOException {
        return br.readLine();
    }

    private String inputTitle(BufferedReader br) throws IOException {
        return br.readLine();
    }

    private String inputContent(BufferedReader br) throws IOException {
        return br.readLine();
    }
}
