package kr.ac.hs.se.reservation.sql;

public class ReservationSql {

    public static final String SELECT_RESERVATION_INFOS_BY_USER_EMAIL =
            "select ri.id, ri.product_id, ri.display_info_id, ri.cancel_flag, p.description as product_description, p.content as product_content,\n" +
                    "ri.user_id, sum(pp.price * rip.count) as sum_price, ri.reservation_date, ri.create_date, ri.modify_date\n" +
                    "from reservation_info as ri\n" +
                    "join product as p on ri.product_id = p.id\n" +
                    "join reservation_info_price as rip on ri.id = rip.reservation_info_id\n" +
                    "join product_price as pp on rip.product_price_id = pp.id\n" +
                    "where ri.user_id = (select id from user where email = :email)";

    public static final String UPDATE_RESERVATION_INFO_CANCEL_FLAG_BY_ID =
            "update reservation_info \n" +
                    "set cancel_flag = 1 \n" +
                    "where id = :reservationId";

    public static final String SELECT_RESERVATION_INFO_PRICES_BY_USER_EMAIL =
            "select id, reservation_info_id, product_price_id, count\n" +
                    "from reservation_info_price\n" +
                    "where reservation_info_id = (\n" +
                    "select id from reservation_info where user_id = (\n" +
                    "select id from user where email = :email))";
}
