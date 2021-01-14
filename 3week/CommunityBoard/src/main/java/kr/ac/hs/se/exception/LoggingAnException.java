package kr.ac.hs.se.exception;

import java.util.Date;

public class LoggingAnException {

    public static void logging(Exception e) {
        System.err.println("---------------------------------------------------------------------------------------------------------");
        System.err.println("예외발생시간: " + new Date());
        e.printStackTrace(System.err);
        System.err.println("예외 메세지: " + e.getMessage());
        System.err.println("---------------------------------------------------------------------------------------------------------");
    }
}
