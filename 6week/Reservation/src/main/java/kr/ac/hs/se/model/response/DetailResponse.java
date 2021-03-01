package kr.ac.hs.se.model.response;

import kr.ac.hs.se.model.Dto.DisplayInfoDto;
import kr.ac.hs.se.model.Dto.DisplayInfoImageDto;
import kr.ac.hs.se.model.Dto.ProductImageDto;
import kr.ac.hs.se.model.Dto.ProductPriceDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class DetailResponse {

    private final DisplayInfoDto product;
    private final List<ProductImageDto> productImages;
    private final List<DisplayInfoImageDto> displayInfoImages;
    private final int avgScore;
    private final List<ProductPriceDto> productPrices;
}
