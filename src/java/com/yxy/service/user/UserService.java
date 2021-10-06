package com.yxy.service.user;

import com.yxy.pojo.User;

public interface UserService {
    public User login(String userCode, String password);
}
