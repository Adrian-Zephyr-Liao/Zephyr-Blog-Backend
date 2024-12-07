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
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    // 添加Spring Boot Starter Web依赖，用于构建Web应用程序
    implementation("org.springframework.boot:spring-boot-starter-web")
}

tasks.test {
    useJUnitPlatform()
}