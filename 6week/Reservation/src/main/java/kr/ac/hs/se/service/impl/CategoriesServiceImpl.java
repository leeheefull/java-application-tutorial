package kr.ac.hs.se.service.impl;

import kr.ac.hs.se.repository.CategoriesRepository;
import kr.ac.hs.se.response.CategoriesResponse;
import kr.ac.hs.se.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoriesServiceImpl implements CategoriesService {

    private final CategoriesRepository categoriesRepository;

    @Override
    public CategoriesResponse getCategories() {
        return new CategoriesResponse(categoriesRepository.selectCategories().size(), categoriesRepository.selectCategories());
    }
}
