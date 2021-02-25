package kr.ac.hs.se.reservation.repository;

import kr.ac.hs.se.reservation.model.Dto.ReservationDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

import static kr.ac.hs.se.reservation.sql.ReservationSql.*;

@RequiredArgsConstructor
@Repository
public class ReservationDetailDao {

    private final NamedParameterJdbcTemplate jdbc;

    public List<ReservationDetail> selectReservationInfoDetails(String email) {
        return jdbc.query(
                SELECT_RESERVATION_INFOS_BY_USER_EMAIL,
                Collections.singletonMap("email", email),
                BeanPropertyRowMapper.newInstance(ReservationDetail.class)
        );
    }
}
