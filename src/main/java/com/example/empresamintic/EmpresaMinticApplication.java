package com.example.empresamintic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class EmpresaMinticApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmpresaMinticApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://127.0.0.1:5173/","https://eclectic-tiramisu-cfac32.netlify.app/").allowedMethods("*").allowedHeaders("*");
            }
        };
    }
}
