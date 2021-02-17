package kr.ac.hs.se.controller;

import kr.ac.hs.se.response.DisplayInfoDetailResponse;
import kr.ac.hs.se.response.DisplayInfosResponse;
import kr.ac.hs.se.response.ReservationUserCommentResponse;
import kr.ac.hs.se.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/displayinfos")
public class DisplayInfosApiController {

    private final DisplayInfoService displayInfoService;

    @GetMapping("/{categoryId}/{pageSize}/{page}")
    public DisplayInfosResponse getDisplayInfos(@PathVariable(name = "categoryId") long categoryId,
                                                @PathVariable(name = "pageSize") long pageSize,
                                                @PathVariable(name = "page") long page) {
        return displayInfoService.getDisplayInfosByProductImageTypeInMa(categoryId, pageSize, page);
    }

    @GetMapping("/{displayInfoId}")
    public DisplayInfoDetailResponse getDisplayInfo(@PathVariable(name = "displayInfoId") long displayInfoId) {
        return displayInfoService.getDisplayInfo(displayInfoId);
    }

    @GetMapping("/comments/{productId}/{pageSize}/{page}")
    public ReservationUserCommentResponse getReservationUserComments(@PathVariable(name = "productId") long productId,
                                                                     @PathVariable(name = "pageSize") long pageSize,
                                                                     @PathVariable(name = "page") long page) {
        return displayInfoService.getReservationUserCommentsByProductImageTypeInMa(productId, pageSize, page);
    }
}
