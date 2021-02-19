package kr.ac.hs.se.response;

import kr.ac.hs.se.model.CategoryDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class CategoriesResponse {
    private final long size;
    private final List<CategoryDto> items;
}
