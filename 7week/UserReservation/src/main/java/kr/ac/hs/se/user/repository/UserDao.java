package kr.ac.hs.se.user.repository;

import kr.ac.hs.se.user.model.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;

import static kr.ac.hs.se.user.sql.UserSql.SELECT_USER_BY_EMAIL;

@RequiredArgsConstructor
@Repository
public class UserDao {

    private final NamedParameterJdbcTemplate jdbc;

    public UserEntity selectUserByEmail(String email) {
        return jdbc.queryForObject(
                SELECT_USER_BY_EMAIL,
                Collections.singletonMap("email", email),
                BeanPropertyRowMapper.newInstance(UserEntity.class)
        );
    }
}
