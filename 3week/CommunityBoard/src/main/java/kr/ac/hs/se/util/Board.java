package kr.ac.hs.se.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum Board {

    ALL_POST("1", "1. 모든 글 보기", "################ 모든 글 보기 ################"),
    MY_POST("2", "2. 나의 글 보기", "################ 나의 글 보기 ################"),
    FREE_BOARD("3", "3. 자유 게시판", "################ 자유 게시판 ################"),
    GAME_BOARD("4", "4. 게임 게시판", "################ 게임 게시판 ################"),
    MARKET_BOARD("5", "5. 장터 게시판", "################ 장터 게시판 ################"),
    LOGOUT("6", "6. 로그아웃", "################ 로그 아웃 ################");

    private final String no;
    private final String name;
    private final String title;

    public static Board of(String no) throws NullPointerException {
        return Arrays.stream(values())
                .filter(board -> no.equals(board.no))
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }

    public static Stream<String> selectMenuByName() {
        return Arrays.stream(Board.values())
                .map(Board::getName);
    }
}
