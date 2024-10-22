package com.tnbin.collab.domain.user.dto;

import com.tnbin.collab.domain.user.enums.Role;
import com.tnbin.collab.global.utils.Status;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author 박 수 빈
 * @version 1.0
 */

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserRolerRequest {
    private Long userId;

    private Role role;

    private String usedAt;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public UserRolerRequest(Long userId, Role role, Status status) {
        this.userId = userId;
        this.role = role;
        this.usedAt = status.getSymbol();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}
