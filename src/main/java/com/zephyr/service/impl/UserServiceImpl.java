package com.zephyr.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zephyr.constant.RoleEnum;
import com.zephyr.mapper.RoleMapper;
import com.zephyr.mapper.UserMapper;
import com.zephyr.mapper.UserRoleMapper;
import com.zephyr.model.entity.Role;
import com.zephyr.model.entity.User;
import com.zephyr.model.entity.UserRole;
import com.zephyr.service.intf.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final RoleMapper roleMapper;
    private final UserRoleMapper userRoleMapper;

    @Autowired
    public UserServiceImpl(PasswordEncoder passwordEncoder, UserMapper userMapper, RoleMapper roleMapper, UserRoleMapper userRoleMapper) {
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.roleMapper = roleMapper;
        this.userRoleMapper = userRoleMapper;
    }

    public boolean login(String email, String password) {
        User user = userMapper.findByEmail(email);
        if (user != null) {
            // 使用PasswordEncoder的matches方法来比较未加密密码和存储的加密密码
            return passwordEncoder.matches(password, user.getPassword());
        }
        return false;
    }

    @Transactional
    public User register(User user) {
        logger.info("开始用户注册流程");

        // 检查邮箱是否已存在
        checkEmailExistence(user.getEmail());

        // 对用户输入的密码进行加密处理
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // 插入用户并获取生成的ID
        long userId = userMapper.insertWithGeneratedKey(user);

        // 插入用户角色关联
        insertUserRole(userId, RoleEnum.USER.getName());

        logger.info("用户注册成功，用户ID：{}", userId);

        return user;
    }

    private void checkEmailExistence(String email) {
        User existingEmail = userMapper.findByEmail(email);
        if (existingEmail != null) {
            throw new IllegalArgumentException("邮箱已存在，请使用其他邮箱注册");
        }
    }

    private void insertUserRole(long userId, String roleName) {
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);

        Role normalUserRole = roleMapper.findByName(roleName);
        if (normalUserRole == null) {
            throw new IllegalStateException("角色不存在: " + roleName);
        }

        userRole.setRoleId(normalUserRole.getId());
        userRoleMapper.insert(userRole);
    }
}

