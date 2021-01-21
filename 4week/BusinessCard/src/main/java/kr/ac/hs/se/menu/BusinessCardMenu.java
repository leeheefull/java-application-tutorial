package kr.ac.hs.se.menu;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public enum BusinessCardMenu {
    CREATE("1", "1. 명함 입력", "################ 명함 입력 ################"),
    SEARCH("2", "2. 명함 검색", "################ 명함 검색 ################"),
    END("3", "3. 종료", "############## End Program ##############");

    private final String no;
    private final String name;
    private final String title;

    public static BusinessCardMenu of(String no) {
        return Arrays.stream(values())
                .filter(menu -> no.equals(menu.no))
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }

    public static List<String> selectMenuByName() {
        return Arrays.stream(BusinessCardMenu.values())
                .map(BusinessCardMenu::getName)
                .collect(Collectors.toList());
    }
}
