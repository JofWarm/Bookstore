package com.bookstore.back.controller;

import com.bookstore.back.request.LoginRequest;
import com.bookstore.back.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bookstore.back.domain.User;
import com.bookstore.back.utils.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.annotation.Resource;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result<User> loginController(@RequestBody LoginRequest loginRequest) {
        User user = userService.loginService(loginRequest.getUsername(), loginRequest.getPassword());
        if (user != null) {
            return Result.success(user, "登录成功");
        } else {
            return Result.error("123", "账号或密码错误！");
        }
    }


    @PostMapping("/register")
    public Result<User> registController(@RequestBody User newUser){
        User user = userService.registService(newUser);
        if(user!=null){
            return Result.success(user,"注册成功！");
        }else{
            return Result.error("456","用户名已存在！");
        }
    }

}
