package kr.ac.hs.se.reservation.sql;

public class ReservationInfoPriceSql {

    public static final String SELECT_RESERVATION_INFO_PRICES_BY_RESERVATION_INFO_ID =
            "select rip.id, rip.reservation_info_id, rip.product_price_id, rip.count\n" +
                    "from reservation_info_price as rip\n" +
                    "where rip.reservation_info_id = :reservationInfoId";
}
