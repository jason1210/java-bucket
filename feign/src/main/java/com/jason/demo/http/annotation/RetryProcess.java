package com.jason.demo.http.annotation;

/**
 * @author: jason
 * @Date: 2020-09-14
 */

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface RetryProcess {
    //重试的次数
    int value() default 1;
}
