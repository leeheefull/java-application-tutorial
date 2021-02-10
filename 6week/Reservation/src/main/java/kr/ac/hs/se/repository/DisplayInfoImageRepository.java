package kr.ac.hs.se.repository;

import kr.ac.hs.se.model.DisplayInfoImageDto;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static kr.ac.hs.se.sql.DisplayInfoImageSql.*;

@Repository
public class DisplayInfoImageRepository {

    private final NamedParameterJdbcTemplate jdbc;
    private final BeanPropertyRowMapper<DisplayInfoImageDto> displayInfoImageRowMapper = BeanPropertyRowMapper.newInstance(DisplayInfoImageDto.class);

    public DisplayInfoImageRepository(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<DisplayInfoImageDto> selectByProductId(long productId) {
        Map<String, ?> params = Collections.singletonMap("product_image_id", productId);
        return jdbc.query(SELECT_DISPLAY_INFO_IMAGE_BY_PRODUCT_ID, params, displayInfoImageRowMapper);
    }
}
