package org.crystal.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Slf4j
@Component
public class TryAgainAspect {

    @Pointcut(value = "@annotation(org.crystal.aop.TryAgain)")
    public void pointCut(){}
    @Around("pointCut()&&@annotation(tryAgain)")
    public void Around(ProceedingJoinPoint joinPoint, TryAgain tryAgain) throws Throwable {
        int maxRetry = tryAgain.max_retry();
        int count =0;
        log.info("在方法调用前执行的切面方法");
        try{
            count++;
            joinPoint.proceed();
        }catch (Exception e){
            log.info("重试====================="+count);
            if(count<maxRetry){
                joinPoint.proceed();
            }

        }

        System.out.println("在方法调用前执行的切面方法"+tryAgain.max_retry());
    }
}
