package kr.ac.hs.se.reservation.service;

import kr.ac.hs.se.reservation.model.ReservationDto;
import kr.ac.hs.se.reservation.repository.ReservationDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReservationService {

    private final ReservationDao reservationDao;

    public List<ReservationDto> getReservationInfos(String email) {
        return reservationDao.selectReservationInfos(email);
    }

    @Transactional
    public long updateReservationCancelFlag(long reservationId) {
        return reservationDao.updateReservationInfoCancelFlag(reservationId);
    }
}
