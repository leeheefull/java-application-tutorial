package kr.ac.hs.se.user.model.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class SignupRequest {

    private String name;
    private String password;
    private String email;
    private String phone;
}
