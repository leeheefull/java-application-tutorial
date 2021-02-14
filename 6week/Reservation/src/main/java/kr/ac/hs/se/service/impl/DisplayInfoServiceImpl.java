package kr.ac.hs.se.service.impl;

import kr.ac.hs.se.model.DisplayInfoImageDto;
import kr.ac.hs.se.model.ProductDto;
import kr.ac.hs.se.model.ProductImageDto;
import kr.ac.hs.se.model.ProductPriceDto;
import kr.ac.hs.se.repository.*;
import kr.ac.hs.se.service.DisplayInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DisplayInfoServiceImpl implements DisplayInfoService {

    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;
    private final DisplayInfoImageRepository displayInfoImageRepository;
    private final ProductPriceRepository productPriceRepository;
    private final ReservationUserCommentRepository reservationUserCommentRepository;

    @Autowired
    public DisplayInfoServiceImpl(ProductRepository productRepository, ProductImageRepository productImageRepository, DisplayInfoImageRepository displayInfoImageRepository, ProductPriceRepository productPriceRepository, ReservationUserCommentRepository reservationUserCommentRepository) {
        this.productRepository = productRepository;
        this.productImageRepository = productImageRepository;
        this.displayInfoImageRepository = displayInfoImageRepository;
        this.productPriceRepository = productPriceRepository;
        this.reservationUserCommentRepository = reservationUserCommentRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDto getProduct(String productImageType, long displayInfoId) {
        return productRepository.select(productImageType, displayInfoId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductImageDto> getProductImages(long productId) {
        return productImageRepository.select(productId);
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
    public int getReservationUserCommentAvg(long productId) {
        return reservationUserCommentRepository.average(productId);
    }
}
