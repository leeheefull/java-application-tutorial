package kr.ac.hs.se.dao;

import kr.ac.hs.se.dto.ProductPriceDTO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class ProductPriceDAO {

    private final NamedParameterJdbcTemplate jdbc;
    private final BeanPropertyRowMapper<ProductPriceDTO> productPriceDTORowMapper = BeanPropertyRowMapper.newInstance(ProductPriceDTO.class);

    public ProductPriceDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<ProductPriceDTO> selectProductPriceDTOByProductId(long productId) {
        Map<String, ?> params = Collections.singletonMap("product_id", productId);
        StringBuilder sql = new StringBuilder();

        sql.append("select pp.id, p.id product_id, pp.price_type_name, pp.price, pp.discount_rate, pp.create_date, pp.modify_date\n");
        sql.append("from product p, product_price pp\n");
        sql.append("where p.id = pp.product_id and p.id = :product_id\n");
        sql.append("order by pp.id desc");

        return jdbc.query(sql.toString(), params, productPriceDTORowMapper);
    }
}
