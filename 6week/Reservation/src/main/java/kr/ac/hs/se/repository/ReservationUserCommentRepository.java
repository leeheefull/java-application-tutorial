package kr.ac.hs.se.repository;

import kr.ac.hs.se.model.ReservationUserCommentDto;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static kr.ac.hs.se.sql.ReservationUserCommentSql.*;

@Repository
public class ReservationUserCommentRepository {

    private final NamedParameterJdbcTemplate jdbc;
    private final BeanPropertyRowMapper<ReservationUserCommentDto> reservationUserCommentRowMapper = BeanPropertyRowMapper.newInstance(ReservationUserCommentDto.class);

    public ReservationUserCommentRepository(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public long count(long productId) {
        Map<String, ?> params = Collections.singletonMap("product_id", productId);
        return jdbc.queryForObject(COUNT_RESERVATION_USER_COMMENTS, params, long.class);
    }

    public int average(long productId) {
        Map<String, ?> params = Collections.singletonMap("product_id", productId);
        return jdbc.queryForObject(AVG_RESERVATION_USER_COMMENT_SCORE_BY_PRODUCT_ID, params, int.class);
    }

    public List<ReservationUserCommentDto> select(long start, long productId) {
        Map<String, Long> params = new HashMap<>();
        params.put("start", start);
        params.put("product_id", productId);
        return jdbc.query(SELECT_RESERVATION_USER_COMMENTS, params, reservationUserCommentRowMapper);
    }
}
