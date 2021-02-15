package kr.ac.hs.se.controller;

import kr.ac.hs.se.model.DisplayInfoDto;
import kr.ac.hs.se.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/displayinfos")
public class DisplayInfosApiController {

    private final DisplayInfoService displayInfoService;

    @Autowired
    public DisplayInfosApiController(DisplayInfoService displayInfoService) {
        this.displayInfoService = displayInfoService;
    }

    @GetMapping
    public Map<String, Object> getDisplayInfos(@RequestParam(name = "productImageType", required = false, defaultValue = "ma") String productImageType,
                                               @RequestParam(name = "categoryId", required = false, defaultValue = "3") long categoryId,
                                               @RequestParam(name = "start", required = false, defaultValue = "0") long start) {
        Map<String, Object> map = new HashMap<>();
        map.put("totalCount", displayInfoService.getProductsSize(categoryId));
        map.put("productCount", 4);
        map.put("products", displayInfoService.getProducts(productImageType, categoryId, start));
        return map;
    }

    @GetMapping("/{displayInfoId}")
    public Map<String, Object> getDisplayInfo(@RequestParam(name = "productImageType", required = false, defaultValue = "ma") String productImageType,
                                              @PathVariable(name = "displayInfoId") long displayInfoId) {
        Map<String, Object> map = new HashMap<>();
        DisplayInfoDto product = displayInfoService.getProduct(productImageType, displayInfoId);

        map.put("product", product);
        map.put("productImages", displayInfoService.getProductImages(product.getId(), productImageType));
        map.put("displayInfoImages", displayInfoService.getDisplayInfoImages(product.getId()));
        map.put("avgScore", displayInfoService.getReservationUserCommentAvg(product.getId()));
        map.put("productPrices", displayInfoService.getProductPrices(product.getId()));
        return map;
    }

    @GetMapping("/comments")
    public Map<String, Object> getReservationUserComments(@RequestParam(name = "productId", required = false, defaultValue = "1") long productId,
                                                          @RequestParam(name = "start", required = false, defaultValue = "0") long start) {
        Map<String, Object> map = new HashMap<>();
        map.put("totalCount", displayInfoService.getReservationUserCommentsSize(productId));
        map.put("commentCount", 5);
        map.put("reservationUserComments", displayInfoService.getReservationUserComments(start, productId));
        return map;
    }
}
