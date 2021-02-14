package kr.ac.hs.se.service.impl;

import kr.ac.hs.se.model.CategoryDto;
import kr.ac.hs.se.repository.CategoryRepository;
import kr.ac.hs.se.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public long getCategoriesSize() {
        return categoryRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryDto> getCategories() {
        return categoryRepository.selectAll();
    }
}
