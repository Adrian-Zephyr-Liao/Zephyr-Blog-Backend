package com.zephyr.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("`user_role`")
public class UserRole {
   /**
    * 用户id
    */
   private Long userId;
   /**
    * 角色id
    */
   private Integer roleId;
}
   