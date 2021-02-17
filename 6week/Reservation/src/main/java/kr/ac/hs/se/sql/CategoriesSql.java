package kr.ac.hs.se.sql;

public class CategoriesSql {

    public static final String SELECT_CATEGORIES =
            "select c.id, c.name, (select count(*) from display_info d, product p where p.id = d.product_id and p.category_id = c.id) as count\n" +
                    "from category as c";
}
