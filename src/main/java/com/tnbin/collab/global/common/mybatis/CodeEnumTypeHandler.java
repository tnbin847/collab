package com.tnbin.collab.global.common.mybatis;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * <p>마이바티스에서 Enum 클래스 내에 정의된 코드값을 저장하기 위해 매핑처리를 수행하거나, 데이터베이스로부터 가져온 코드값을 토대로 알맞은
 * Enum 클래스 타입으로 반환하는 역할을 수행하는 타입 핸들러 클래스</p>
 *
 * @author 박 수 빈
 * @version 1.0
 */

@MappedTypes(CodeEnum.class)
public class CodeEnumTypeHandler <E extends Enum<E> & CodeEnum> extends BaseTypeHandler<E> {
    private Class<E> type;
    private E[] constants;

    public CodeEnumTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null.");
        }
        this.type = type;
        this.constants = type.getEnumConstants();
        if (!type.isInterface() && this.constants == null) {
            throw new IllegalArgumentException(type.getSimpleName() + " does not represent an enum type.");
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getCode());
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return rs.wasNull() ? null : toCodeEnum(rs.getString(columnName));
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return rs.wasNull() ? null : toCodeEnum(rs.getString(columnIndex));
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return cs.wasNull() ? null : toCodeEnum(cs.getString(columnIndex));
    }

    /**
     * Enum 클래스 내의 모든 상수값들 중에 인자로 전달받은 code값과 비교하여 일치한다면 해당 Enum을 반환한다.
     * @param code  데이터베이스로부터 가져온 코드값
     * @return E    데이터베이스로부터 가져온 코드값과 일치한 Enum 클래스 타입 상수
     */
    private E toCodeEnum(String code) {
       return Arrays.stream(constants)
               .filter(e -> e.getCode().equals(code))
               .findFirst()
               .orElseThrow(() -> new IllegalArgumentException("Cannot convert " + code + " to " + type.getSimpleName() + "."));
    }
}
