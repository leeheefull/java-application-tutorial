package kr.ac.hs.se.reservation.repository;

import kr.ac.hs.se.reservation.model.entity.ReservationInfo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

import java.util.Collections;

import static kr.ac.hs.se.reservation.sql.ReservationSql.SELECT_RESERVATION_INFO_BY_ID;
import static kr.ac.hs.se.reservation.sql.ReservationSql.UPDATE_RESERVATION_INFO_CANCEL_FLAG_BY_ID;

@Repository
public class ReservationInfoDao {

    private final NamedParameterJdbcTemplate jdbc;
    private final SimpleJdbcInsert insertAction;

    public ReservationInfoDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("reservation_info")
                .usingGeneratedKeyColumns("id");
    }

    public ReservationInfo selectReservationInfo(long reservationInfoId) {
        return jdbc.queryForObject(
                SELECT_RESERVATION_INFO_BY_ID,
                Collections.singletonMap("reservationInfoId", reservationInfoId),
                BeanPropertyRowMapper.newInstance(ReservationInfo.class)
        );
    }

    public long insertReservationInfo(ReservationInfo reservationInfo) {
        return insertAction
                .executeAndReturnKey(new BeanPropertySqlParameterSource(reservationInfo))
                .longValue();
    }

    public long updateReservationInfoCancelFlag(long reservationId) {
        return jdbc.update(
                UPDATE_RESERVATION_INFO_CANCEL_FLAG_BY_ID,
                Collections.singletonMap("reservationId", reservationId)
        );
    }
}
