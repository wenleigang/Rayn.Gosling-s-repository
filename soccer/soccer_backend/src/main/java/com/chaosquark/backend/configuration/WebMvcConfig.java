package com.chaosquark.backend.configuration;

import com.chaosquark.backend.interceptor.GlobalExceptionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName: WebMvcConfig
 * @Description: java类作用描述
 * @Author: Rayn.Gosling
 * @CreateDate: 2018/4/21/021 12:01
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/4/21/021 12:01
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new GlobalExceptionInterceptor()).addPathPatterns("/**");
    }
}
