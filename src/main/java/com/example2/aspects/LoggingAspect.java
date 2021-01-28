package com.example2.aspects;

import com.example2.Cat;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution (* com.example2.*.*ServiceImpl.getCat(..))")
    public void pointcutGetCat() {
    }

    @Around("pointcutGetCat()")
    public Object logGetCat(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        LOGGER.info("LoggingAspect: before method with param {}", args[0]);
        Object cat = joinPoint.proceed();
        LOGGER.info("LoggingAspect: after method with return value {}", cat);
        return cat;
    }

    @Before(value = "execution(* com.example2.service.CatServiceImpl.addCat(..)) && args(id, cat)", argNames = "id, cat")
    public void logAddCat(JoinPoint joinPoint, int id, Cat cat) {
          LOGGER.info("LoggingAspect: Добавляем кота {}, {}", id, cat);
    }

    @Around("@annotation(com.example2.aspects.Log)")
    public Object logMethodWithAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.info("LoggingAspect: annotation Log. Before method");
        Object proceed = joinPoint.proceed();
        LOGGER.info("LoggingAspect: annotation Log. After method");
        return proceed;
    }
}
