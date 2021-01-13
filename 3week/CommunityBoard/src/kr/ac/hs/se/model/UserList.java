package kr.ac.hs.se.model;

import java.util.ArrayList;
import java.util.List;

public class UserList {

    private final List<User> userList;

    public UserList() {
        userList = new ArrayList<>();
    }

    public List<User> getUserList() {
        return userList;
    }
}
