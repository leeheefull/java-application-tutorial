package kr.ac.hs.se.security.service;

import kr.ac.hs.se.security.model.entity.UserEntity;
import kr.ac.hs.se.security.model.entity.UserRoleEntity;

import java.util.List;

public interface UserDbService {

    UserEntity getUser(String loginUserId);

    List<UserRoleEntity> getUserRoles(String loginUserId);
}
