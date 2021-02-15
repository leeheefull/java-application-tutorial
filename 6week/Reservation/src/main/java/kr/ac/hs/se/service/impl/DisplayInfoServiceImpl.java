package kr.ac.hs.se.service.impl;

import kr.ac.hs.se.model.*;
import kr.ac.hs.se.repository.*;
import kr.ac.hs.se.service.DisplayInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DisplayInfoServiceImpl implements DisplayInfoService {

    private final DisplayInfoRepository displayInfoRepository;
    private final ProductImageRepository productImageRepository;
    private final DisplayInfoImageRepository displayInfoImageRepository;
    private final ProductPriceRepository productPriceRepository;
    private final ReservationUserCommentRepository reservationUserCommentRepository;

    @Autowired
    public DisplayInfoServiceImpl(DisplayInfoRepository displayInfoRepository,
                                  ProductImageRepository productImageRepository,
                                  DisplayInfoImageRepository displayInfoImageRepository,
                                  ProductPriceRepository productPriceRepository,
                                  ReservationUserCommentRepository reservationUserCommentRepository) {
        this.displayInfoRepository = displayInfoRepository;
        this.productImageRepository = productImageRepository;
        this.displayInfoImageRepository = displayInfoImageRepository;
        this.productPriceRepository = productPriceRepository;
        this.reservationUserCommentRepository = reservationUserCommentRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public DisplayInfoDto getProduct(String productImageType, long displayInfoId) {
        return displayInfoRepository.select(productImageType, displayInfoId);
    }

    @Override
    public long getProductsSize(long categoryId) {
        return displayInfoRepository.count(categoryId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DisplayInfoDto> getProducts(String productImageType, long categoryId, long start) {
        return displayInfoRepository.select(productImageType, categoryId, start);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductImageDto> getProductImages(long productId, String productImageType) {
        return productImageRepository.select(productId, productImageType);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DisplayInfoImageDto> getDisplayInfoImages(long productId) {
        return displayInfoImageRepository.select(productId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductPriceDto> getProductPrices(long productId) {
        return productPriceRepository.select(productId);
    }

    @Override
    public long getReservationUserCommentsSize(long productId) {
        return reservationUserCommentRepository.count(productId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReservationUserCommentDto> getReservationUserComments(long start, long productId) {
        return reservationUserCommentRepository.select(start, productId);
    }

    @Override
    public int getReservationUserCommentAvg(long productId) {
        return reservationUserCommentRepository.average(productId);
    }
}
