package kr.ac.hs.se.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Board {

    FREE_BOARD("1", "자유 게시판", "################ 자유 게시판 ################"),
    GAME_BOARD("2", "게임 게시판", "################ 게임 게시판 ################"),
    MARKET_BOARD("3", "장터 게시판", "################ 장터 게시판 ################");

    private final String no;
    private final String name;
    private final String title;
}
