package com.example2.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class ThrowingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ThrowingAspect.class);

    @AfterThrowing(pointcut = "execution(* com.example2.service.CatServiceImpl.addCat(..))", throwing = "exception", argNames = "exception")
    public void processException(IllegalArgumentException exception) {
        LOGGER.error("ThrowingAspect:@AfterThrowing {}", exception.getMessage());
    }

    @Around("@annotation(com.example2.aspects.CatchException)")
    public Object catchException(ProceedingJoinPoint joinPoint) {
        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            LOGGER.error("ThrowingAspect: @CatchException: {}", e.getMessage());
        }
        return null;
    }
}
