package kr.ac.hs.se.reservation.model.response;

import kr.ac.hs.se.reservation.model.entity.ReservationInfo;
import kr.ac.hs.se.reservation.model.entity.ReservationInfoPrice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReservationResponse {

    private ReservationInfo reservationInfo;
    private List<ReservationInfoPrice> prices;
}
