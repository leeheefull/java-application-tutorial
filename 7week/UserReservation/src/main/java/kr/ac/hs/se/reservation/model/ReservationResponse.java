package kr.ac.hs.se.reservation.model;

import kr.ac.hs.se.reservation.model.domain.ReservationInfoPrice;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class ReservationResponse {

    private long id;
    private long productId;
    private long cancelFlag;
    private long displayInfoId;
    private long userId;
    private String reservationDate;
    private String createDate;
    private String modifyDate;
    private List<ReservationInfoPrice> prices;
}
