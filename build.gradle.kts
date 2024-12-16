plugins {
    id("org.springframework.boot") version "3.4.0" // 使用最新版本的Spring Boot
    id("io.spring.dependency-management") version "1.1.6" // 管理依赖版本
    id("io.freefair.lombok") version "8.11" // 使用lombok
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
    // 添加 Spring Security 依赖，用于安全配置
    implementation("org.springframework.boot:spring-boot-starter-security")
    // 开发时，使用热部署工具，添加 Spring Boot DevTools
    compileOnly("org.springframework.boot:spring-boot-devtools")
    // 用于密码加密（BCrypt 等算法），添加 Spring Security Crypto 模块依赖
    implementation("org.springframework.security:spring-security-crypto:6.4.1")
    // 添加 Spring Security OAuth2 客户端依赖
//    implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
    // 添加JUnit 5依赖，用于编写单元测试
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    // 添加JUnit 5引擎依赖
    testImplementation("org.junit.jupiter:junit-jupiter")
    // MySQL 驱动依赖，用于连接MySQL数据库
    runtimeOnly("com.mysql:mysql-connector-j")
    // 添加 jsonwebtoken 依赖，用于生成和验证 JSON Web Tokens
    implementation("io.jsonwebtoken:jjwt-api:0.11.5")
    // 添加 jsonwebtoken 实现依赖
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
    // 添加 jsonwebtoken 依赖，用于与 Jackson 库集成
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")
    // 添加 MyBatis-Plus 依赖，简化 MyBatis 开发
    implementation("com.baomidou:mybatis-plus-spring-boot3-starter:3.5.9")
    // 添加日志依赖，用于记录应用程序日志
    implementation("org.slf4j:slf4j-api:2.0.16")
}

tasks.test {
    useJUnitPlatform()
}