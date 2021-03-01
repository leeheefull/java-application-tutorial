package kr.ac.hs.se.repository;

import kr.ac.hs.se.model.Dto.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

import static kr.ac.hs.se.sql.CategoriesSql.*;

@RequiredArgsConstructor
@Repository
public class CategoriesRepository {

    private final NamedParameterJdbcTemplate jdbc;

    public List<CategoryDto> selectCategories() {
        return jdbc.query(SELECT_CATEGORIES,
                Collections.emptyMap(),
                BeanPropertyRowMapper.newInstance(CategoryDto.class));
    }
}
