package kr.ac.hs.se.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum PostMenu {
    CREATE("1", "글 작성하기"),
    UPDATE("2", "글 수정하기"),
    DELETE("3", "글 삭제하기"),
    BACK("4", "뒤로 가기");

    private final String no;
    private final String name;

    public static PostMenu of(String no) throws NullPointerException {
        return Arrays.stream(values())
                .filter(menu -> no.equals(menu.no))
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }
}
