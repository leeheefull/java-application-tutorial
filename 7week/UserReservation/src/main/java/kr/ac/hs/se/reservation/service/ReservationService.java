package kr.ac.hs.se.reservation.service;

import kr.ac.hs.se.reservation.model.Dto.ReservationDetail;
import kr.ac.hs.se.reservation.model.response.ReservationResponse;
import kr.ac.hs.se.reservation.model.entity.ReservationInfo;
import kr.ac.hs.se.reservation.model.entity.ReservationInfoPrice;
import kr.ac.hs.se.reservation.model.request.ReservationRequest;
import kr.ac.hs.se.reservation.repository.ReservationDetailDao;
import kr.ac.hs.se.reservation.repository.ReservationInfoDao;
import kr.ac.hs.se.reservation.repository.ReservationInfoPriceDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReservationService {

    private final ReservationDetailDao reservationDetailDao;
    private final ReservationInfoDao reservationInfoDao;
    private final ReservationInfoPriceDao reservationInfoPriceDao;

    public List<ReservationDetail> getReservations(String email) {
        return reservationDetailDao.selectReservationInfoDetails(email);
    }

    @Transactional
    public ReservationResponse createReservation(ReservationRequest request) {

        long reservationInfoId = reservationInfoDao.insertReservationInfo(
                ReservationInfo.builder()
                        .productId(request.getProductId())
                        .displayInfoId(request.getDisplayInfoId())
                        .userId(request.getUserId())
                        .reservationDate(request.getReservationYearMonthDay())
                        .createDate(request.getReservationYearMonthDay())
                        .modifyDate(request.getReservationYearMonthDay())
                        .build()
        );

        for (ReservationInfoPrice reservationInfoPrice : request.getPrices()) {
            reservationInfoPriceDao.insertReservationInfoPrice(
                    ReservationInfoPrice.builder()
                            .reservationInfoId(reservationInfoId)
                            .productPriceId(reservationInfoPrice.getProductPriceId())
                            .count(reservationInfoPrice.getCount())
                            .build()
            );
        }

        return new ReservationResponse(
                reservationInfoDao.selectReservationInfo(reservationInfoId),
                reservationInfoPriceDao.selectReservationInfoPrices(reservationInfoId)
        );
    }

    @Transactional
    public long updateReservationCancelFlag(long reservationId) {
        return reservationInfoDao.updateReservationInfoCancelFlag(reservationId);
    }
}
