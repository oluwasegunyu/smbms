package com.yxy.mapper.user;

import com.yxy.mapper.BaseMapper;
import com.yxy.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapperImpl implements UserMapper{
    @Override
    public User getLoginUser(Connection connection, String userCode) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs=null;
        User user = null;

        if(connection != null) {
            String sql = "select * from smbms_user where userCode=?";
            Object[] params = {userCode};


                rs= BaseMapper.execute(connection, pstm, rs, sql, params);
                if(rs.next()){
                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUserName(rs.getString("userName"));
                    user.setUserPassword(rs.getString("userPassword"));
                }

                BaseMapper.closeResource(null, pstm, rs);
        }
        return  user;
    }

}
