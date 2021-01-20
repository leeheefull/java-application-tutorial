package kr.ac.hs.se.menu;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public enum PostMenu {
    CREATE("1", "1. 글 작성하기", "############### 글 작성 페이지 ################"),
    UPDATE("2", "2. 글 수정하기", "############### 글 수정 페이지 ################"),
    DELETE("3", "3. 글 삭제하기", "############### 글 삭제 페이지 ################"),
    BACK("4", "4. 뒤로 가기", "############### 뒤로가기 ################");

    private final String no;
    private final String name;
    private final String title;

    public static PostMenu of(String no) {
        return Arrays.stream(values())
                .filter(menu -> no.equals(menu.no))
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }

    public static List<String> selectMenuByName() {
        return Arrays.stream(PostMenu.values())
                .map(PostMenu::getName)
                .collect(Collectors.toList());
    }

}
