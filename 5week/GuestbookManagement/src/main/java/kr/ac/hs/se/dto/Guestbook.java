package kr.ac.hs.se.dto;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Guestbook {

    private int id;
    @NonNull
    private String personName;
    @NonNull
    private String content;
    private String regdate;
}
