package kr.re.kitri.springposts.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ExecutionTimeAspect {
    @Around("execution(* kr.re.kitri.springposts.controller.*.*(..))")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{
        //메소드 시작 전 수행코드
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        //메소드 수행 후 수행코드
        long endTime = System.currentTimeMillis();
        long executionTime = endTime-startTime;
        String methodName = joinPoint.getSignature().getName();
        log.info("{} 실행시간 = {} ms", methodName, executionTime);
        return result;

    }
}
