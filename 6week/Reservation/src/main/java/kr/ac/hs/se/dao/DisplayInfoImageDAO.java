package kr.ac.hs.se.dao;

import kr.ac.hs.se.dto.DisplayInfoImageDTO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.Map;

@Repository
public class DisplayInfoImageDAO {

    private final NamedParameterJdbcTemplate jdbc;
    private final BeanPropertyRowMapper<DisplayInfoImageDTO> displayInfoImageDTORowMapper = BeanPropertyRowMapper.newInstance(DisplayInfoImageDTO.class);

    public DisplayInfoImageDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public DisplayInfoImageDTO selectDisplayInfoDTOByCategoryId(long displayInfoImageId) {
        Map<String, ?> params = Collections.singletonMap("product_image_id", displayInfoImageId);
        StringBuilder sql = new StringBuilder();

        sql.append("select dii.id, dii.display_info_id, dii.file_id, fi.file_name, fi.save_file_name, fi.content_type, fi.delete_flag, fi.create_date, fi.modify_date\n");
        sql.append("from display_info_image dii, file_info fi\n");
        sql.append("where dii.file_id = fi.id and dii.id = :product_image_id");

        return jdbc.queryForObject(sql.toString(), params, displayInfoImageDTORowMapper);
    }
}
