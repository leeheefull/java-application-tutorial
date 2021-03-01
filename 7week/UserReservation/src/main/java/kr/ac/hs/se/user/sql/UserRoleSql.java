package kr.ac.hs.se.user.sql;

public class UserRoleSql {

    public static final String SELECT_USER_ROLES_BY_USER_EMAIL =
            "select ur.id, ur.user_id, ur.role_name \n" +
                    "from user as u, user_role as ur\n" +
                    "where u.id = ur.user_id and u.email = :email";
}
