package kr.ac.hs.se.exception;

public class LoginException extends Exception {

    @Override
    public String getMessage() {
        return "로그인 중 오류가 발생 했습니다.";
    }
}
