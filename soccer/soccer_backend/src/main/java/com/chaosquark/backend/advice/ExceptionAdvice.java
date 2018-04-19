package com.chaosquark.backend.advice;

import com.chaosquark.backend.entity.BizException;
import com.chaosquark.backend.entity.vo.ResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

/**
 * @ClassName: ExceptionAdvice
 * @Description: 统一异常处理类
 * @Author: Rayn.Gosling
 * @CreateDate: 2018/4/19/019 11:32
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/4/19/019 11:32
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@ControllerAdvice
public class ExceptionAdvice<T> {
    private final Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<T> exceptionHandler(Exception exception, WebRequest request) {
        exception.printStackTrace();

        ResponseVo responseVo = null;
        if(exception instanceof BizException) {
            responseVo = new ResponseVo((BizException) exception);
            logger.error(((BizException) exception).getMsg(), exception);
        }else{
            BizException bizException = new BizException(exception);
            responseVo = new ResponseVo(bizException);
            logger.info(exception.getMessage());
        }
        return new ResponseEntity(responseVo, HttpStatus.OK);
    }
}
