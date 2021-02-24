package kr.ac.hs.se.config;

import kr.ac.hs.se.security.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailsService customUserDetailsService;

    // /webjars/** 경로에 대한 요청은 인증/인가 처리하지 않도록 무시
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/webjars/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/", "/users/loginform", "/users/loginerror")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                    .formLogin()
                    .loginPage("/users/loginform")
                    .usernameParameter("userId")
                    .passwordParameter("password")
                    .loginProcessingUrl("/authenticate")
                    .failureForwardUrl("/users/loginerror?login_error=1")
                    .defaultSuccessUrl("/main", true)
                    .permitAll()
                .and()
                    .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/");
    }

    // 비밀번호 인코딩
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
