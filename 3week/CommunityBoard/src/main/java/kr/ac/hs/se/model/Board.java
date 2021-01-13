package kr.ac.hs.se.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Getter

public enum Board {
    FREE_BOARD("1","자유 게시판"),
    GAME_BOARD("2", "게임 게시판"),
    MARKET_BOARD("3", "장터 게시판");

    private final String no;
    private final String name;
}
