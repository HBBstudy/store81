package com.cy8.store.service.impl;

import com.cy8.store.entity.User;
import com.cy8.store.mapper.Usermapper;
import com.cy8.store.service.UserService;
import com.cy8.store.service.ex.InsertException;
import com.cy8.store.service.ex.PassWordNoCorrect;
import com.cy8.store.service.ex.UserNoExistException;
import com.cy8.store.service.ex.UserexistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private Usermapper usermapper;
    @Override
    public void reg(User user) {
        String username=user.getUsername();
        User result=usermapper.findByUsername(username);
        if(result!=null){
            throw new UserexistException("您输入的用户名已存在，请更换其他用户名");
        }
        String salt= UUID.randomUUID().toString();
        String Md5password=getMD5Password(salt,user.getPassword());
        User newUser=new User();
        newUser.setUsername(username);
        newUser.setPassword(Md5password);
        newUser.setSalt(salt);
        Integer rows=usermapper.insert(newUser);
        if(rows!=1){
            throw  new InsertException("插入出现问题");
        }
    }

    @Override
    public User login(String username, String password) {
        User result=usermapper.findByUsername(username);
        if(result==null){
            throw  new UserNoExistException("用户并不存在");
        }
        String salt=result.getSalt();
        String sqlPassword=result.getPassword();
        String MD5Password=getMD5Password(salt,password);
        if(!sqlPassword.equals(MD5Password)){
            throw new PassWordNoCorrect("您输入的密码不正确");
        }

        return result;
    }

    private String getMD5Password(String salt,String password){
        for (int i = 0; i < 3; i++) {
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        return password;
    }
}
