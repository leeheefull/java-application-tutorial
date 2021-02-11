package kr.ac.hs.se.repository;

import kr.ac.hs.se.model.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

import static kr.ac.hs.se.sql.CategorySql.*;

@Repository
public class CategoryRepository {

    private final NamedParameterJdbcTemplate jdbc;
    private final RowMapper<CategoryDto> categoryRowMapper = BeanPropertyRowMapper.newInstance(CategoryDto.class);

    @Autowired
    public CategoryRepository(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public Long count() {
        return jdbc.queryForObject(COUNT_CATEGORIES, Collections.emptyMap(), Long.class);
    }

    public List<CategoryDto> selectAll() {
        return jdbc.query(SELECT_CATEGORIES, Collections.emptyMap(), categoryRowMapper);
    }
}
