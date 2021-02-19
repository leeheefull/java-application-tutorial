package kr.ac.hs.se.response;

import kr.ac.hs.se.model.PromotionDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class PromotionsResponse {
    private final long size;
    private final List<PromotionDto> items;
}
