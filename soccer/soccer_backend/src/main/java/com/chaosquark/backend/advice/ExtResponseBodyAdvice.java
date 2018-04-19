package com.chaosquark.backend.advice;

import com.alibaba.fastjson.JSON;
import com.chaosquark.backend.annotation.WareResponseBody;
import com.chaosquark.backend.common.enums.ResponseStatusEnum;
import com.chaosquark.backend.entity.vo.ResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @ClassName: ExtResponseBodyAdvice
 * @Description: java类作用描述
 * @Author: Rayn.Gosling
 * @CreateDate: 2018/4/19/019 16:11
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/4/19/019 16:11
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */

@ControllerAdvice
public class ExtResponseBodyAdvice<T> implements ResponseBodyAdvice<T> {
    private final Logger logger = LoggerFactory.getLogger(ExtResponseBodyAdvice.class);

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {

        // 默认返回false,修改为返回true,否则不会执行beforeBodyWrite方法;
        if(methodParameter != null) {
            if(methodParameter.getMethod() != null && methodParameter.getMethod().getDeclaringClass() != null) {
                if(methodParameter.getMethod().getDeclaringClass().getAnnotation(WareResponseBody.class) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public T beforeBodyWrite(T t, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        if(t instanceof ResponseVo){
            ((ResponseVo) t).setUri(serverHttpRequest.getURI().getPath());
            return (T) JSON.toJSON(t);
        }

        ResponseVo<T> responseDto = new ResponseVo<>(ResponseStatusEnum.OK);
        responseDto.setUri(serverHttpRequest.getURI().getPath());
        responseDto.setData(t);
        if(t instanceof String) {
            return (T) JSON.toJSONString(responseDto);
        }else{
            return (T) JSON.toJSON(responseDto);
        }
    }
}
