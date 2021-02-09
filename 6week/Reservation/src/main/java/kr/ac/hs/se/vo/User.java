package kr.ac.hs.se.vo;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class User {
    private long id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private Date createDate;
    private Date modifyDate;
}
