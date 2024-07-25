package com.levantine.datagateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    TokenInterceptor tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor).addPathPatterns("/listTokens/**");
        registry.addInterceptor(tokenInterceptor).addPathPatterns("/amIAGoodMouse/**");
        registry.addInterceptor(tokenInterceptor).addPathPatterns("/analytics/**");
    }
}