package kr.ac.hs.se.service.impl;

import kr.ac.hs.se.model.PromotionDto;
import kr.ac.hs.se.repository.PromotionRepository;
import kr.ac.hs.se.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService {

    private final PromotionRepository promotionRepository;

    @Autowired
    public PromotionServiceImpl(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @Override
    public long getPromotionsSize(String productImageType) {
        return promotionRepository.count(productImageType);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PromotionDto> getPromotions(String productImageType) {
        return promotionRepository.select(productImageType);
    }
}

