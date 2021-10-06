package com.yxy.mapper.user;

import com.yxy.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserMapper {

    User getLoginUser(Connection connection, String userCode) throws SQLException;
}
