package com.tnbin.collab.global.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * <p>스프링 시큐리티 설정 클래스</p>
 *
 * @author      박 수 빈
 * @version     1.0
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * 패스워드 암호화 객체를 스프링 빈 등록
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 웹 정적 리소스 인증 및 인가 처리 미적용
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(SecurityConstants.IGNORED_RESOURCES);
    }

    /**
     * 특정  HTTP 요청에 대한 웹 기반 보안 구성
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable()  // 기본 인증 로그인 방식 비활성
            .csrf().disable()       // 개발 편의성을 위해 CSRF 비활성화
            // 인가 설정 || -------------------------------------------------------------
            .authorizeRequests()    // HttpServeltRequest 요청 URL에 따라 접근 권한을 설정
                .antMatchers(SecurityConstants.PUBLICY_URL_PATTERNS).permitAll()
                .anyRequest().authenticated()
            .and()
            .formLogin().disable();
        // 세션 설정 || -------------------------------------------------------------
        http.sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
            .maximumSessions(1)     // 최대 허용 가능 세션 수 설정 (-1 : 무제한 로그인 세션 허용)
            /* 동시 로그인 차단 - false : 기존 세션 만료(default) */
            .maxSessionsPreventsLogin(true);
    }
}