package kr.ac.hs.se.dto;

import kr.ac.hs.se.vo.ReservationUserCommentImage;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ReservationUserCommentDTO {
    private long id;
    private long productId;
    private long reservationInfoId;
    private double score;
    private String reservationEmail;
    private String comment;
    private Date createDate;
    private Date modifyDate;
    private List<ReservationUserCommentImage> reservationUserCommentImages;
}
