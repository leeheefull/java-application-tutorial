package kr.ac.hs.se.sql;

public class ReservationUserCommentSql {

    public static final String COUNT_RESERVATION_USER_COMMENTS =
            "select count(*)\n" +
                    "from reservation_user_comment as ruc, user as u\n" +
                    "where ruc.user_id = u.id";

    public static final String AVG_RESERVATION_USER_COMMENT_SCORE_BY_PRODUCT_ID =
            "select avg(ruc.score)\n" +
                    "from reservation_user_comment as ruc, product as p\n" +
                    "where p.id = ruc.product_id and p.id = :product_id";

    public static final String SELECT_RESERVATION_USER_COMMENTS =
            "select ruc.id, ruc.product_id, ruc.reservation_info_id, ruc.score, u.email reservation_email, ruc.comment, ruc.create_date, ruc.modify_date\n" +
                    "from reservation_user_comment as ruc, user as u\n" +
                    "where ruc.user_id = u.id\n" +
                    "order by ruc.id desc\n" +
                    "limit :comment_count";
}
