package kr.ac.hs.se.repository;

import kr.ac.hs.se.model.DisplayInfoDto;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static kr.ac.hs.se.sql.DisplayInfoSql.*;

@Repository
public class DisplayInfoRepository {

    private final NamedParameterJdbcTemplate jdbc;
    private final BeanPropertyRowMapper<DisplayInfoDto> productRowMapper = BeanPropertyRowMapper.newInstance(DisplayInfoDto.class);

    public DisplayInfoRepository(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public long count(long categoryId) {
        Map<String, ?> params = Collections.singletonMap("category_id", categoryId);
        return jdbc.queryForObject(COUNT_DISPLAY_INFO_BY_CATEGORY_ID, params, long.class);
    }

    public List<DisplayInfoDto> select(String productImageType, long categoryId, long start) {
        Map<String, Object> params = new HashMap<>();
        params.put("product_image_type", productImageType);
        params.put("category_id", categoryId);
        params.put("start", start);
        return jdbc.query(SELECT_DISPLAY_INFO_BY_CATEGORY_ID, params, productRowMapper);
    }

    public DisplayInfoDto select(String productImageType, long displayInfoId) {
        Map<String, Object> params = new HashMap<>();
        params.put("product_image_type", productImageType);
        params.put("display_info_id", displayInfoId);
        return jdbc.queryForObject(SELECT_DISPLAY_INFO_BY_DISPLAY_ID, params, productRowMapper);
    }
}
