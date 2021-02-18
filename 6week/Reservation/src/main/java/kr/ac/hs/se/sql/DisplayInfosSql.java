package kr.ac.hs.se.sql;

public class DisplayInfosSql {

    public static final String COUNT_DISPLAY_INFO_BY_CATEGORY_ID =
            "select count(*)\n" +
                    "from product as p, display_info as di\n" +
                    "where p.id = di.product_id and p.category_id = :categoryId";

    public static final String SELECT_DISPLAY_INFO_BY_PRODUCT_IMAGE_TYPE =
            "select p.id, p.category_id, di.id as display_info_id, c.name, p.description, p.content, p.event, di.opening_hours, di.place_name, di.place_lot, di.place_street, di.tel, di.homepage, di.email, di.create_date, di.modify_date, pi.file_id\n" +
                    "    from product as p, display_info as di , category as c, product_image as pi\n" +
                    "    where p.id = di.product_id and p.id = pi.product_id and pi.type = :productImageType and p.category_id = c.id";

    public static final String SELECT_DISPLAY_INFO_BY_PRODUCT_IMAGE_TYPE_AND_CATEGORY_ID =
            "select p.id, p.category_id, di.id as display_info_id, c.name, p.description, p.content, p.event, di.opening_hours, di.place_name, di.place_lot, di.place_street, di.tel, di.homepage, di.email, di.create_date, di.modify_date, pi.file_id\n" +
                    "from product as p, display_info as di , category as c, product_image as pi\n" +
                    "where p.id = di.product_id and p.id = pi.product_id and pi.type = :productImageType and p.category_id = c.id and c.id = :categoryId";

    public static final String SELECT_DISPLAY_INFO_BY_PRODUCT_IMAGE_TYPE_AND_CATEGORY_ID_AND_PAGE =
            "select p.id, p.category_id, di.id as display_info_id, c.name, p.description, p.content, p.event, di.opening_hours, di.place_name, di.place_lot, di.place_street, di.tel, di.homepage, di.email, di.create_date, di.modify_date, pi.file_id\n" +
                    "from product as p, display_info as di , category as c, product_image as pi\n" +
                    "where p.id = di.product_id and p.id = pi.product_id and pi.type = :productImageType and p.category_id = c.id and c.id = :categoryId\n" +
                    "limit :pageSize offset :offset";

    public static final String SELECT_DISPLAY_INFO_BY_PRODUCT_IMAGE_TYPE_AND_DISPLAY_ID =
            "select p.id, p.category_id, di.id as display_info_id, c.name, p.description, p.content, p.event, di.opening_hours, di.place_name, di.place_lot, di.place_street, di.tel, di.homepage, di.email, di.create_date, di.modify_date, pi.file_id\n" +
                    "from product as p, display_info as di, category as c, product_image as pi\n" +
                    "where p.id = di.product_id and p.id = pi.product_id and pi.type = :productImageType and p.category_id = c.id and di.id = :displayInfoId";

    public static final String SELECT_PRODUCT_IMAGE_BY_PRODUCT_ID_AND_PRODUCT_IMAGE_TYPE =
            "select p.id as product_id, pi.id as product_image_id, pi.type, pi.file_id as file_info_id, fi.file_name, fi.save_file_name, fi.content_type, fi.delete_flag, fi.create_date, fi.modify_date\n" +
                    "from product as p, product_image as pi, file_info as fi\n" +
                    "where p.id = pi.product_id and pi.file_id = fi.id and p.id = :productId and pi.type = :productImageType";

    public static final String SELECT_DISPLAY_INFO_IMAGE_BY_PRODUCT_ID =
            "select dii.id, dii.display_info_id, dii.file_id, fi.file_name, fi.save_file_name, fi.content_type, fi.delete_flag, fi.create_date, fi.modify_date\n" +
                    "from display_info as di, display_info_image as dii, file_info as fi\n" +
                    "where di.id = dii.display_info_id and dii.file_id = fi.id and di.product_id= :productId";

    public static final String SELECT_PRODUCT_PRICE_BY_PRODUCT_ID =
            "select id, product_id, price_type_name, price, discount_rate, create_date, modify_date\n" +
                    "from product_price\n" +
                    "where product_id = :productId\n" +
                    "order by id desc;";

    public static final String COUNT_RESERVATION_USER_COMMENTS_BY_PRODUCT_ID =
            "select count(*)\n" +
                    "from reservation_user_comment as ruc, user as u\n" +
                    "where ruc.user_id = u.id and ruc.product_id = :productId";

    public static final String AVG_RESERVATION_USER_COMMENT_SCORE_BY_PRODUCT_ID =
            "select avg(ruc.score)\n" +
                    "from reservation_user_comment as ruc, product as p\n" +
                    "where p.id = ruc.product_id and p.id = :productId";

    public static final String SELECT_RESERVATION_USER_COMMENTS =
            "select ruc.id, ruc.product_id, ruc.reservation_info_id, ruc.score, u.email reservation_email, ruc.comment, ruc.create_date, ruc.modify_date\n" +
                    "from reservation_user_comment as ruc, user as u\n" +
                    "where ruc.user_id = u.id\n" +
                    "order by ruc.id desc";

    public static final String SELECT_RESERVATION_USER_COMMENTS_BY_PRODUCT_ID =
            "select ruc.id, ruc.product_id, ruc.reservation_info_id, ruc.score, u.email reservation_email, ruc.comment, ruc.create_date, ruc.modify_date\n" +
                    "from reservation_user_comment as ruc, user as u\n" +
                    "where ruc.user_id = u.id and ruc.product_id = :productId\n" +
                    "order by ruc.id desc";

    public static final String SELECT_RESERVATION_USER_COMMENTS_BY_PRODUCT_ID_AND_PAGE =
            "select ruc.id, ruc.product_id, ruc.reservation_info_id, ruc.score, u.email reservation_email, ruc.comment, ruc.create_date, ruc.modify_date\n" +
                    "from reservation_user_comment as ruc, user as u\n" +
                    "where ruc.user_id = u.id and ruc.product_id = :productId\n" +
                    "order by ruc.id desc\n" +
                    "limit :pageSize offset :offset";
}
