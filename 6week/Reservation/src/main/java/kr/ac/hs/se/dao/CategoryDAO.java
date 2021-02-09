package kr.ac.hs.se.dao;

import kr.ac.hs.se.dto.CategoryDTO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

@Repository
public class CategoryDAO {

    private final NamedParameterJdbcTemplate jdbc;
    private final RowMapper<CategoryDTO> categoryDTORowMapper = BeanPropertyRowMapper.newInstance(CategoryDTO.class);

    public CategoryDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public Long getCategoriesSize() {
        StringBuilder sql = new StringBuilder("select count(*) from category");
        return jdbc.queryForObject(sql.toString(), Collections.emptyMap(), Long.class);
    }

    public List<CategoryDTO> selectCategoryDTO() {
        StringBuilder sql = new StringBuilder();

        sql.append("select c.id, c.name, (select count(*) from display_info d, product p where p.id = d.product_id and p.category_id = c.id) as count\n");
        sql.append("from category c");

        return jdbc.query(sql.toString(), Collections.emptyMap(), categoryDTORowMapper);
    }
}
