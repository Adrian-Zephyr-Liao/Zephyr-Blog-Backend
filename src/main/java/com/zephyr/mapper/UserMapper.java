package com.zephyr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zephyr.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserMapper extends BaseMapper<User> {
    User findByEmail(@Param("email") String email);
    @Options(useGeneratedKeys = true, keyProperty = "id")
    default long insertWithGeneratedKey(@Param("user") User user) {
        insert(user);
        return user.getId();
    }
}
