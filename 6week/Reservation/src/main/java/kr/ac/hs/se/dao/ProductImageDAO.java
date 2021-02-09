package kr.ac.hs.se.dao;

import kr.ac.hs.se.dto.ProductImageDTO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.Map;

@Repository
public class ProductImageDAO {

    private final NamedParameterJdbcTemplate jdbc;
    private final BeanPropertyRowMapper<ProductImageDTO> productImageDTORowMapper = BeanPropertyRowMapper.newInstance(ProductImageDTO.class);

    public ProductImageDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public ProductImageDTO selectProductImageDTOByFileId(long fileId) {
        Map<String, ?> params = Collections.singletonMap("file_info_id", fileId);
        StringBuilder sql = new StringBuilder();

        sql.append("select p.id product_id, pi.id product_image_id, pi.type, pi.file_id file_info_id, fi.file_name, fi.save_file_name, fi.content_type, fi.delete_flag, fi.create_date, fi.modify_date\n");
        sql.append("from product p, product_image pi, file_info fi\n");
        sql.append("where p.id = pi.product_id and pi.file_id = fi.id and fi.id = :file_info_id");

        return jdbc.queryForObject(sql.toString(), params, productImageDTORowMapper);
    }
}
