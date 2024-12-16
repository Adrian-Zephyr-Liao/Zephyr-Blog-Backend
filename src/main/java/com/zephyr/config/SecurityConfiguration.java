package com.zephyr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
class SecurityConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:3000");
        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    /**
     * 配置SecurityFilterChain bean，以定义Web安全设置
     * 该方法主要用于配置HTTP安全设置，包括禁用表单登录、HTTP基本认证、匿名访问、CSRF保护和注销功能，
     * 同时启用CORS并配置请求授权规则
     *
     * @param http HttpSecurity实例，用于配置Web安全设置
     * @return 配置好的SecurityFilterChain实例
     * @throws Exception 配置过程中可能抛出的异常
     */
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
            // 禁用表单登录
            .formLogin(AbstractHttpConfigurer::disable)
            // 禁用匿名访问
            .anonymous(AbstractHttpConfigurer::disable)
            // 禁用CSRF保护
            .csrf(AbstractHttpConfigurer::disable)
            // 禁用注销功能
            .logout(AbstractHttpConfigurer::disable)
            // 配置CORS，使用预定义的CorsConfigurationSource
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            // 配置请求授权规则
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    // 允许所有用户访问"/auth/login"和"/auth/register"路径
                    .requestMatchers("/auth/login", "/auth/register").permitAll()
                    // 其他所有请求都需要经过身份验证
                    .anyRequest().authenticated()
            );
        // 构建并返回配置好的SecurityFilterChain实例
        return http.build();
    }
}