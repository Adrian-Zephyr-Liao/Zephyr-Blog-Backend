plugins {
    id("org.springframework.boot") version "2.7.5" // 使用最新版本的Spring Boot
    id("io.spring.dependency-management") version "1.0.15.RELEASE" // 管理依赖版本
    id("java")
}

group = "com.zephyr"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // 添加Spring Boot Starter Web依赖，用于构建Web应用程序
    implementation("org.springframework.boot:spring-boot-starter-web")
    // Spring Data JPA 依赖，用于数据库操作
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    // 用于密码加密（BCrypt 等算法），添加 Spring Security Crypto 模块依赖
    implementation("org.springframework.security:spring-security-crypto")
    // 添加 Spring Security OAuth2 客户端依赖
//    implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
    // 添加 Spring Security 依赖，用于安全配置
    implementation("org.springframework.boot:spring-boot-starter-security")
    // 添加JUnit 5依赖，用于编写单元测试
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    // 添加JUnit 5引擎依赖
    testImplementation("org.junit.jupiter:junit-jupiter")
    // MySQL 驱动依赖，用于连接MySQL数据库
    runtimeOnly("com.mysql:mysql-connector-j")
}

tasks.test {
    useJUnitPlatform()
}