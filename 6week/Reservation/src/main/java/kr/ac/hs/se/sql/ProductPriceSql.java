package kr.ac.hs.se.sql;

public class ProductPriceSql {

    public static final String SELECT_PRODUCT_PRICE_BY_PRODUCT_ID =
            "select pp.id, p.id product_id, pp.price_type_name, pp.price, pp.discount_rate, pp.create_date, pp.modify_date\n" +
                    "from product_price as pp, product as p\n" +
                    "where p.id = pp.product_id and p.id = :product_id\n" +
                    "order by pp.id desc";
}
