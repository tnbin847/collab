package com.tnbin.collab.global.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * <p>상태여부 값을 코드단에서 처리하기 위해 서로 다른 타입의 상응되는 의미를 지닌 값들을 묶어 정의한 Enum 클래스</p>
 *
 * @author 박 수 빈
 * @version 1.0
 */

@RequiredArgsConstructor
@Getter
public enum Status {
    YES ("Y", 1, true),
    NO ("N", 0, false);

    private final String symbol;    // 문자열 상태값
    private final int number;       // 정수형 상태값
    private final boolean flag;     // 논리형 상태값

    /**
     * 인자로 전달 받은 값에 해당 되는 논리형 상태값을 반환한다.
     */
    public boolean toBoolean(int value) {
        return Arrays.stream(values())
                .filter(status -> status.getNumber() == value)
                .findFirst()
                .map(Status::isFlag)
                .orElseThrow(() -> new IllegalArgumentException(value + " is a not valid value."));
    }
}
