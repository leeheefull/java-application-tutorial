package kr.ac.hs.se.service;

import kr.ac.hs.se.model.Board;
import kr.ac.hs.se.model.Post;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter

public class PostService {

    private final List<Post> postList = new ArrayList<>();
    private int cnt = 0;

    public void addPost(Board board, String title, String userId, String content) {
        postList.add(new Post(cnt++, board, title, userId, content));
    }

    public void updatePost(int no, Board board, String userId, String content) {
        for (Post post : postList) {
            if (post.getNo() == no && post.getBoard().equals(board) && post.getUserId().equals(userId)) {
                post.setContent(content);
            }
        }
    }

    public void removePost(int no, Board board, String userId) {
        for (Post post : postList) {
            if (post.getNo() == no && post.getBoard().equals(board) && post.getUserId().equals(userId)) {
                postList.remove(post);
            }
        }
    }
}
