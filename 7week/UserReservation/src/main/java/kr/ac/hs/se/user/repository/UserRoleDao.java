package kr.ac.hs.se.user.repository;

import kr.ac.hs.se.user.model.entity.UserEntity;
import kr.ac.hs.se.user.model.entity.UserRoleEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

import static kr.ac.hs.se.user.sql.UserRoleSql.SELECT_USER_ROLES_BY_USER_EMAIL;

@Repository
public class UserRoleDao {

    private final NamedParameterJdbcTemplate jdbc;
    private final SimpleJdbcInsert insertAction;

    public UserRoleDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("user_role")
                .usingGeneratedKeyColumns("id");
    }

    public List<UserRoleEntity> selectUserRolesByUserEmail(String email) {
        return jdbc.query(
                SELECT_USER_ROLES_BY_USER_EMAIL,
                Collections.singletonMap("email", email),
                BeanPropertyRowMapper.newInstance(UserRoleEntity.class)
        );
    }

    public long insertUserRole(UserRoleEntity userRole) {
        return insertAction
                .executeAndReturnKey(new BeanPropertySqlParameterSource(userRole))
                .longValue();
    }
}
