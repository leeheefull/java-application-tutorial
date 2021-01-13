package kr.ac.hs.se.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public enum Board {
    FREE_BOARD("#### 자유 게시판 ####"),
    GAME_BOARD("#### 게임 게시판 ####"),
    MARKET_BOARD("#### 장터 게시판 ####");

    private final String title;
}
