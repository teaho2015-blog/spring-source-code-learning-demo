package net.teaho.demo.spring.aop.insideout.support;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

@Aspect
@Component
public class LogAspect {

    private static Logger log = LoggerFactory.getLogger("ThriftAccess");

    @Pointcut("execution(* net.teaho.demo.spring.aop.insideout.controller.DemoController.*(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object printAccessLog(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] param = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getDeclaringType().getSimpleName()
            + "." + joinPoint.getSignature().getName();
        long start = System.currentTimeMillis();
        Object result;
        Throwable throwable = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable t) {
            result = "Exception:" + t.getClass().getSimpleName();
            throwable = t;
        }
        long duration = System.currentTimeMillis() - start;
        log.info("time:{}, method:{}, args:{}, result:{}, throwable:{}", duration, methodName, Arrays.toString(param),
            result, Objects.toString(throwable));
        if (throwable != null) {
            throw throwable;
        }
        return result;
    }
}
