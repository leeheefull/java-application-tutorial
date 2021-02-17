package kr.ac.hs.se.service.impl;

import kr.ac.hs.se.repository.PromotionsRepository;
import kr.ac.hs.se.response.PromotionResponse;
import kr.ac.hs.se.service.PromotionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PromotionsServiceImpl implements PromotionsService {

    private final PromotionsRepository promotionsRepository;

    @Override
    public PromotionResponse getPromotionsByProductImageTypeInMa() {
        return new PromotionResponse(promotionsRepository.selectPromotions("ma").size(),
                promotionsRepository.selectPromotions("ma"));
    }
}

