package kr.ac.hs.se.repository;

import kr.ac.hs.se.model.ProductImageDto;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static kr.ac.hs.se.sql.ProductImageSql.*;

@Repository
public class ProductImageRepository {

    private final NamedParameterJdbcTemplate jdbc;
    private final BeanPropertyRowMapper<ProductImageDto> productImageRowMapper = BeanPropertyRowMapper.newInstance(ProductImageDto.class);

    public ProductImageRepository(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<ProductImageDto> select(long productId, String productImageType) {
        Map<String, Object> params = new HashMap<>();
        params.put("product_id", productId);
        params.put("product_image_type", productImageType);
        return jdbc.query(SELECT_PRODUCT_IMAGE_BY_PRODUCT_ID, params, productImageRowMapper);
    }
}
