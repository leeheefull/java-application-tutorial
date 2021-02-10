package kr.ac.hs.se.sql;

public class PromotionSql {

    public static final String COUNT_PROMOTIONS_BY_PRODUCT_IMAGE_TYPE =
            "select count(*)\n" +
                    "from promotion as pm, product as pd, category as c, product_image as pi\n" +
                    "where pm.product_id = pd.id and pd.category_id = c.id and pd.id = pi.product_id and pi.type = :product_image_type";

    public static final String SELECT_PROMOTIONS_BY_PRODUCT_IMAGE_TYPE =
            "select pm.id, pd.id product_id, c.id category_id, c.name category_name, pd.description, pi.file_id\n" +
                    "from promotion as pm, product as pd, category as c, product_image as pi\n" +
                    "where pm.product_id = pd.id and pd.category_id = c.id and pd.id = pi.product_id and pi.type = :product_image_type";
}
