package com.study.springboot_javacodedi.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* @Configuration : 해당 애너테이션이 붙은 클래스는 스프링 설정으로 사용됨을 의미한다. */
@Configuration
public class Config {
    /* @Bean : 해당 애너테이션이 붙은 메서드의 리턴값은 Bean 객체로 사용된다.
        별도의 이름을 지정하지 않을 시, 메서드 이름이 Bean의 이름으로 등록된다.
    * 빈(bean) : Spring이 IoC 방식으로 관리하는 객체
    * 빈 팩토리(BeanFactory) : Spring의 IoC를 담당하는 핵심 컨테이너
    * 애플리케이션 컨텍스트(ApplicationContext) : BeanFactory를 확장한 IoC 컨테이너 */
    @Bean
    public Member member1() {
        // Setter Injection : Setter 메서드를 이용한 의존성 주입
        Member member1 = new Member();
        member1.setName("홍길동");
        member1.setName("도사");
        member1.setPrinter(new PrinterA());

        return member1;
    }

    // @Bean 애너테이션에 이름을 설정할 시, 해당 클래스를 Bean으로 등록할 때 설정한 이름으로 Bean의 이름이 변경된다.
    @Bean(name = "hello")
    public PrinterA printerA() {
        // Constructor Injection : 생성자를 이용한 의존성 주입
        return new PrinterA();
    }

    @Bean
    public PrinterB printerB() {
        return new PrinterB();
    }
}
