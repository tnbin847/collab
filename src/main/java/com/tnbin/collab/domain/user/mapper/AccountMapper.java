package com.tnbin.collab.domain.user.mapper;

import com.tnbin.collab.domain.user.dto.SignUpRequest;
import com.tnbin.collab.domain.user.dto.UserRolerRequest;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 박 수 빈
 * @version 1.0
 */

@Mapper
public interface AccountMapper {
    /* 동일한 아이디의 개수 조회 */
    int selectCountById(String id);
    /* 동일한 이메일의 개수 조회 */
    int selectCountByEmail(String email);
    /* 가입 정보 저장 */
    int insertUser(SignUpRequest signUpRequest);
    /* 사용자 계정의 권한 정보 저장 */
    void insertUserRole(UserRolerRequest userRolerRequest);
}
