package com.zephyr.constant;

import lombok.Getter;

@Getter
public enum RoleEnum {
    ADMIN("ADMIN", "管理员"),
    USER("NORMAL_USER", "普通用户");
    private final String name;
    private final String description;

    RoleEnum(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
