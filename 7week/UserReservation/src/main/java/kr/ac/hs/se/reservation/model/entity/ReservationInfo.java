package kr.ac.hs.se.reservation.model.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ReservationInfo {

    private long id;
    private long productId;
    private long cancelFlag;
    private long displayInfoId;
    private long userId;
    private String reservationDate;
    private String createDate;
    private String modifyDate;
}
