package kr.ac.hs.se.service;

import kr.ac.hs.se.model.PromotionDto;
import kr.ac.hs.se.repository.PromotionsRepository;
import kr.ac.hs.se.response.ListAllResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static kr.ac.hs.se.util.Type.PRODUCT_IMAGE_TYPE_MA;

@RequiredArgsConstructor
@Service
public class PromotionsService {

    private final PromotionsRepository promotionsRepository;

    public ListAllResponse<PromotionDto> getPromotionsByProductImageTypeInMa() {
        List<PromotionDto> promotions = promotionsRepository.selectPromotions(PRODUCT_IMAGE_TYPE_MA);
        return ListAllResponse.<PromotionDto>builder()
                .size(promotions.size())
                .items(promotions)
                .build();
    }
}

