package kr.ac.hs.se.controller;

import kr.ac.hs.se.response.DisplayInfoDetailResponse;
import kr.ac.hs.se.response.DisplayInfosResponse;
import kr.ac.hs.se.response.ReservationUserCommentsResponse;
import kr.ac.hs.se.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/displayinfos")
public class DisplayInfosApiController {

    private final DisplayInfoService displayInfoService;

    @GetMapping
    public DisplayInfosResponse getDisplayInfos() {
        return displayInfoService.getDisplayInfosByProductImageTypeInMa();
    }

    @GetMapping("/category/{categoryId}")
    public DisplayInfosResponse getDisplayInfos(@PathVariable(name = "categoryId", required = false) long categoryId) {
        return displayInfoService.getDisplayInfosByProductImageTypeInMa(categoryId);
    }

    @GetMapping("/category/{categoryId}/page/{pageSize},{page}")
    public DisplayInfosResponse getDisplayInfos(@PathVariable(name = "categoryId", required = false) long categoryId,
                                                @PathVariable(name = "pageSize", required = false) long pageSize,
                                                @PathVariable(name = "page", required = false) long page) {
        return displayInfoService.getDisplayInfosByProductImageTypeInMa(categoryId, pageSize, page);
    }

    @GetMapping("/displayinfo/{displayInfoId}")
    public DisplayInfoDetailResponse getDisplayInfo(@PathVariable(name = "displayInfoId") long displayInfoId) {
        return displayInfoService.getDisplayInfoByProductImageTypeInMa(displayInfoId);
    }

    @GetMapping("/comments")
    public ReservationUserCommentsResponse getReservationUserComments() {
        return displayInfoService.getReservationUserComments();
    }

    @GetMapping("/comments/product/{productId}")
    public ReservationUserCommentsResponse getReservationUserComments(@PathVariable(name = "productId") long productId) {
        return displayInfoService.getReservationUserComments(productId);
    }

    @GetMapping("/comments/product/{productId}/page/{pageSize},{page}")
    public ReservationUserCommentsResponse getReservationUserComments(@PathVariable(name = "productId") long productId,
                                                                      @PathVariable(name = "pageSize") long pageSize,
                                                                      @PathVariable(name = "page") long page) {
        return displayInfoService.getReservationUserComments(productId, pageSize, page);
    }
}
