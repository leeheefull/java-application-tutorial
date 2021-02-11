package kr.ac.hs.se.service;

import kr.ac.hs.se.model.PromotionDto;
import kr.ac.hs.se.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionService {

    private final PromotionRepository promotionRepository;

    @Autowired
    public PromotionService(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    public long getPromotionsSize(String productImageType) {
        return promotionRepository.count(productImageType);
    }

    public List<PromotionDto> getPromotions(String productImageType) {
        return promotionRepository.select(productImageType);
    }
}
