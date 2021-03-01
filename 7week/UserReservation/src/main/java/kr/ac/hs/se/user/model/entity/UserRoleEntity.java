package kr.ac.hs.se.user.model.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserRoleEntity {

    private Long id;
    private Long userId;
    private String roleName;
}
