package kr.ac.hs.se.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LoginUser {

    private String loginUserId; // UserEntity.getEmail()
    private String password;
}
