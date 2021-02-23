package kr.ac.hs.se.reservation.model.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ReservationInfo {

    private long id;
    private long productId;
    private long displayInfoId;
    private long userId;
    private String reservationDate;
    private long cancelFlag;
    private String createDate;
    private String modifyDate;
}
