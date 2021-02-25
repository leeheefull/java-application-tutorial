package kr.ac.hs.se.user.repository;

import kr.ac.hs.se.user.model.entity.UserRoleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

import static kr.ac.hs.se.user.sql.UserRoleSql.SELECT_USER_ROLES_BY_USER_EMAIL;

@RequiredArgsConstructor
@Repository
public class UserRoleDao {

    private final NamedParameterJdbcTemplate jdbc;

    public List<UserRoleEntity> selectUserRolesByUserEmail(String email) {
        return jdbc.query(
                SELECT_USER_ROLES_BY_USER_EMAIL,
                Collections.singletonMap("email", email),
                BeanPropertyRowMapper.newInstance(UserRoleEntity.class)
        );
    }
}
