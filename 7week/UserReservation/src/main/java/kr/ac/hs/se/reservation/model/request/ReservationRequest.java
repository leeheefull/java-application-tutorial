package kr.ac.hs.se.reservation.model.request;

import kr.ac.hs.se.reservation.model.entity.ReservationInfoPrice;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
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
