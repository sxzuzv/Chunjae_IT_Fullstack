package kr.co.chunjae.AOP;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Timer 사용 예제 : AOP를 사용하는 경우
 */

// 시간을 측정해주는 custom annotation을 만든다.
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Timer {

}
