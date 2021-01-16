package kr.ac.hs.se.service;

import kr.ac.hs.se.exception.LoginException;
import kr.ac.hs.se.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserService {

    private final List<User> userList = new ArrayList<>();

    public User login(String id, String pw) throws LoginException {
        if (!Objects.equals(searchUser(id, pw), null)) {
            return searchUser(id, pw);
        } else {
            throw new LoginException();
        }
    }

    private User searchUser(String id, String pw) {
        for (User user : userList) {
            if (user.getId().equals(id) && user.getPw().equals(pw)) {
                return user;
            }
        }
        return null;
    }

    public boolean signUp(User user) {
        if (checkId(user.getId())) {
            userList.add(user);
            return true;
        }
        return false;
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
