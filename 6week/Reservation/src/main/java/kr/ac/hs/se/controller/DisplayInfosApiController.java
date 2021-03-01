package kr.ac.hs.se.controller;

import kr.ac.hs.se.model.Dto.DisplayInfoDto;
import kr.ac.hs.se.model.response.DetailResponse;
import kr.ac.hs.se.model.response.ListAllResponse;
import kr.ac.hs.se.model.response.ListPageResponse;
import kr.ac.hs.se.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/displayinfos")
public class DisplayInfosApiController {

    private final DisplayInfoService displayInfoService;

    @GetMapping
    public ListAllResponse<DisplayInfoDto> getDisplayInfos() {
        return displayInfoService.getDisplayInfos();
    }

    @GetMapping("/category/{categoryId}")
    public ListPageResponse<DisplayInfoDto> getDisplayInfos(@PathVariable(name = "categoryId") long categoryId,
                                                            @RequestParam(name = "pagesize", required = false, defaultValue = "-1") long pageSize,
                                                            @RequestParam(name = "pageno", required = false, defaultValue = "-1") long pageNo) {
        if (pageSize == -1 || pageNo == -1) {
            return displayInfoService.getDisplayInfos(categoryId);
        } else {
            return displayInfoService.getDisplayInfos(categoryId, pageSize, pageNo);
        }
    }

    @GetMapping("/displayinfo/{productId}")
    public DetailResponse getDisplayInfo(@PathVariable(name = "productId") long productId) {
        return displayInfoService.getDisplayInfo(productId);
    }
}
