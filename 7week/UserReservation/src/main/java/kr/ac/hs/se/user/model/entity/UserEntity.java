package kr.ac.hs.se.user.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserEntity {

    private String loginUserId;
    private String password;
}
