package com.tnbin.collab.global.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author 박 수 빈
 * @version 1.0
 */

@Configuration
@EnableWebSecurity // 웹 시큐리티 활성화 : 스프링 필터 체인에 등록
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String[] IGNORED_RESOURCES = {"/css/**", "/js/**", "/images/**", "/fonts/**", "/favicon.ico"};
    private static final String[] ACCESSIBLE_PATTERNS = {"/", "/membership/**", "/api/v1/account", "/api/v1/account/**"};

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(IGNORED_RESOURCES);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable()
            .csrf().disable()
            .authorizeRequests()
                .antMatchers(ACCESSIBLE_PATTERNS).permitAll()
                .anyRequest().authenticated()
            .and().formLogin()
            .usernameParameter("id")
            .passwordParameter("password");
    }
}