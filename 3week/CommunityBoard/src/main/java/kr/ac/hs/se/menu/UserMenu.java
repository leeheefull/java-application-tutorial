package kr.ac.hs.se.menu;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public enum UserMenu {

    LOGIN("1", "1. 로그인 하기", "############### 로그인 페이지 ################"),
    SIGNUP("2", "2. 회원가입 하기", "############## 회원가입 페이지 ###############"),
    END_OF_PROGRAM("3", "3. 프로그램 종료하기", "############### 프로그램 종료 ################");

    private final String no;
    private final String name;
    private final String title;

    public static UserMenu of(String no) {
        return Arrays.stream(values())
                .filter(board -> no.equals(board.no))
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }

    public static List<String> selectMenuByName() {
        return Arrays.stream(UserMenu.values())
                .map(UserMenu::getName)
                .collect(Collectors.toList());
    }
}
