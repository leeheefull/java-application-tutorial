package kr.ac.hs.se.controller;

import kr.ac.hs.se.response.PromotionResponse;
import kr.ac.hs.se.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/promotions")
public class PromotionsApiController {

    private final PromotionsService promotionService;

    @GetMapping
    public PromotionResponse getPromotions() {
        return promotionService.getPromotionsByProductImageTypeInMa();
    }
}
