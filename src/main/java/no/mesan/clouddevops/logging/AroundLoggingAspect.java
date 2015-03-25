package no.mesan.clouddevops.logging;

import com.microsoft.applicationinsights.TelemetryClient;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class AroundLoggingAspect {

    private TelemetryClient telemetry = new TelemetryClient();

    @Around("execution(* no.mesan.clouddevops..*(..))")
    public Object aroundBeanMethods(ProceedingJoinPoint pjp) throws Throwable {

        MethodSignature signature = (MethodSignature) pjp.getSignature();
        String className = signature.getDeclaringTypeName();
        Method method = signature.getMethod();
        String methodName = signature.getName();
        Object[] arguments = pjp.getArgs();

        Logger log = LoggerFactory.getLogger(className);
        StopWatch sw = new StopWatch();
        sw.start();

        Object result = null;
        Throwable exception = null;

        try {
            result = pjp.proceed();
        } catch (Throwable e) {
            exception = e;
            throw e;
        } finally {
            sw.stop();

            String output;
            if(exception != null) {
                output = "exception: "+ exception.toString();
            }
            else if(Void.TYPE.equals(method.getReturnType())) {
                output = "(void)";
            }
            else {
                output = "result: " + result;
            }

            String params = String.format("Arguments: %s", arguments.toString());
            String logStr = String.format("%s() duration: %dms arguments: %s %s", methodName, sw.getTotalTimeMillis(), params, output);
            log.info(logStr);

            // custom telemetry
            Map<String, String> properties = new HashMap<String, String>();
            Map<String, Double> metrics = new HashMap<String, Double>();

            properties.put("methodName", methodName);
            metrics.put("processingTime", (double)sw.getLastTaskTimeMillis());
            telemetry.trackEvent("Metodekall", properties, metrics);

        }

        return result;
    }
}



