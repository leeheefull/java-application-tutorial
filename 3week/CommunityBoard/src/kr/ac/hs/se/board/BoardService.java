package kr.ac.hs.se.board;

import kr.ac.hs.se.model.FreeBoard;
import kr.ac.hs.se.model.GameBoard;
import kr.ac.hs.se.model.MarketBoard;
import kr.ac.hs.se.model.Post;

public class BoardService {

    private static int cnt = 0;
    private final FreeBoard freeBoard;
    private final GameBoard gameBoard;
    private final MarketBoard marketBoard;

    public BoardService() {
        freeBoard = new FreeBoard();
        gameBoard = new GameBoard();
        marketBoard = new MarketBoard();
    }

    public void addFreeBoardPost(String title, String id, String content) {
        freeBoard.getPostList().add(new Post(cnt++, title, id, content));
    }

    public void removeFreeBoardPost(int no) {
        for (Post post : freeBoard.getPostList()) {
            if (post.getNo() == no) {
                freeBoard.getPostList().remove(post);
            }
        }
    }

    public void addGameBoardPost(String title, String id, String content) {
        gameBoard.getPostList().add(new Post(cnt++, title, id, content));
    }

    public void removeGameBoardPost(int no) {
        for (Post post : gameBoard.getPostList()) {
            if (post.getNo() == no) {
                gameBoard.getPostList().remove(post);
            }
        }
    }

    public void addMarketBoardPost(String title, String id, String content) {
        marketBoard.getPostList().add(new Post(cnt++, title, id, content));
    }

    public void removeMarketBoardPost(int no) {
        for (Post post : marketBoard.getPostList()) {
            if (post.getNo() == no) {
                marketBoard.getPostList().remove(post);
            }
        }
    }
}
