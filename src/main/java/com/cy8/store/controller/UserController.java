package com.cy8.store.controller;


import com.cy8.store.entity.User;
import com.cy8.store.service.UserService;
import com.cy8.store.service.ex.InsertException;
import com.cy8.store.service.ex.PassWordNoCorrect;
import com.cy8.store.service.ex.UserNoExistException;
import com.cy8.store.service.ex.UserexistException;
import com.cy8.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;


    @RequestMapping("reg")
    public JsonResult<Void> reg(User user){
        JsonResult<Void> jsonResult;
        try {
            userService.reg(user);
        }catch (UserexistException e){
            jsonResult=new JsonResult<Void>(400,"您输入的用户名已经存在，请重新输入");
            return jsonResult;
        }catch (InsertException e){
            jsonResult=new JsonResult<Void>(500,"注册失败，请重新注册");
            return jsonResult;
        }
        return new JsonResult<Void>(200,"注册成功");
    }

    @RequestMapping("login")
    public JsonResult<User> login(String username,String password){
        User user=userService.login(username,password);
        return new JsonResult<User>(OK,user);
    }
}
