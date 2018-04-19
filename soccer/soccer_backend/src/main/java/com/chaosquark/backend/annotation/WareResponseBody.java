package com.chaosquark.backend.annotation;

import java.lang.annotation.*;

/**
 * @ClassName: WareResponseBody
 * @Description: 自定义包装返回值的注解
 * @Author: Rayn.Gosling
 * @CreateDate: 2018/4/19/019 17:42
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/4/19/019 17:42
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WareResponseBody {
    String value() default "";
}
