package kr.ac.hs.se.model.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CommentDto {
    private long id;
    private long productId;
    private long reservationInfoId;
    private double score;
    private String reservationEmail;
    private String comment;
    private String createDate;
    private String modifyDate;
}
