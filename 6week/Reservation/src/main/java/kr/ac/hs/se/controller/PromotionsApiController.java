package kr.ac.hs.se.controller;

import kr.ac.hs.se.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/promotions")
public class PromotionsApiController {

    private final PromotionService promotionService;

    @Autowired
    public PromotionsApiController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @GetMapping
    public Map<String, Object> getPromotions() {
        Map<String, Object> map = new HashMap<>();
        String productImageType = "ma";
        map.put("size", promotionService.getPromotionsSize(productImageType));
        map.put("items", promotionService.getPromotions(productImageType));
        return map;
    }
}
