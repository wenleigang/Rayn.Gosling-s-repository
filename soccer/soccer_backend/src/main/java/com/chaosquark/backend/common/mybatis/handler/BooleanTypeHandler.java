package com.chaosquark.backend.common.mybatis.handler;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BooleanTypeHandler implements TypeHandler<Boolean> {

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Boolean parameter, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, parameter ? "1" : "0");
    }

    @Override
    public Boolean getResult(ResultSet resultSet, String columnName) throws SQLException {
        String string = resultSet.getString(columnName);
        Boolean result = Boolean.FALSE;
        if(StringUtils.equals(string, "1")) {
            result = Boolean.TRUE;
        }
        return result;
    }

    @Override
    public Boolean getResult(ResultSet resultSet, int columnIndex) throws SQLException {
        String string = resultSet.getString(columnIndex);
        Boolean result = Boolean.FALSE;
        if(StringUtils.equals(string, "1")) {
            result = Boolean.TRUE;
        }
        return result;
    }

    @Override
    public Boolean getResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        return callableStatement.getBoolean(columnIndex);
    }
}
