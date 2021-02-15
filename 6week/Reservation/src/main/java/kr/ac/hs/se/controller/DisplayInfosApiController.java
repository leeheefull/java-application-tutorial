package kr.ac.hs.se.controller;

import kr.ac.hs.se.model.ProductDto;
import kr.ac.hs.se.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/displayinfos")
public class DisplayInfosApiController {

    private final DisplayInfoService displayInfoService;
    private final ProductService productService;
    private final ReservationUserCommentService reservationUserCommentService;

    @Autowired
    public DisplayInfosApiController(DisplayInfoService displayInfoService,
                                     ProductService productService,
                                     ReservationUserCommentService reservationUserCommentService) {
        this.displayInfoService = displayInfoService;
        this.productService = productService;
        this.reservationUserCommentService = reservationUserCommentService;
    }

    @GetMapping
    public Map<String, Object> getDisplayInfos(@RequestParam(name = "productImageType", required = false, defaultValue = "ma") String productImageType,
                                               @RequestParam(name = "categoryId", required = false, defaultValue = "3") long categoryId,
                                               @RequestParam(name = "productCount", required = false, defaultValue = "4") long productCount) {
        Map<String, Object> map = new HashMap<>();
        map.put("totalCount", productService.getProductsSize(categoryId));
        map.put("productCount", productCount);
        map.put("products", productService.getProducts(productImageType, categoryId, productCount));
        return map;
    }

    @GetMapping("/{displayInfoId}")
    public Map<String, Object> getDisplayInfo(@RequestParam(name = "productImageType", required = false, defaultValue = "ma") String productImageType,
                                              @PathVariable(name = "displayInfoId") long displayInfoId) {
        Map<String, Object> map = new HashMap<>();
        ProductDto product = displayInfoService.getProduct(productImageType, displayInfoId);

        map.put("product", product);
        map.put("productImages", displayInfoService.getProductImages(product.getId()));
        map.put("displayInfoImages", displayInfoService.getDisplayInfoImages(product.getId()));
        map.put("avgScore", displayInfoService.getReservationUserCommentAvg(product.getId()));
        map.put("productPrices", displayInfoService.getProductPrices(product.getId()));
        return map;
    }

    @GetMapping("/comments")
    public Map<String, Object> getReservationUserComments(@RequestParam(name = "commentCount", required = false, defaultValue = "5") long commentCount) {
        Map<String, Object> map = new HashMap<>();
        map.put("totalCount", reservationUserCommentService.getReservationUserCommentsSize());
        map.put("commentCount", commentCount);
        map.put("reservationUserComments", reservationUserCommentService.getReservationUserComments(commentCount));
        return map;
    }
}
