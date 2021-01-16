package kr.ac.hs.se.util;

import java.time.format.DateTimeFormatter;

public class BoardConstants {

    public static final DateTimeFormatter YYYYMMDD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final String LOGOUT = "5";

    public static class UserMenu {
        public static final String LOGIN = "1";
        public static final String SIGNUP = "2";
        public static final String END_OF_PROGRAM = "3";
    }

    public static class PostMenu {
        public static final String CREATE = "1";
        public static final String UPDATE = "2";
        public static final String DELETE = "3";
        public static final String END_OF_MANAGEMENT = "4";
    }
}
