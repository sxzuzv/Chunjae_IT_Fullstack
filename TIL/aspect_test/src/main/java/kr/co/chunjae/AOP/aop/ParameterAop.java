package kr.co.chunjae.AOP.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

// AOP @Aspect, @Component Annotation을 사용한다.
@Aspect
@Component
public class ParameterAop {
    // @Pointcut : AOP를 적용할 위치를 설정한다.
    @Pointcut("execution(* com.example.AOP..*.*(..))")

    private void cut() {

    }

    // @Before : 해당 메소드를 실행하기 이전에 수행한다. (cut()이 해당되는 시점 이전에 수행한다.)
    @Before("cut()")
    public void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();

        // MethodSignature : method의 type을 알 수 있다.
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println("method type :" + method);
        for (Object obj : args) {
            System.out.println("type : " + obj.getClass().getSimpleName());
            System.out.println("value :" + obj);
        }
    }

    // @AfterReturning : 메소드 실행 이후 return 된 object에 접근 가능하다.
    @AfterReturning(value = "cut()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
        System.out.println("returnObj : " + returnObj);
    }
}
