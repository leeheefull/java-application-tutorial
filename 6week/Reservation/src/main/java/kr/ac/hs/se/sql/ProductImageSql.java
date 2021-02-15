package kr.ac.hs.se.sql;

public class ProductImageSql {

    public static final String SELECT_PRODUCT_IMAGE_BY_PRODUCT_ID =
            "select p.id as product_id, pi.id as product_image_id, pi.type, pi.file_id as file_info_id, fi.file_name, fi.save_file_name, fi.content_type, fi.delete_flag, fi.create_date, fi.modify_date\n" +
                    "from product as p, product_image as pi, file_info as fi\n" +
                    "where p.id = pi.product_id and pi.file_id = fi.id and p.id = :product_id and pi.type = :product_image_type";
}
