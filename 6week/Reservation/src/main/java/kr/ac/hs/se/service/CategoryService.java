package kr.ac.hs.se.service;

import kr.ac.hs.se.model.CategoryDto;
import kr.ac.hs.se.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public long getCategoriesSize() {
        return categoryRepository.count();
    }

    public List<CategoryDto> getCategories() {
        return categoryRepository.selectAll();
    }
}