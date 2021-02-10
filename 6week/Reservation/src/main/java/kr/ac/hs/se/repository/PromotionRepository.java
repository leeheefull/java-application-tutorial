package kr.ac.hs.se.repository;

import kr.ac.hs.se.model.PromotionDto;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static kr.ac.hs.se.sql.PromotionSql.*;

@Repository
public class PromotionRepository {

    private final NamedParameterJdbcTemplate jdbc;
    private final BeanPropertyRowMapper<PromotionDto> promotionRowMapper = BeanPropertyRowMapper.newInstance(PromotionDto.class);

    public PromotionRepository(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public long getCountByProductImageType(String productImageType) {
        Map<String, ?> params = Collections.singletonMap("product_image_type", productImageType);
        return jdbc.queryForObject(COUNT_PROMOTIONS_BY_PRODUCT_IMAGE_TYPE, params, Long.class);
    }

    public List<PromotionDto> selectByProductImageType(String productImageType) {
        Map<String, ?> params = Collections.singletonMap("product_image_type", productImageType);
        return jdbc.query(SELECT_PROMOTIONS_BY_PRODUCT_IMAGE_TYPE, params, promotionRowMapper);
    }
}
