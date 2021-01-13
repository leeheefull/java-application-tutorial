package kr.ac.hs.se.login;

import kr.ac.hs.se.model.User;
import kr.ac.hs.se.model.UserList;

public class LoginService {

    private UserList userList;

    public LoginService() {
        this.userList = new UserList();
    }

    public User login(String id, String pw) {
        if(checkUser(id, pw)){
            return getUser(id);
        }
        return null;
    }

    private User getUser(String id) {
        for(User user : userList.getUserList()){
            if(user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }

    private boolean checkUser(String id, String pw) {
        for (User user : userList.getUserList()) {
            if (user.getId().equals(id) && user.getPw().equals(pw)) {
                return true;
            }
        }
        return false;
    }
}
