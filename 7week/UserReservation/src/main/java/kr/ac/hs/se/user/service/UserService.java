package kr.ac.hs.se.user.service;

import kr.ac.hs.se.user.model.entity.UserEntity;
import kr.ac.hs.se.user.model.entity.UserRoleEntity;
import kr.ac.hs.se.user.model.request.SignupRequest;
import kr.ac.hs.se.user.repository.UserDao;
import kr.ac.hs.se.user.repository.UserRoleDao;
import kr.ac.hs.se.user.model.LoginUser;
import kr.ac.hs.se.user.model.LoginUserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserDao userDao;
    private final UserRoleDao userRoleDao;
//    private final PasswordEncoder encoder;

    public LoginUser getUser(String loginUserId) {
        UserEntity user = userDao.selectUserByEmail(loginUserId);
        return new LoginUser(user.getEmail(), user.getPassword());
    }

    public List<LoginUserRole> getUserRoles(String loginUserID) {

        List<LoginUserRole> loginUserRoles = new ArrayList<>();
        for (UserRoleEntity userRole : userRoleDao.selectUserRolesByUserEmail(loginUserID)) {
            loginUserRoles.add(new LoginUserRole(loginUserID, userRole.getRoleName()));
        }
        return loginUserRoles;
    }

    @Transactional
    public long createUserAndUserRole(SignupRequest request) {

        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String now = new SimpleDateFormat("yyyy.MM.dd").format(System.currentTimeMillis());

        long userId = userDao.insertUser(
                UserEntity.builder()
                        .name(request.getName())
                        .password(encoder.encode(request.getPassword()))
                        .email(request.getEmail())
                        .phone(request.getPhone())
                        .createDate(now)
                        .modifyDate(now)
                        .build()
        );

        return userRoleDao.insertUserRole(
                UserRoleEntity.builder()
                        .userId(userId)
                        .roleName("ROLE_USER")
                        .build()
        );
    }
}
