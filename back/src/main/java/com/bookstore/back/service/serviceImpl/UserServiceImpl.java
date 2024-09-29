package com.bookstore.back.service.serviceImpl;

import com.bookstore.back.domain.User;
import com.bookstore.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookstore.back.repository.UserDao;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao; // 注入 UserDao
    @Override
    public User loginService(String uname, String password) {
        // 如果账号密码都对则返回登录的用户对象，若有一个错误则返回null
        User user = userDao.findByUsernameAndPassword(uname, password);
        // 如果用户存在，验证密码是否正确
        if (user != null && user.getPassword().equals(password)) {
            // 清除敏感信息（如密码）
            user.setPassword("");
            // 你可以在这里生成一个 session 或者 token，返回用户对象
            // 比如：user.setToken(generateToken(user));
            return user;
        } else {
            // 如果用户不存在或者密码不正确，返回 null
            return null;
        }
    }

    @Override
    public User registService(User user) {
        //当新用户的用户名已存在时
        if(userDao.findByUsername(user.getUsername())!=null){
            // 无法注册
            return null;
        }else{
            //返回创建好的用户对象(带uid)
            User newUser = userDao.save(user);
            if(newUser != null){
                newUser.setPassword("");
            }
            return newUser;
        }
    }
}
