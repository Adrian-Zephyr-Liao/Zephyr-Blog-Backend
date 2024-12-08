package com.zephyr.controller;

import com.zephyr.constant.ErrorCodes;
import com.zephyr.model.entity.User;
import com.zephyr.model.response.ApiResponse;
import com.zephyr.model.response.ErrorResponse;
import com.zephyr.service.intf.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // 本地登录
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> requestBody) {
        // password 需要解密后再进行验证
        String password = requestBody.get("password");
        String email = requestBody.get("email");
        boolean success = userService.login(email, password);
        if (success) {
            ApiResponse<String> response = new ApiResponse<>(true, null, "Login successful");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            ErrorResponse errorResponse = new ErrorResponse(ErrorCodes.AUTH_001.name(), ErrorCodes.AUTH_001.getMessage(), "/auth/login");
            return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
        }
    }

    // 用户注册
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            User registeredUser = userService.register(user);
            ApiResponse<User> response = new ApiResponse<>(true, registeredUser, "User registered successfully");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorCodes.AUTH_002.name(), e.getMessage(), "/auth/register");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(ErrorCodes.AUTH_003.name(), e.getMessage(), "/auth/register");
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // github Auth2 登录
}