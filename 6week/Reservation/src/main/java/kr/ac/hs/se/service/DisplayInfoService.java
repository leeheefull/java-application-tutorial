package kr.ac.hs.se.service;

import kr.ac.hs.se.model.*;
import kr.ac.hs.se.repository.*;
import kr.ac.hs.se.response.DetailResponse;
import kr.ac.hs.se.response.ListPageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static kr.ac.hs.se.util.Type.PRODUCT_IMAGE_TYPE_MA;

@RequiredArgsConstructor
@Service
public class DisplayInfoService {

    private final DisplayInfosRepository displayInfosRepository;
    private final CommentsRepository commentsRepository;

    public ListPageResponse<DisplayInfoDto> getDisplayInfos() {
        List<DisplayInfoDto> displayInfos = displayInfosRepository.selectDisplayInfos(PRODUCT_IMAGE_TYPE_MA);
        return ListPageResponse.<DisplayInfoDto>builder()
                .totalCount(displayInfos.size())
                .itemCount(displayInfos.size())
                .items(displayInfos)
                .build();
    }

    public ListPageResponse<DisplayInfoDto> getDisplayInfos(long categoryId) {
        List<DisplayInfoDto> displayInfos = displayInfosRepository.selectDisplayInfos(PRODUCT_IMAGE_TYPE_MA, categoryId);
        return ListPageResponse.<DisplayInfoDto>builder()
                .totalCount(displayInfosRepository.selectDisplayInfos(PRODUCT_IMAGE_TYPE_MA).size())
                .itemCount(displayInfos.size())
                .items(displayInfos)
                .build();
    }

    public ListPageResponse<DisplayInfoDto> getDisplayInfos(long categoryId, long pageSize, long pageNo) {
        return ListPageResponse.<DisplayInfoDto>builder()
                .totalCount(displayInfosRepository.selectDisplayInfos(PRODUCT_IMAGE_TYPE_MA, categoryId).size())
                .itemCount(pageSize)
                .items(displayInfosRepository.selectDisplayInfos(PRODUCT_IMAGE_TYPE_MA, categoryId, pageSize, pageNo))
                .build();
    }

    public DetailResponse getDisplayInfo(long displayInfoId) {
        DisplayInfoDto product = displayInfosRepository.selectDisplayInfo(PRODUCT_IMAGE_TYPE_MA, displayInfoId);
        return DetailResponse.builder()
                .product(product)
                .productImages(displayInfosRepository.selectProductImages(product.getId(), PRODUCT_IMAGE_TYPE_MA))
                .displayInfoImages(displayInfosRepository.selectDisplayInfoImages(product.getId()))
                .avgScore(commentsRepository.selectCommentsAvg(product.getId()))
                .productPrices(displayInfosRepository.selectProductPrices(product.getId()))
                .build();
    }
}
