package kr.co.chunjae.controller;

import kr.co.chunjae.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@RequestMapping("/exam03")
public class Example03Controller {
    @GetMapping
    /* @ResponseBody : 자바 객체를 HTTP 응답 body 내용으로 매핑하는 역할을 한다. */
    // @RequestBody처럼 XML이나 JSON 형식을 갖춘 문자열 형태로 응답할 때 이용한다.
    // controller 내 요청 처리 메서드 수준으로 설정하며, 요청 처리 메서드의 반환 결과 값을 HTTP 응답 body 내용으로 전달한다.
    // @ResponseBody가 선언된 메서드의 반환 결과 값은 JSON 형식으로 변환해서 응답한다.
    public @ResponseBody Person submit() {
       Person person = new Person();

        person.setName("soo");
        person.setAge("20");
        person.setEmail("soo@gmail.com");
        System.out.println(person);
        
        // 별도의 view가 없이도 웹 페이지에서 값을 확인할 수 있다.
        return person;
    }
}
