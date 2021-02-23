package kr.ac.hs.se.reservation.model;

import kr.ac.hs.se.reservation.model.domain.ReservationInfoPrice;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
public class ReservationRequest {

    private List<ReservationInfoPrice> prices;
    private long productId;
    private long displayInfoId;
    private String reservationYearMonthDay;
    private long userId;
}
