package kr.ac.hs.se.response;

import kr.ac.hs.se.model.DisplayInfoDto;
import kr.ac.hs.se.model.DisplayInfoImageDto;
import kr.ac.hs.se.model.ProductImageDto;
import kr.ac.hs.se.model.ProductPriceDto;
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
