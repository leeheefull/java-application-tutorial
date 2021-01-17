package kr.ac.hs.se.service;

import kr.ac.hs.se.exception.LoginException;
import kr.ac.hs.se.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {

    private final List<User> userList = new ArrayList<>();

    public User login(String id, String pw) throws LoginException {
        return Optional.ofNullable(searchUser(id, pw))
                .orElseThrow(LoginException::new);
    }

    private User searchUser(String id, String pw) {
        for (User user : userList) {
            if (user.getId().equals(id) && user.getPw().equals(pw)) {
                return user;
            }
        }
        return null;
    }

    public boolean signUp(String name, String id, String pw) {
        if (checkId(id)) {
            userList.add(new User(name, id, pw));
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
