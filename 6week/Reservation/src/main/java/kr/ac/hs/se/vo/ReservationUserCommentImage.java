package kr.ac.hs.se.vo;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ReservationUserCommentImage {
    private long id;
    private long reservationInfoId;
    private long reservationUserComment_id;
    private long fileId;
}
