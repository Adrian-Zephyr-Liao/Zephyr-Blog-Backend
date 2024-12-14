package com.zephyr.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户实体类，对应数据库中的User表
 */
@Data
@TableName("`user`")
public class User {
    /**
     * 用户的唯一标识符，使用雪花Id生成方式确保在分布式等场景下的唯一性，长整型
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 用户的登录用户名，用于标识用户身份，可变长度字符串类型
     */
    private String username;

    /**
     * 用户的登录密码，用于验证用户身份，确保安全性，可变长度字符串类型，不能为空
     */
    private String password;

    /**
     * 用户的电子邮箱地址，用于联系用户、验证等用途，可变长度字符串类型，不能为空
     */
    private String email;

    /**
     * 用户记录的创建时间，默认为当前时间，用于记录用户信息首次录入数据库的时间点，时间类型
     */
    private LocalDateTime createdAt;

    /**
     * 用户记录的更新时间，每当用户信息有修改时会自动更新为当前时间，用于跟踪用户信息的最新变动情况，时间类型
     */
    private LocalDateTime updatedAt;
    /**
     * 用户的角色列表，用于描述用户拥有的权限和功能，多对多关系，Role实体类
     */
    private List<Role> roles;
}