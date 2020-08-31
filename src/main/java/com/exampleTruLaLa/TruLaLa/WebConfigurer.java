package com.exampleTruLaLa.TruLaLa;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
@EnableWebMvc
@ComponentScan
public class WebConfigurer implements WebMvcConfigurer {

    public static String uploadDirectory=System.getProperty("user.home")+"/Images";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
registry.addResourceHandler("/Images/**").addResourceLocations("file:"+ uploadDirectory+"/");

        System.out.println(uploadDirectory+   "OOOOOOOOOOOOOOOO");
    }
}
