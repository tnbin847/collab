package com.tnbin.collab.domain.user.enums;

import com.tnbin.collab.global.common.mybatis.CodeEnum;
import lombok.RequiredArgsConstructor;

/**
 * @author 박 수 빈
 * @version 1.0
 */

@RequiredArgsConstructor
public enum LoginType implements CodeEnum {
    DEFAULT ("DEFAULT", "일반"),
    SOCIAL ("OAUTH", "소셜");

    private final String code;
    private final String label;

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getLabel() {
        return this.label;
    }
}
