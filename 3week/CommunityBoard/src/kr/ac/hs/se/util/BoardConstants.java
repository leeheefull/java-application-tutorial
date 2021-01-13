package kr.ac.hs.se.util;

import java.time.format.DateTimeFormatter;

public class BoardConstants {

    public static final DateTimeFormatter YYYYMMDD = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static class LoginMenu {
        public static final String LOGIN = "1";
        public static final String SIGNUP = "2";
    }
}
