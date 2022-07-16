package com.cy8.store.mapper;

import com.cy8.store.entity.User;

public interface Usermapper {
    Integer insert(User user);
    User findByUsername(String username);
}
