package kr.ac.hs.se.repository;

import kr.ac.hs.se.model.ProductImageDto;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
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

    public List<ProductImageDto> selectByProductId(long productId) {
        Map<String, ?> params = Collections.singletonMap("product_id", productId);
        return jdbc.query(SELECT_PRODUCT_IMAGE_BY_PRODUCT_ID, params, productImageRowMapper);
    }
}
