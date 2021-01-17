package kr.ac.hs.se.exception;

public class ExitException extends Exception {

    @Override
    public String getMessage() {
        return "프로그램을 종료하겠습니다.";
    }
}
