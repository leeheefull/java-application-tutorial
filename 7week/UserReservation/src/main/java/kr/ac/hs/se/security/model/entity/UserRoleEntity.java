package kr.ac.hs.se.security.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserRoleEntity {

    private String userLoginId;
    private String roleName;
}
