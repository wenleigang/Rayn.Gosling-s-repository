package com.chaosquark.backend.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * @ClassName: GlobalExceptionInterceptor
 * @Description: java类作用描述
 * @Author: Rayn.Gosling
 * @CreateDate: 2018/4/21/021 11:45
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/4/21/021 11:45
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class GlobalExceptionInterceptor implements HandlerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String accept = request.getHeader("accept");
        logger.info("进入controller之前执行。。。。。。。。。。。。。"+accept);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("进入controller之后，渲染视图之前执行。。。。。。。。。。。。。");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("渲染调用完成后执行。。。。。。。。。。。。。");
    }
}
