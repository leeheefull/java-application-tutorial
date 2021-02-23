package kr.ac.hs.se.user.service;

import kr.ac.hs.se.user.dto.UserDto;
import kr.ac.hs.se.user.dto.UserRoleDto;
import kr.ac.hs.se.user.repository.UserDao;
import kr.ac.hs.se.user.repository.UserRoleDao;
import kr.ac.hs.se.security.service.UserDbService;
import kr.ac.hs.se.security.model.entity.UserEntity;
import kr.ac.hs.se.security.model.entity.UserRoleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService implements UserDbService {

    private final UserDao userDao;
    private final UserRoleDao userRoleDao;

    @Override
    public UserEntity getUser(String loginUserId) {
        UserDto user = userDao.selectUserByEmail(loginUserId);
        return new UserEntity(user.getEmail(), user.getPassword());
    }

    @Override
    public List<UserRoleEntity> getUserRoles(String loginUserID) {
        List<UserRoleDto> userRoles = userRoleDao.selectUserRolesByUserEmail(loginUserID);
        List<UserRoleEntity> list = new ArrayList<>();

        for (UserRoleDto userRole : userRoles) {
            list.add(new UserRoleEntity(loginUserID, userRole.getRoleName()));
        }
        return list;
    }
}
