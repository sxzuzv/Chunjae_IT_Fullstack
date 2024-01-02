package kr.co.chunjae.AOP.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimerAop {
    @Pointcut("execution(* kr.co.chunjae.AOP..*.*(..))")
    private void cut() {

    }

    @Pointcut("@annotation(kr.co.chunjae.AOP.annotation.Timer)")
    private void enableTimer() {

    }

    // @Around : cut(), enableTimer()가 수행될 경우 시간을 측정할 수 있도록 설정한다.
    @Around("cut() && enableTimer()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 시간을 측정할 수 있는 로직을 작성한다.
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = joinPoint.proceed();
        stopWatch.stop();

        System.out.println("total time : " + stopWatch.getTotalTimeSeconds());
    }
}
