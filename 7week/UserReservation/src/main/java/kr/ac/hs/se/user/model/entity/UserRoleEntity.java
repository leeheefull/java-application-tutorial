package kr.ac.hs.se.user.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRoleEntity {

    private Long id;
    private Long userId;
    private String roleName;
}
