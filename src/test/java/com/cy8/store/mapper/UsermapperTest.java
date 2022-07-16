package com.cy8.store.mapper;


import com.cy8.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UsermapperTest {
    @Autowired
    private  Usermapper usermapper;

    @Test
    public void insertTest(){
        User user=new User();
        user.setUsername("test0009");
        user.setPassword("test0009");
        System.out.println(usermapper.insert(user));
    }

    @Test
    public void findByUsername(){
        System.out.println(usermapper.findByUsername("test001"));
    }
}
