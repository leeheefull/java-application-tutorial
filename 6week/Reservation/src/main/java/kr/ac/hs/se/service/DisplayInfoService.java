package kr.ac.hs.se.service;

import kr.ac.hs.se.response.DisplayInfoDetailResponse;
import kr.ac.hs.se.response.DisplayInfosResponse;
import kr.ac.hs.se.response.ReservationUserCommentsResponse;

public interface DisplayInfoService {

    DisplayInfosResponse getDisplayInfosByProductImageTypeInMa();

    DisplayInfosResponse getDisplayInfosByProductImageTypeInMa(long categoryId);

    DisplayInfosResponse getDisplayInfosByProductImageTypeInMa(long categoryId, long pageSize, long page);

    DisplayInfoDetailResponse getDisplayInfoByProductImageTypeInMa(long displayInfoId);

    ReservationUserCommentsResponse getReservationUserComments();

    ReservationUserCommentsResponse getReservationUserComments(long productId);

    ReservationUserCommentsResponse getReservationUserComments(long productId, long pageSize, long page);
}