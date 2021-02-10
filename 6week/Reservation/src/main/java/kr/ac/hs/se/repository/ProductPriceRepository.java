package kr.ac.hs.se.repository;

import kr.ac.hs.se.model.ProductPriceDto;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static kr.ac.hs.se.sql.ProductPriceSql.*;

@Repository
public class ProductPriceRepository {

    private final NamedParameterJdbcTemplate jdbc;
    private final BeanPropertyRowMapper<ProductPriceDto> productPriceRowMapper = BeanPropertyRowMapper.newInstance(ProductPriceDto.class);

    public ProductPriceRepository(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<ProductPriceDto> selectByProductId(long productId) {
        Map<String, ?> params = Collections.singletonMap("product_id", productId);
        return jdbc.query(SELECT_PRODUCT_PRICE_BY_PRODUCT_ID, params, productPriceRowMapper);
    }
}
