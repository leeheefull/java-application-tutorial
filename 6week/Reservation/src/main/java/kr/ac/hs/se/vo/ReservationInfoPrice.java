package kr.ac.hs.se.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ReservationInfoPrice {
    private long id;
    private long reservationInfoId;
    private long productPriceId;
    private long count;
}
