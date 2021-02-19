package kr.ac.hs.se.sql;

public class CommentsSql {

    public static final String AVG_COMMENT_SCORE_BY_PRODUCT_ID =
            "select avg(ruc.score)\n" +
                    "from reservation_user_comment as ruc, product as p\n" +
                    "where p.id = ruc.product_id and p.id = :productId";

    public static final String SELECT_COMMENTS =
            "select ruc.id, ruc.product_id, ruc.reservation_info_id, ruc.score, u.email reservation_email, ruc.comment, ruc.create_date, ruc.modify_date\n" +
                    "from reservation_user_comment as ruc, user as u\n" +
                    "where ruc.user_id = u.id\n" +
                    "order by ruc.id desc";

    public static final String SELECT_COMMENTS_BY_PRODUCT_ID =
            "select ruc.id, ruc.product_id, ruc.reservation_info_id, ruc.score, u.email reservation_email, ruc.comment, ruc.create_date, ruc.modify_date\n" +
                    "from reservation_user_comment as ruc, user as u\n" +
                    "where ruc.user_id = u.id and ruc.product_id = :productId\n" +
                    "order by ruc.id desc";

    public static final String SELECT_COMMENTS_BY_PRODUCT_ID_AND_PAGE =
            "select ruc.id, ruc.product_id, ruc.reservation_info_id, ruc.score, u.email reservation_email, ruc.comment, ruc.create_date, ruc.modify_date\n" +
                    "from reservation_user_comment as ruc, user as u\n" +
                    "where ruc.user_id = u.id and ruc.product_id = :productId\n" +
                    "order by ruc.id desc\n" +
                    "limit :pageSize offset :offset";
}
