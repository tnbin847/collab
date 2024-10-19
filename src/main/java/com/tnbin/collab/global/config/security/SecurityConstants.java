package com.tnbin.collab.global.config.security;

/**
 * <p>생성된 클래스에 대한 설명을 입력해주세요.</p>
 *
 * @author 박 수 빈
 * @version 1.0
 */


public class SecurityConstants {
    public static final String[] IGNORING_RESOURCES = {"/css/**", "/js/**", "/images/**", "/fonts/**"};
    public static final String[] PUBLICY_PATTERNS = {"/", "/sign-up", "/find-id", "/find-pwd",
            "/api/v1/account/**", "/api/v1/account", "/api/v1/login", "/api/v1/logout"};
}
