package com.cy8.store.service;

import com.cy8.store.entity.User;

public interface UserService {
    void reg(User user);
    User login(String username,String password);
}
