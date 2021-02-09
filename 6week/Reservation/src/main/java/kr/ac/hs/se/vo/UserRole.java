package kr.ac.hs.se.vo;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserRole {
    private long id;
    private long userId;
    private String roleName;
}
