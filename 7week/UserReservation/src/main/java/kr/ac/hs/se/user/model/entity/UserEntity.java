package kr.ac.hs.se.user.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity {

    private Long id;
    private String name;
    private String password;
    private String email;
    private Date createDate;
    private Date modifyDate;
}
