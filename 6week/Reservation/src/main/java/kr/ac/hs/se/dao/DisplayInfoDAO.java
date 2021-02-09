package kr.ac.hs.se.dao;

import kr.ac.hs.se.dto.DisplayInfoDTO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class DisplayInfoDAO {

    private final NamedParameterJdbcTemplate jdbc;
    private final BeanPropertyRowMapper<DisplayInfoDTO> displayInfoDTORowMapper = BeanPropertyRowMapper.newInstance(DisplayInfoDTO.class);

    public DisplayInfoDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public long getDisplayInfoCountByCategoryId(long categoryId) {
        Map<String, ?> params = Collections.singletonMap("category_id", categoryId);
        StringBuilder sql = new StringBuilder();

        sql.append("select count(*) from product, display_info\n");
        sql.append("where product.id = display_info.product_id and product.category_id = :category_id");

        return jdbc.queryForObject(sql.toString(), params, long.class);
    }

    public List<DisplayInfoDTO> selectDisplayInfoDTOByCategoryId(long categoryId, long displayInfoCount) {
        Map<String, ?> params = Collections.singletonMap("category_id", categoryId);
        StringBuilder sql = new StringBuilder();

        sql.append("select p.id, p.category_id, d.id display_id, c.name, p.description, p.content, p.event, d.opening_hours, d.place_name, d.place_lot, d.place_street, d.tel, d.homepage, d.email, d.create_date, d.modify_date, pi.file_id\n");
        sql.append("from display_info d , product p, category c, product_image pi\n");
        sql.append("where p.id = d.product_id and p.id = pi.product_id and pi.type = 'ma' and p.category_id = c.id and c.id = :category_id\n");
        sql.append("limit ").append(displayInfoCount);

        return jdbc.query(sql.toString(), params, displayInfoDTORowMapper);
    }

    public DisplayInfoDTO selectDisplayInfoDTOByDisplayId(long displayId) {
        Map<String, ?> params = Collections.singletonMap("display_id", displayId);
        StringBuilder sql = new StringBuilder();

        sql.append("select p.id, p.category_id, d.id display_id, c.name, p.description, p.content, p.event, d.opening_hours, d.place_name, d.place_lot, d.place_street, d.tel, d.homepage, d.email, d.create_date, d.modify_date, pi.file_id\n");
        sql.append("from display_info d , product p, category c, product_image pi\n");
        sql.append("where p.id = d.product_id and p.id = pi.product_id and pi.type = 'ma' and p.category_id = c.id and d.id = :display_id");

        return jdbc.queryForObject(sql.toString(), params, displayInfoDTORowMapper);
    }


}
