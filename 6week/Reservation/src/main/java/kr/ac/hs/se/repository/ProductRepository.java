package kr.ac.hs.se.repository;

import kr.ac.hs.se.model.ProductDto;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static kr.ac.hs.se.sql.ProductSql.*;

@Repository
public class ProductRepository {

    private final NamedParameterJdbcTemplate jdbc;
    private final BeanPropertyRowMapper<ProductDto> productRowMapper = BeanPropertyRowMapper.newInstance(ProductDto.class);

    public ProductRepository(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public long getCountByCategoryId(long categoryId) {
        Map<String, ?> params = Collections.singletonMap("category_id", categoryId);
        return jdbc.queryForObject(COUNT_PRODUCT_BY_CATEGORY_ID, params, long.class);
    }

    public List<ProductDto> selectByCategoryId(String productImageType, long categoryId, long productCount) {
        Map<String, Object> params = new HashMap<>();
        params.put("product_image_type", productImageType);
        params.put("category_id", categoryId);
        params.put("product_count", productCount);
        return jdbc.query(SELECT_PRODUCT_BY_CATEGORY_ID, params, productRowMapper);
    }

    public ProductDto selectByDisplayId(String productImageType, long displayInfoId) {
        Map<String, Object> params = new HashMap<>();
        params.put("product_image_type", productImageType);
        params.put("display_info_id", displayInfoId);
        return jdbc.queryForObject(SELECT_PRODUCT_BY_DISPLAY_ID, params, productRowMapper);
    }
}
