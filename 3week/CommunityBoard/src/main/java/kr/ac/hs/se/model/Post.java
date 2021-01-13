package kr.ac.hs.se.model;

import kr.ac.hs.se.util.BoardConstants;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "board")

public class Post {

    private int no;
    private Board board;
    private String title;
    private String userId;
    private String content;

    private final String date = BoardConstants.YYYYMMDD.format(LocalDateTime.now());
}
