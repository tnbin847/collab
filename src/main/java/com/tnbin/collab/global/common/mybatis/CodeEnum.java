package com.tnbin.collab.global.common.mybatis;

/**
 * <p>코드값을 정의한 Enum 클래스를 일관적으로 구현하기 위해 생성한 인터페이스</p>
 *
 * @author 박 수 빈
 * @version 1.0
 */

public interface CodeEnum {
    /* 데이터베이스에 저장하거나, 데이터베이스로부터 가져온 코드를 열거형 타입으로 변환하기 위한 코드를 가져온다. */
    String getCode();
    /* 뷰에 출력할 값을 가져온다. */
    String getLabel();
}
