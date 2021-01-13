package kr.ac.hs.se.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(exclude = "pw")

public class User {

    private String name;
    private String id;
    private String pw;
}