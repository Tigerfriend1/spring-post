package kr.re.kitri.springposts.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {
    //controller 시작 전에 실행
    @Before("execution(* kr.re.kitri.springposts.controller.*.*(..))")
    public void loggingController(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        log.info("{}.{} 컨트롤러 동작을 시작하겠습니다.", className, methodName);
    }

    //service 시작 전에 실행
    @Before("execution(* kr.re.kitri.springposts.service.*Impl.*(..))")
    public void loggingService(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        log.info("{}.{} 서비스 동작을 시작합니다.",className,methodName);
    }
}
