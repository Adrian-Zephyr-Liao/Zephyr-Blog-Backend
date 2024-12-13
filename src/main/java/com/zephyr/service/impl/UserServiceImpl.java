package com.zephyr.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zephyr.mapper.UserMapper;
import com.zephyr.model.entity.User;
import com.zephyr.service.intf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    public boolean login(String email, String password) {
        User user = userMapper.findByEmail(email);
        if (user != null) {
            // 使用PasswordEncoder的matches方法来比较未加密密码和存储的加密密码
            return passwordEncoder.matches(password, user.getPassword());
        }
        return false;
    }

    public User register(User user) {
        // 检查邮箱是否已存在
//        User existingEmail = userMapper.findByEmail(user.getEmail());
//        if (existingEmail != null) {
//            throw new IllegalArgumentException("邮箱已存在，请使用其他邮箱注册");
//        }
//        // 对用户输入的密码进行加密处理
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userMapper.insert(user);
        return user;
    }
}

