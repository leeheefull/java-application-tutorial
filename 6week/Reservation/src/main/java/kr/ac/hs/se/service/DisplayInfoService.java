package kr.ac.hs.se.service;

import kr.ac.hs.se.model.*;

import java.util.List;

public interface DisplayInfoService {

    DisplayInfoDto getProduct(String productImageType, long displayInfoId);

    long getProductsSize(long categoryId);

    List<DisplayInfoDto> getProducts(String productImageType, long categoryId, long start);

    List<ProductImageDto> getProductImages(long productId, String productImageType);

    List<DisplayInfoImageDto> getDisplayInfoImages(long productId);

    List<ProductPriceDto> getProductPrices(long productId);

    long getReservationUserCommentsSize(long productId);

    List<ReservationUserCommentDto> getReservationUserComments(long start, long productId);

    int getReservationUserCommentAvg(long productId);
}
