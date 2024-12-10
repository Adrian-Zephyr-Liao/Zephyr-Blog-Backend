package com.zephyr.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String email;
    private String googleId;
    private String githubId;
}