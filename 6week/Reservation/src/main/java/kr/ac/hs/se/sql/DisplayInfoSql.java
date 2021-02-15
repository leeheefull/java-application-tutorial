package kr.ac.hs.se.sql;

public class DisplayInfoSql {

    public static final String COUNT_DISPLAY_INFO_BY_CATEGORY_ID =
            "select count(*)\n" +
                    "from product as p, display_info as di\n" +
                    "where p.id = di.product_id and p.category_id = :category_id";

    public static final String SELECT_DISPLAY_INFO_BY_CATEGORY_ID =
            "select p.id, p.category_id, di.id as display_info_id, c.name, p.description, p.content, p.event, di.opening_hours, di.place_name, di.place_lot, di.place_street, di.tel, di.homepage, di.email, di.create_date, di.modify_date, pi.file_id\n" +
                    "from product as p, display_info as di , category as c, product_image as pi\n" +
                    "where p.id = di.product_id and p.id = pi.product_id and pi.type = :product_image_type and p.category_id = c.id and c.id = :category_id\n" +
                    "limit :start, 4";

    public static final String SELECT_DISPLAY_INFO_BY_DISPLAY_ID =
            "select p.id, p.category_id, di.id as display_info_id, c.name, p.description, p.content, p.event, di.opening_hours, di.place_name, di.place_lot, di.place_street, di.tel, di.homepage, di.email, di.create_date, di.modify_date, pi.file_id\n" +
                    "from product as p, display_info as di, category as c, product_image as pi\n" +
                    "where p.id = di.product_id and p.id = pi.product_id and pi.type = :product_image_type and p.category_id = c.id and di.id = :display_info_id";
}
