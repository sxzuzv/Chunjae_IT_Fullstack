package com.study.springboot_javacodedi;

import com.study.springboot_javacodedi.bean.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// @SpringBootApplication : Spring Boot는 해당 애너테이션에 의해 자동으로 설정이 이루어지고 컴포넌트가 등록된다.
//@SpringBootApplication
public class SpringbootJavacodeDiApplication {
    // main 메서드 실행 시, Config 클래스가 Bean으로 등록된 것을 콘솔창에서 확인 가능하다. (Bean으로 등록된 항목들을 확인할 수 있다.)
    // 생성된 Bean은 Singleton 형태로, Spring Container에서 객체 생성은 기본적으로 Singleton 형태로 제공된다.
    public static void main(String[] args) {
//        SpringApplication.run(SpringbootJavacodeDiApplication.class, args);

        // IoC Container를 생성한다.
        // 설정용 자바 파일(Config.java)을 AnnotationConfigApplicationContext에 파라미터로 넘겨서 ApplicationContext를 만든다.
        // 만든 ApplicationContext를 ApplicationContext 클래스 타입의 context 변수에 할당한다.
        // => AnnotationConfigApplicationContext 클래스 타입으로 객체를 생성한 뒤, ApplicationContext 클래스 타입의 변수에 할당한다.
        // => '자식 객체를 부모 객체에 대입할 수 있다' : 디자인 패턴의 적용
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    }
}
