package kr.ac.hs.se.service;

import kr.ac.hs.se.model.Dto.CategoryDto;
import kr.ac.hs.se.repository.CategoriesRepository;
import kr.ac.hs.se.model.response.ListAllResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoriesService {

    private final CategoriesRepository categoriesRepository;

    public ListAllResponse<CategoryDto> getCategories() {
        List<CategoryDto> categories = categoriesRepository.selectCategories();
        return new ListAllResponse<>(categories);
    }
}
