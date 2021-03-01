package kr.ac.hs.se.controller;

import kr.ac.hs.se.model.Dto.PromotionDto;
import kr.ac.hs.se.model.response.ListAllResponse;
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
    public ListAllResponse<PromotionDto> getPromotions() {
        return promotionService.getPromotionsByProductImageTypeInMa();
    }
}
