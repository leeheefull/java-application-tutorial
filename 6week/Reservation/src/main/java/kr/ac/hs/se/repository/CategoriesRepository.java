package kr.ac.hs.se.repository;

import kr.ac.hs.se.model.CategoryDto;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

import static kr.ac.hs.se.sql.CategoriesSql.*;

@Repository
public class CategoriesRepository {

    private final NamedParameterJdbcTemplate jdbc;

    public CategoriesRepository(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<CategoryDto> selectCategories() {
        return jdbc.query(SELECT_CATEGORIES,
                Collections.emptyMap(),
                BeanPropertyRowMapper.newInstance(CategoryDto.class));
    }
}
