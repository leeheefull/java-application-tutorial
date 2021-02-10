package kr.ac.hs.se.repository;

import kr.ac.hs.se.model.ReservationUserCommentDto;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
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

    public long getCount() {
        return jdbc.queryForObject(COUNT_RESERVATION_USER_COMMENTS, Collections.emptyMap(), long.class);
    }

    public int getAvgByProductId(long productId) {
        Map<String, ?> params = Collections.singletonMap("product_id", productId);
        return jdbc.queryForObject(AVG_RESERVATION_USER_COMMENT_SCORE_BY_PRODUCT_ID, params, int.class);
    }

    public List<ReservationUserCommentDto> select(long commentCount) {
        Map<String, ?> params = Collections.singletonMap("comment_count", commentCount);
        return jdbc.query(SELECT_RESERVATION_USER_COMMENTS, params, reservationUserCommentRowMapper);
    }
}
