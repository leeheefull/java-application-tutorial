package kr.ac.hs.se.user.service;

import kr.ac.hs.se.user.model.entity.UserEntity;
import kr.ac.hs.se.user.model.entity.UserRoleEntity;
import kr.ac.hs.se.user.repository.UserDao;
import kr.ac.hs.se.user.repository.UserRoleDao;
import kr.ac.hs.se.user.model.User;
import kr.ac.hs.se.user.model.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserDao userDao;
    private final UserRoleDao userRoleDao;

    public User getUser(String loginUserId) {
        UserEntity user = userDao.selectUserByEmail(loginUserId);
        return new User(user.getEmail(), user.getPassword());
    }

    public List<UserRole> getUserRoles(String loginUserID) {
        List<UserRoleEntity> userRoles = userRoleDao.selectUserRolesByUserEmail(loginUserID);
        List<UserRole> list = new ArrayList<>();

        for (UserRoleEntity userRole : userRoles) {
            list.add(new UserRole(loginUserID, userRole.getRoleName()));
        }
        return list;
    }
}
