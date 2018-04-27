package com.chaosquark.backend.configuration;

import com.chaosquark.backend.interceptor.GlobalExceptionInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger logger = LoggerFactory.getLogger(WebMvcConfig.class);

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        logger.info("-----------------------加入自定义拦截器--------------------------------");
        registry.addInterceptor(new GlobalExceptionInterceptor()).addPathPatterns("/**");
    }
}
