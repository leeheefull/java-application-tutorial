package kr.ac.hs.se.user.service;

import kr.ac.hs.se.user.model.CustomUserDetails;
import kr.ac.hs.se.user.model.LoginUser;
import kr.ac.hs.se.user.model.LoginUserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String loginUserId) throws UsernameNotFoundException {

        LoginUser loginUser = userService.getUser(loginUserId);
        if (loginUser == null) {
            throw new UsernameNotFoundException("존재하지 않는 사용자입니다.");
        }

        List<LoginUserRole> loginUserRoles = userService.getUserRoles(loginUserId);
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (LoginUserRole loginUserRole : loginUserRoles) {
            authorities.add(new SimpleGrantedAuthority(loginUserRole.getRoleName()));
        }

        return Optional.ofNullable(
                CustomUserDetails.builder()
                        .username(loginUser.getLoginUserId())
                        .password(loginUser.getPassword())
                        .isEnabled(true)
                        .isAccountNonExpired(true)
                        .isAccountNonLocked(true)
                        .isCredentialsNonExpired(true)
                        .authorities(authorities)
                        .build()
        ).orElseThrow();
    }
}   // "security configuration"으로 보내기