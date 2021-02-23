package kr.ac.hs.se.reservation.model.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ReservationInfoPrice {

    private long id;
    private long reservationInfoId;
    private long productPriceId;
    private long count;
}
