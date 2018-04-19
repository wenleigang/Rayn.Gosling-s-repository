package com.chaosquark.backend.common.mybatis.handler;

import com.chaosquark.backend.common.enums.BillCategoryEnum;
import com.chaosquark.backend.common.enums.NoticeTypeEnum;
import com.chaosquark.backend.common.enums.PlayerPositionEnum;
import com.chaosquark.backend.common.enums.StaffStatusEnum;
import com.chaosquark.backend.common.interfaces.EnumIntegerValue;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(value = {BillCategoryEnum.class, NoticeTypeEnum.class, PlayerPositionEnum.class, StaffStatusEnum.class})
public class EnumIntegerValueTypeHandler<T extends EnumIntegerValue> extends BaseTypeHandler<T> {

    private Class<T> type;
    private T[] enums;

    public EnumIntegerValueTypeHandler(Class<T> type) {
        this.type = type;
        this.enums = type.getEnumConstants();
        if(this.enums == null) {
            throw new IllegalArgumentException(type.getSimpleName() + " does not represent an enum type.");
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, T t, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, t.getValue());
    }

    @Override
    public T getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        int value = resultSet.getInt(columnName);
        if(resultSet.wasNull()) {
            return null;
        }else{
            return nullableResult(value);
        }
    }

    @Override
    public T getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        int value = resultSet.getInt(columnIndex);
        if(resultSet.wasNull()) {
            return null;
        }else{
            return nullableResult(value);
        }
    }

    @Override
    public T getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        int value = callableStatement.getInt(columnIndex);
        if(callableStatement.wasNull()) {
            return null;
        }else{
            return nullableResult(value);
        }
    }

    private T getEnum(int value) throws IllegalArgumentException {
        for (T t : enums) {
            if(t.getValue() == value) {
                return t;
            }
        }
        throw  new IllegalArgumentException();
    }

    public T nullableResult(int value) {
        try {
            return getEnum(value);
        }catch (Exception e) {
            throw new IllegalArgumentException("Cannot convert " + value + " to " + type.getSimpleName() + " by value.", e);
        }
    }
}
