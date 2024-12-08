package com.zephyr.service.impl;

import com.zephyr.model.entity.User;
import com.zephyr.service.intf.UserService;
import com.zephyr.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;
import java.util.UUID;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @PersistenceContext
    private EntityManager entityManager;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public boolean login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user!= null) {
            // 使用PasswordEncoder的matches方法来比较未加密密码和存储的加密密码
            return passwordEncoder.matches(password, user.getPassword());
        }
        return false;
    }

    @Override
    public User register(User user) {
        // 检查邮箱是否已存在
        User existingEmail = userRepository.findByEmail(user.getEmail());
        if (existingEmail != null) {
            throw new IllegalArgumentException("邮箱已存在，请使用其他邮箱注册");
        }
        // 对用户输入的密码进行加密处理
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }
}