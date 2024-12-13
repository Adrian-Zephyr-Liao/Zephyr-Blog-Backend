package com.zephyr.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("`user`")
public class User {

    // Getter 和 Setter 方法
    private Long id;
    private String username;
    private String password;
    private String email;
}
