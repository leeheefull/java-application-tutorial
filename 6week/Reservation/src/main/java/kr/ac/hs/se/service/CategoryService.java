package kr.ac.hs.se.service;

import kr.ac.hs.se.model.CategoryDto;

import java.util.List;

public interface CategoryService {

    long getCategoriesSize();

    List<CategoryDto> getCategories();
}