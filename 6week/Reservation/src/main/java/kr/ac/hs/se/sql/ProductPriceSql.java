package kr.ac.hs.se.sql;

public class ProductPriceSql {

    public static final String SELECT_PRODUCT_PRICE_BY_PRODUCT_ID =
            "select id, product_id, price_type_name, price, discount_rate, create_date, modify_date\n" +
                    "from product_price\n" +
                    "where product_id = 1\n" +
                    "order by id desc;";
}
