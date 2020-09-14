package com.jason.demo.http.aspect;

import com.jason.demo.http.annotation.RetryProcess;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: jason
 * @Date: 2020-09-14
 */
@Aspect
@Component
public class AspectExceptionInterceptor {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @AfterThrowing(pointcut = ("execution(* com.jason.demo.http..*(..)) && @annotation(com.jason.demo.http.annotation.RetryProcess)"))
    public void tryAgain(JoinPoint point) {
        try {
            Object object = point.getTarget();
            MethodSignature methodSignature = (MethodSignature)point.getSignature();
            RetryProcess retryProcess = methodSignature.getMethod().getAnnotation(RetryProcess.class);

            if (atomicInteger.intValue() < retryProcess.value()) {
                int i = atomicInteger.incrementAndGet();

                // 阻塞i秒后再进行重试，如果网络问题立即重试失败几率非常大所以建议阻塞一下再试
                Thread.sleep(1000 * i);

                logger.info("开始重试第" + i + "次");
                MethodInvocationProceedingJoinPoint methodPoint = ((MethodInvocationProceedingJoinPoint)point);
                // 再次调用方法
                methodPoint.proceed();
            }
        } catch (Throwable throwable) {
            // 捕获到异常后再次重试
            tryAgain(point);
        }
    }
}
