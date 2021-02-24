package kr.ac.hs.se.reservation.model.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ReservationInfoPrice {

    private long id;
    private long reservationInfoId;
    private long productPriceId;
    private long count;
}
