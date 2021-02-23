package kr.ac.hs.se.reservation.repository;

import kr.ac.hs.se.reservation.model.domain.ReservationInfo;
import kr.ac.hs.se.reservation.model.ReservationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

import static kr.ac.hs.se.reservation.sql.ReservationSql.*;

@RequiredArgsConstructor
@Repository
public class ReservationDao {

    private final NamedParameterJdbcTemplate jdbc;
    private final SimpleJdbcInsert insertAction;

    public List<ReservationDto> selectReservationInfos(String email) {
        return jdbc.query(SELECT_RESERVATION_INFOS_BY_USER_EMAIL,
                Collections.singletonMap("email", email),
                BeanPropertyRowMapper.newInstance(ReservationDto.class));
    }

    public long insertReservationInfo(ReservationInfo reservationInfo) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfo);
        return insertAction.withTableName("reservation_info")
                .usingGeneratedKeyColumns("id")
                .executeAndReturnKey(params)
                .longValue();
    }

    public long updateReservationInfoCancelFlag(long reservationId) {
        return jdbc.update(UPDATE_RESERVATION_INFO_CANCEL_FLAG_BY_ID,
                Collections.singletonMap("reservationId", reservationId));
    }
}
