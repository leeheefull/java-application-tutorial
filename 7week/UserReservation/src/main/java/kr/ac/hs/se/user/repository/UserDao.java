package kr.ac.hs.se.user.repository;

import kr.ac.hs.se.user.model.entity.UserEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;

import static kr.ac.hs.se.user.sql.UserSql.SELECT_USER_BY_EMAIL;

@Repository
public class UserDao {

    private final NamedParameterJdbcTemplate jdbc;
    private final SimpleJdbcInsert insertAction;

    public UserDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("user")
                .usingGeneratedKeyColumns("id");
    }

    public UserEntity selectUserByEmail(String email) {
        return jdbc.queryForObject(
                SELECT_USER_BY_EMAIL,
                Collections.singletonMap("email", email),
                BeanPropertyRowMapper.newInstance(UserEntity.class)
        );
    }

    public long insertUser(UserEntity user) {
        return insertAction
                .executeAndReturnKey(new BeanPropertySqlParameterSource(user))
                .longValue();
    }
}
