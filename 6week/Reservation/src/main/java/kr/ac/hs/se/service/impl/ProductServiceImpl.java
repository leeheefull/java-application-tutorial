package kr.ac.hs.se.service.impl;

import kr.ac.hs.se.model.ProductDto;
import kr.ac.hs.se.repository.ProductRepository;
import kr.ac.hs.se.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public long getProductsSize(long categoryId) {
        return productRepository.count(categoryId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDto> getProducts(String productImageType, long categoryId, long productCount) {
        return productRepository.select(productImageType, categoryId, productCount);
    }
}
