package kr.ac.hs.se.service;

import kr.ac.hs.se.model.PromotionDto;

import java.util.List;

public interface PromotionService {

    long getPromotionsSize(String productImageType);

    List<PromotionDto> getPromotions(String productImageType);
}
