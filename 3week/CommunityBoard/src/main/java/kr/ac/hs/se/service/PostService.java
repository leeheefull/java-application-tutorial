package kr.ac.hs.se.service;

import kr.ac.hs.se.menu.Board;
import kr.ac.hs.se.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PostService {

    private final List<Post> postList = new ArrayList<>();
    private int cnt = 0;

    public void createPost(Board board, String title, String userId, String content) {
        postList.add(new Post(cnt++, board, title, userId, content));
    }

    public void updatePost(int no, Board board, String userId, String content) {
        for (Post post : postList) {
            if (post.getNo() == no && post.getBoard().equals(board) && post.getUserId().equals(userId)) {
                post.setContent(content);
            }
        }
    }

    public void deletePost(int no, Board board, String userId) {
        postList.removeIf(post -> post.getNo() == no && post.getBoard().equals(board) && post.getUserId().equals(userId));
    }

    public List<Post> selectPostsByBoard(Board board) {
        if (board.equals(Board.ALL_POST)) {
            return this.postList;
        }
        return this.postList
                .stream()
                .filter(post -> post.getBoard().equals(board))
                .collect(Collectors.toList());
    }

    public List<Post> selectPostsById(String userId) {
        return this.postList
                .stream()
                .filter(post -> post.getUserId().equals(userId))
                .collect(Collectors.toList());
    }
}