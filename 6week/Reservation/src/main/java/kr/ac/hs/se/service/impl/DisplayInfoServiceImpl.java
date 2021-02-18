package kr.ac.hs.se.service.impl;

import kr.ac.hs.se.model.*;
import kr.ac.hs.se.repository.*;
import kr.ac.hs.se.response.DisplayInfoDetailResponse;
import kr.ac.hs.se.response.DisplayInfosResponse;
import kr.ac.hs.se.response.ReservationUserCommentsResponse;
import kr.ac.hs.se.service.DisplayInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DisplayInfoServiceImpl implements DisplayInfoService {

    private final DisplayInfosRepository displayInfosRepository;

    @Override
    public DisplayInfosResponse getDisplayInfosByProductImageTypeInMa() {
        return new DisplayInfosResponse(displayInfosRepository.selectDisplayInfos("ma").size(),
                displayInfosRepository.selectDisplayInfos("ma").size(),
                displayInfosRepository.selectDisplayInfos("ma"));
    }

    @Override
    public DisplayInfosResponse getDisplayInfosByProductImageTypeInMa(long categoryId) {
        return new DisplayInfosResponse(displayInfosRepository.selectDisplayInfos("ma", categoryId).size(),
                displayInfosRepository.selectDisplayInfos("ma", categoryId).size(),
                displayInfosRepository.selectDisplayInfos("ma", categoryId));
    }

    @Override
    public DisplayInfosResponse getDisplayInfosByProductImageTypeInMa(long categoryId, long pageSize, long page) {
        return new DisplayInfosResponse(displayInfosRepository.getDisplayInfosSize(categoryId),
                pageSize,
                displayInfosRepository.selectDisplayInfos("ma", categoryId, pageSize, page));
    }

    @Override
    public DisplayInfoDetailResponse getDisplayInfoByProductImageTypeInMa(long displayInfoId) {
        DisplayInfoDto product = displayInfosRepository.selectDisplayInfo("ma", displayInfoId);
        return new DisplayInfoDetailResponse(product,
                displayInfosRepository.selectProductImages(product.getId(), "ma"),
                displayInfosRepository.selectDisplayInfoImages(product.getId()),
                displayInfosRepository.getReservationUserCommentsAvg(product.getId()),
                displayInfosRepository.selectProductPrices(product.getId()));
    }

    @Override
    public ReservationUserCommentsResponse getReservationUserComments() {
        return new ReservationUserCommentsResponse(displayInfosRepository.selectReservationUserComments().size(),
                displayInfosRepository.selectReservationUserComments().size(),
                displayInfosRepository.selectReservationUserComments());
    }

    @Override
    public ReservationUserCommentsResponse getReservationUserComments(long productId) {
        return new ReservationUserCommentsResponse(displayInfosRepository.selectReservationUserComments(productId).size(),
                displayInfosRepository.selectReservationUserComments(productId).size(),
                displayInfosRepository.selectReservationUserComments(productId));
    }

    @Override
    public ReservationUserCommentsResponse getReservationUserComments(long productId, long pageSize, long page) {
        return new ReservationUserCommentsResponse(displayInfosRepository.getReservationUserCommentsSize(productId),
                pageSize,
                displayInfosRepository.selectReservationUserComments(productId, pageSize, page));
    }
}
