package com.yxy.service.user;

import com.yxy.mapper.BaseMapper;
import com.yxy.mapper.user.UserMapper;
import com.yxy.mapper.user.UserMapperImpl;
import com.yxy.pojo.User;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService{
    private UserMapper userMapper;

    public UserServiceImpl(){
        userMapper = new UserMapperImpl();
    }

    @Override
    public User login(String userCode, String password) {
        Connection connection = null;
        User user = null;


        try {
            connection = BaseMapper.getConnection();
            user =  userMapper.getLoginUser(connection, userCode);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseMapper.closeResource(connection, null, null);
        }
        return user;
    }

    @Test
    public void test(){
        UserServiceImpl userService = new UserServiceImpl();
        User admin = userService.login("admin", "1234567");
        System.out.println(admin.getUserPassword());
    }
}
