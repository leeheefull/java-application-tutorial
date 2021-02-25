package kr.ac.hs.se.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserRole {

    private String userLoginId;
    private String roleName;
}
