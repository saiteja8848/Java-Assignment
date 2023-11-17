package com.centime.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("@annotation(logMethodParam)")
    public void logMethodParams(JoinPoint joinPoint, LogMethodParam logMethodParam) {
        Method method = getMethod(joinPoint);
        if (method != null) {
            logger.info("Method {} parameters: {}", method.getName(), Arrays.toString(joinPoint.getArgs()));
        }
    }

    @AfterReturning(pointcut = "@annotation(logMethodParam)", returning = "result")
    public void logMethodResult(JoinPoint joinPoint, LogMethodParam logMethodParam, Object result) {
        Method method = getMethod(joinPoint);
        if (method != null) {
            logger.info("Method {} result: {}", method.getName(), result);
        }
    }

    private Method getMethod(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        if (signature instanceof MethodSignature) {
            MethodSignature methodSignature = (MethodSignature) signature;
            return methodSignature.getMethod();
        }
        return null;
    }
}

