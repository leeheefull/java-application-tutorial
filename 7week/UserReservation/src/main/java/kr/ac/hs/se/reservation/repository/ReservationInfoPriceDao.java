package kr.ac.hs.se.reservation.repository;

import kr.ac.hs.se.reservation.model.entity.ReservationInfoPrice;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

import static kr.ac.hs.se.reservation.sql.ReservationSql.SELECT_RESERVATION_INFO_PRICES_BY_RESERVATION_INFO_ID;

@Repository
public class ReservationInfoPriceDao {

    private final NamedParameterJdbcTemplate jdbc;
    private final SimpleJdbcInsert insertAction;

    public ReservationInfoPriceDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("reservation_info_price")
                .usingGeneratedKeyColumns("id");
    }

    public List<ReservationInfoPrice> selectReservationInfoPrices(long reservationInfoId) {
        return jdbc.query(
                SELECT_RESERVATION_INFO_PRICES_BY_RESERVATION_INFO_ID,
                Collections.singletonMap("reservationInfoId", reservationInfoId),
                BeanPropertyRowMapper.newInstance(ReservationInfoPrice.class)
        );
    }

    public long insertReservationInfoPrice(ReservationInfoPrice reservationInfoPrice) {
        return insertAction
                .executeAndReturnKey(new BeanPropertySqlParameterSource(reservationInfoPrice))
                .longValue();
    }
}
