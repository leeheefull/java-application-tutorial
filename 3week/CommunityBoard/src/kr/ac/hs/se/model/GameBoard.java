package kr.ac.hs.se.model;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {

    private final List<Post> postList;

    public GameBoard() {
        this.postList = new ArrayList<>();
    }

    public List<Post> getPostList() {
        return postList;
    }

    @Override
    public String toString() {
        return postList + "";
    }
}
