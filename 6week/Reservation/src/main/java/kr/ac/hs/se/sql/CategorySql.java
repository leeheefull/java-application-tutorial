package kr.ac.hs.se.sql;

public class CategorySql {

    public static final String COUNT_CATEGORIES =
            "select count(*) from category";

    public static final String SELECT_CATEGORIES =
            "select c.id, c.name, (select count(*) from display_info d, product p where p.id = d.product_id and p.category_id = c.id) as count\n" +
                    "from category as c";
}
