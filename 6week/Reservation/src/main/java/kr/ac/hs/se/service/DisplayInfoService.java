package kr.ac.hs.se.service;

import kr.ac.hs.se.response.DisplayInfoDetailResponse;
import kr.ac.hs.se.response.DisplayInfosResponse;
import kr.ac.hs.se.response.ReservationUserCommentResponse;

public interface DisplayInfoService {

    DisplayInfosResponse getDisplayInfosByProductImageTypeInMa(long categoryId, long pageSize, long page);

    DisplayInfoDetailResponse getDisplayInfo(long displayInfoId);

    ReservationUserCommentResponse getReservationUserCommentsByProductImageTypeInMa(long productId, long pageSize, long page);
}