package kr.ac.hs.se.dao;

import kr.ac.hs.se.dto.ReservationUserCommentDTO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

@Repository
public class ReservationUserCommentDAO {

    private final NamedParameterJdbcTemplate jdbc;
    private final BeanPropertyRowMapper<ReservationUserCommentDTO> reservationUserCommentDTORowMapper = BeanPropertyRowMapper.newInstance(ReservationUserCommentDTO.class);

    public ReservationUserCommentDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public long getReservationUserCommentDTOSize() {
        StringBuilder sql = new StringBuilder();

        sql.append("select count(*)\n");
        sql.append("from user u, reservation_user_comment ruc\n");
        sql.append("where ruc.user_id = u.id");

        return jdbc.queryForObject(sql.toString(), Collections.emptyMap(), long.class);
    }

    public List<ReservationUserCommentDTO> selectReservationUserCommentDTO(long commentCount) {
        StringBuilder sql = new StringBuilder();

        sql.append("select ruc.id, ruc.product_id, ruc.reservation_info_id, ruc.score, u.email reservation_email, ruc.comment, ruc.create_date, ruc.modify_date\n");
        sql.append("from user u, reservation_user_comment ruc\n");
        sql.append("where ruc.user_id = u.id\n");
        sql.append("order by ruc.id desc\n");
        sql.append("limit ").append(commentCount);

        return jdbc.query(sql.toString(), Collections.emptyMap(), reservationUserCommentDTORowMapper);
    }
}
