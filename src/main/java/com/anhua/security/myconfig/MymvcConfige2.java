package com.anhua.security.myconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MymvcConfige2 implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/111").setViewName("11/1");
        registry.addViewController("/112").setViewName("11/2");
        registry.addViewController("/221").setViewName("22/1");
        registry.addViewController("/222").setViewName("22/2");
        registry.addViewController("/33").setViewName("33/33");
    }

}
