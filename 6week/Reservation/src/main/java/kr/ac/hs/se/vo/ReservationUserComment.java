package kr.ac.hs.se.vo;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class ReservationUserComment {
    private long id;
    private long productId;
    private long reservationInfoId;
    private long userId;
    private double score;
    private String comment;
    private Date createDate;
    private Date modifyDate;
}
