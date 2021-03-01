package kr.ac.hs.se.user.model.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserEntity {

    private Long id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private String createDate;
    private String modifyDate;
}
