package com.tnbin.collab.global.config.security;

/**
 * @author 박 수 빈
 * @version 1.0
 */

public class SecurityConstants {
    public static final String[] IGNORED_RESOURCES = {
            // 누구든 접속 가능한 페이지 URL ||-----------------------------------------------
            "/",
            "/account/**",
            // 정적 리소스 매핑 URL ||------------------------------------------------------
            "/css/**",
            "/fonts/**",
            "/images/**",
            "/js/**",
            "/favicon.ico",
            "/h2-console"
    };

    public static final String[] PUBLICY_URL_PATTERNS = {
            "/api/v1/account",
            "/api/v1/account/**"
    };
}