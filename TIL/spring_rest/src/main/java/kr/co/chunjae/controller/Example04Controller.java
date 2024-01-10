package kr.co.chunjae.controller;

import kr.co.chunjae.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/* @RestController : @Controller + @ResponseBody, JSON 형태로 데이터를 반환한다. */
// 반환 값에 자동으로 @ResponseBody가 붙어 자바 객체가 HTTP 응답 body 내용에 매핑되어 전달된다.
// @RestController일 경우 @ResponseBody를 사용하지 않아도 되지만, @Controller일 때에는 @ResponseBody를 반드시 선언해야 한다.
@RestController
@RequestMapping("/exam04")
public class Example04Controller {
    @GetMapping
    public Person submit() {
       Person person = new Person();

        person.setName("soo");
        person.setAge("20");
        person.setEmail("soo@gmail.com");
        System.out.println(person);
        
        // 별도의 view가 없이도 웹 페이지에서 값을 확인할 수 있다.
        return person;
    }
}
