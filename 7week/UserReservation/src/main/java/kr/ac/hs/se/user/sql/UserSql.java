package kr.ac.hs.se.user.sql;

public class UserSql {

    public static final String SELECT_USER_BY_EMAIL =
            "select id, name, password, email, phone, create_date, modify_date \n" +
                    "from user \n" +
                    "where email = :email";
}
