package kr.ac.hs.se.repository;

import kr.ac.hs.se.model.Dto.PromotionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

import static kr.ac.hs.se.sql.PromotionsSql.*;

@RequiredArgsConstructor
@Repository
public class PromotionsRepository {

    private final NamedParameterJdbcTemplate jdbc;

    public List<PromotionDto> selectPromotions(String productImageType) {
        return jdbc.query(SELECT_PROMOTIONS_BY_PRODUCT_IMAGE_TYPE,
                Collections.singletonMap("productImageType", productImageType),
                BeanPropertyRowMapper.newInstance(PromotionDto.class));
    }
}
