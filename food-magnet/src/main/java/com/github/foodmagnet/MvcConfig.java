package com.github.foodmagnet;

import com.github.foodmagnet.Models.AuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");

    }
    @Bean
    public AuthenticationFilter authFilter() {
        return new AuthenticationFilter();
    }

    // Register the filter with the Spring container

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor( authFilter()).excludePathPatterns( "/view/**");;
    }
}
