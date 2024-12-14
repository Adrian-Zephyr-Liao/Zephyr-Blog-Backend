   package com.zephyr.model.entity;

   import com.baomidou.mybatisplus.annotation.TableName;
   import lombok.Data;

   @Data
   @TableName("`role`")
   public class Role {
       /**
        * 角色ID
        */
       private Integer id;
       /**
        * 角色名称
        */
       private String name;
       /**
        * 角色描述
        */
       private String description;
   }
   