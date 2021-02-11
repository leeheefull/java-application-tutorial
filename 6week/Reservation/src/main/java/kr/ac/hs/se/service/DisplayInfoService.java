package kr.ac.hs.se.service;

import kr.ac.hs.se.model.DisplayInfoImageDto;
import kr.ac.hs.se.model.ProductDto;
import kr.ac.hs.se.model.ProductImageDto;
import kr.ac.hs.se.model.ProductPriceDto;
import kr.ac.hs.se.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisplayInfoService {

    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;
    private final DisplayInfoImageRepository displayInfoImageRepository;
    private final ProductPriceRepository productPriceRepository;
    private final ReservationUserCommentRepository reservationUserCommentRepository;

    @Autowired
    public DisplayInfoService(ProductRepository productRepository, ProductImageRepository productImageRepository, DisplayInfoImageRepository displayInfoImageRepository, ProductPriceRepository productPriceRepository, ReservationUserCommentRepository reservationUserCommentRepository) {
        this.productRepository = productRepository;
        this.productImageRepository = productImageRepository;
        this.displayInfoImageRepository = displayInfoImageRepository;
        this.productPriceRepository = productPriceRepository;
        this.reservationUserCommentRepository = reservationUserCommentRepository;
    }

    public ProductDto getProduct(String productImageType, long displayInfoId) {
        return productRepository.select(productImageType, displayInfoId);
    }

        public List<ProductImageDto> getProductImages(long productId) {
        return productImageRepository.select(productId);
    }

    public List<DisplayInfoImageDto> getDisplayInfoImages(long productId) {
        return displayInfoImageRepository.select(productId);
    }

    public List<ProductPriceDto> getProductPrices(long productId) {
        return productPriceRepository.select(productId);
    }

    public int getReservationUserCommentAvg(long productId) {
        return reservationUserCommentRepository.average(productId);
    }
}
