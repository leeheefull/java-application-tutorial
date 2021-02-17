package kr.ac.hs.se.service.impl;

import kr.ac.hs.se.model.*;
import kr.ac.hs.se.repository.*;
import kr.ac.hs.se.response.DisplayInfoDetailResponse;
import kr.ac.hs.se.response.DisplayInfosResponse;
import kr.ac.hs.se.response.ReservationUserCommentResponse;
import kr.ac.hs.se.service.DisplayInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DisplayInfoServiceImpl implements DisplayInfoService {

    private final DisplayInfosRepository displayInfosRepository;

    @Override
    public DisplayInfosResponse getDisplayInfosByProductImageTypeInMa(long categoryId, long pageSize, long page) {
        return new DisplayInfosResponse(displayInfosRepository.getDisplayInfosSize(categoryId),
                pageSize,
                displayInfosRepository.selectDisplayInfos("ma", categoryId, pageSize, page));
    }

    @Override
    public DisplayInfoDetailResponse getDisplayInfo(long displayInfoId) {
        DisplayInfoDto product = displayInfosRepository.selectDisplayInfo("ma", displayInfoId);
        return new DisplayInfoDetailResponse(product,
                displayInfosRepository.selectProductImages(product.getId(), "ma"),
                displayInfosRepository.selectDisplayInfoImages(product.getId()),
                displayInfosRepository.getReservationUserCommentsAvg(product.getId()),
                displayInfosRepository.selectProductPrices(product.getId()));
    }

    @Override
    public ReservationUserCommentResponse getReservationUserCommentsByProductImageTypeInMa(long productId, long pageSize, long page) {
        return new ReservationUserCommentResponse(displayInfosRepository.getReservationUserCommentsSize(productId),
                pageSize,
                displayInfosRepository.selectReservationUserComments(productId, pageSize, page));
    }
}
