package kr.ac.hs.se.sql;

public class DisplayInfoImageSql {

    public static final String SELECT_DISPLAY_INFO_IMAGE_BY_PRODUCT_ID =
            "select dii.id, dii.display_info_id, dii.file_id, fi.file_name, fi.save_file_name, fi.content_type, fi.delete_flag, fi.create_date, fi.modify_date\n" +
                    "from display_info as di, display_info_image as dii, file_info as fi\n" +
                    "where di.id = dii.display_info_id and dii.file_id = fi.id and di.product_id= :product_image_id";
}
