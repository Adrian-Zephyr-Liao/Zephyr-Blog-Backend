package com.zephyr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zephyr.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    User findByEmail(String email);
}
