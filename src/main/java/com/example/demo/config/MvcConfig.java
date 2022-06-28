package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Path employeeUploadDir = Paths.get("./photos");
        String employeeUploadPath = employeeUploadDir.toFile().getAbsolutePath();
        registry.addResourceHandler("/photos/**").addResourceLocations("file:/" + employeeUploadPath + "/");
    }
}
