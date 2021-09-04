package com.zhouchb.blog.config;

import com.zhouchb.blog.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author Zhouchb
 * @Create 2021-09-2021/9/4 :16:16
 * @Description
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(new LoginInterceptor())
               .addPathPatterns("/admin/**")
               .excludePathPatterns("/admin/login","/admin");
    }
}
