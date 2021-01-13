package kr.ac.hs.se.controller;

import kr.ac.hs.se.model.Board;
import kr.ac.hs.se.model.Post;
import kr.ac.hs.se.model.User;
import kr.ac.hs.se.service.PostService;

import java.io.BufferedReader;
import java.io.IOException;

import static kr.ac.hs.se.util.BoardConstants.PostMenu.*;

public class PostController {

    private final PostService postService = new PostService();

    public void run(BufferedReader br, Board board, User user) throws IOException {
        while (true) {
            System.out.println("################ " + board.getName() + " ################");
            System.out.println("번호\t\t작성한 날짜\t작성자\t글 제목\t내용");
            for (Post post : postService.getPostList()) {
                if (post.getBoard().equals(board)) {
                    System.out.print(post);
                }
            }
            System.out.println("###########################################");
            System.out.println("############### 글 관리 메뉴 ################");
            System.out.println("## 1. 작성 / 2. 수정 / 3. 삭제 / 4. 로그아웃 ##");
            System.out.print("입력할 번호 >> ");
            String menu = br.readLine();
            switch (menu) {
                case CREATE:
                    System.out.println("############### 글 작성 페이지 ###############");
                    System.out.print("글 제목 >> ");
                    String titleToCreate = br.readLine();
                    System.out.print("글 내용 >> ");
                    String contentToCreate = br.readLine();
                    postService.createPost(board, titleToCreate, user.getId(), contentToCreate);
                    break;
                case UPDATE:
                    System.out.println("############### 글 수정 페이지 ###############");
                    System.out.print("수정할 글 번호 >> ");
                    int noToUpdate = Integer.parseInt(br.readLine());
                    System.out.print("수정할 내용 >> ");
                    String contentToUpdate = br.readLine();
                    postService.updatePost(noToUpdate, board, user.getId(), contentToUpdate);
                    break;
                case DELETE:
                    System.out.println("############### 글 삭제 페이지 ###############");
                    System.out.print("삭제할 글 번호 >> ");
                    int noToDelete = Integer.parseInt(br.readLine());
                    postService.deletePost(noToDelete, board, user.getId());
                    break;
                case LOGOUT:
                    System.out.println("-> " + user.getId() + "로그아웃 하셨습니다.");
                    return;
            }
        }
    }
}
