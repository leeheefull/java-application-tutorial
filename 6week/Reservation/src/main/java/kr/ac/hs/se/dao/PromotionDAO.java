package kr.ac.hs.se.dao;

import kr.ac.hs.se.dto.PromotionDTO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

@Repository
public class PromotionDAO {

    private final NamedParameterJdbcTemplate jdbc;
    private final BeanPropertyRowMapper<PromotionDTO> promotionDTORowMapper = BeanPropertyRowMapper.newInstance(PromotionDTO.class);

    public PromotionDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public long getPromotionDTOSize() {
        StringBuilder sql = new StringBuilder();

        sql.append("select count(*)\n");
        sql.append("from promotion pm, product pd, category c, product_image pi\n");
        sql.append("where pm.product_id = pd.id and pd.category_id = c.id and pd.id = pi.product_id and pi.type = 'ma'");

        return jdbc.queryForObject(sql.toString(), Collections.emptyMap(), Long.class);
    }

    public List<PromotionDTO> selectPromotionDTO() {
        StringBuilder sql = new StringBuilder();

        sql.append("select pm.id, pd.id product_id, c.id, c.name, pd.description, pi.file_id\n");
        sql.append("from promotion pm, product pd, category c, product_image pi\n");
        sql.append("where pm.product_id = pd.id and pd.category_id = c.id and pd.id = pi.product_id and pi.type = 'ma'");

        return jdbc.query(sql.toString(), Collections.emptyMap(), promotionDTORowMapper);
    }
}
