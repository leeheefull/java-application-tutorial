package kr.ac.hs.se.reservation.sql;

public class ReservationSql {

    public static final String SELECT_RESERVATION_INFOS_BY_USER_EMAIL =
            "select ri.id, p.id as product_id, ri.display_info_id, ri.cancel_flag, p.description as product_description, p.content as product_content,\n" +
                    "u.id as user_id, sum(pp.price*rip.count) as sum_price, ri.reservation_date, p.create_date, p.modify_date\n" +
                    "from reservation_info as ri\n" +
                    "join user as u on ri.user_id = u.id\n" +
                    "join product as p on ri.product_id = p.id\n" +
                    "join reservation_info_price as rip on ri.id = rip.reservation_info_id\n" +
                    "join product_price as pp on rip.product_price_id = pp.id\n" +
                    "where u.email = :email\n" +
                    "group by reservation_info_id";

    public static final String UPDATE_RESERVATION_INFO_CANCEL_FLAG_BY_ID =
            "update reservation_info \n" +
                    "set cancel_flag = 1 \n" +
                    "where id = :reservationId";

    public static final String SELECT_RESERVATION_INFO_BY_ID =
            "select ri.id, ri.product_id, ri.cancel_flag, ri.display_info_id, ri.user_id, ri.reservation_date, ri.create_date, ri.modify_date\n" +
                    "from reservation_info as ri\n" +
                    "where ri.id = :reservationInfoId";

    public static final String SELECT_RESERVATION_INFO_PRICES_BY_RESERVATION_INFO_ID =
            "select rip.id, rip.reservation_info_id, rip.product_price_id, rip.count\n" +
                    "from reservation_info_price as rip\n" +
                    "where rip.reservation_info_id = :reservationInfoId";
}
