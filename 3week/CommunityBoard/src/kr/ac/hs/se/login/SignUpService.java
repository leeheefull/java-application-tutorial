package kr.ac.hs.se.login;

import kr.ac.hs.se.model.User;
import kr.ac.hs.se.model.UserList;

public class SignUpService {

    private UserList userList;

    public SignUpService() {
        this.userList = new UserList();
    }

    public void signUp(User user) {
        if (checkId(user.getId())) {
            userList.getUserList().add(user);
        }
    }

    private boolean checkId(String id) {
        for (User user : userList.getUserList()) {
            if (user.getId().equals(id)) {
                return false;
            }
        }
        return true;
    }
}
