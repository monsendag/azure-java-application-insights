package no.mesan.clouddevops.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundLoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(AroundLoggingAspect.class);

    @Around("execution(* no.mesan.clouddevops..*.*(..))")
    public Object aroundBeanMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("Entering: " + proceedingJoinPoint);

        Object returnValue = proceedingJoinPoint.proceed();

        logger.info("Completed: " + proceedingJoinPoint);

        return returnValue;
    }

}
