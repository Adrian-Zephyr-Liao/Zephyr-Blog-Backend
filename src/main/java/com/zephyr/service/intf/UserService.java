package com.zephyr.service.intf;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zephyr.model.entity.User;

public interface UserService extends IService<User> {
    // 用户登录验证
    boolean login(String email, String password);
    // 用户注册方法
    User register(User user);
}