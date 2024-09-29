package com.bookstore.back.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class GlobalCorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // 添加映射路径，允许所有路径
                        .allowedOrigins("http://localhost:8080") //
                        .allowCredentials(true) // 允许发送 Cookie 信息
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 开放的 HTTP 方法
                        .allowedHeaders("*") // 允许所有请求头
                        .exposedHeaders("*"); // 暴露所有响应头
            }
        };
    }
}
