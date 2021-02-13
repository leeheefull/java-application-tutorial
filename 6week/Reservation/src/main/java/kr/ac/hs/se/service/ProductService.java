package kr.ac.hs.se.service;

import kr.ac.hs.se.model.ProductDto;
import kr.ac.hs.se.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public long getProductsSize(long categoryId) {
        return productRepository.count(categoryId);
    }

    @Transactional(readOnly = true)
    public List<ProductDto> getProducts(String productImageType, long categoryId, long productCount) {
        return productRepository.select(productImageType, categoryId, productCount);
    }
}