package kr.ac.hs.se.service;

import kr.ac.hs.se.model.ProductDto;

import java.util.List;

public interface ProductService {

    long getProductsSize(long categoryId);

    List<ProductDto> getProducts(String productImageType, long categoryId, long productCount);
}