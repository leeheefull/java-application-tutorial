package kr.ac.hs.se.service;

import kr.ac.hs.se.model.DisplayInfoImageDto;
import kr.ac.hs.se.model.ProductDto;
import kr.ac.hs.se.model.ProductImageDto;
import kr.ac.hs.se.model.ProductPriceDto;

import java.util.List;

public interface DisplayInfoService {

    ProductDto getProduct(String productImageType, long displayInfoId);

    List<ProductImageDto> getProductImages(long productId);

    List<DisplayInfoImageDto> getDisplayInfoImages(long productId);

    List<ProductPriceDto> getProductPrices(long productId);

    int getReservationUserCommentAvg(long productId);
}
