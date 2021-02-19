package kr.ac.hs.se.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class ReservationUserCommentDto {
    private long id;
    private long productId;
    private long reservationInfoId;
    private double score;
    private String reservationEmail;
    private String comment;
    private Date createDate;
    private Date modifyDate;
}
