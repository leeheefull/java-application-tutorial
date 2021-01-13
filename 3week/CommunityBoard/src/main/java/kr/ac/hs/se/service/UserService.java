package kr.ac.hs.se.service;

import kr.ac.hs.se.model.User;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter

public class UserService {

    private final List<User> userList = new ArrayList<>();

    public User login(String id, String pw) {
        if (checkUser(id, pw)) {
            return getUser(id);
        }
        return null;
    }

    private User getUser(String id) {
        for (User user : userList) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    private boolean checkUser(String id, String pw) {
        for (User user : userList) {
            if (user.getId().equals(id) && user.getPw().equals(pw)) {
                return true;
            }
        }
        return false;
    }

    public void signUp(User user) {
        if (checkId(user.getId())) {
            userList.add(user);
        }
    }

    private boolean checkId(String id) {
        for (User user : userList) {
            if (user.getId().equals(id)) {
                return false;
            }
        }
        return true;
    }
}
