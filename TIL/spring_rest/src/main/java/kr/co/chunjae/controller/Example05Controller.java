package kr.co.chunjae.controller;

import kr.co.chunjae.domain.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* @RestController는 별도의 뷰 페이지를 제공하지 않는 형태로 실행하므로, 결과 데이터가 예외적인 오류를 발생시킬 수 있다.
이에 사용자가 직접 결과 데이터와 HTTP 상태 코드를 제어할 수 있다. */
@Controller
@RequestMapping("/exam05")
public class Example05Controller {
    @GetMapping
    public ResponseEntity<Person> submit() {
       Person person = new Person();

        person.setName("soo");
        person.setAge("20");
        person.setEmail("soo@gmail.com");
        System.out.println(person);

        // 결과 데이터가 예외적인 오류를 발생시킬 시 출력할 결과 데이터와 오류 메시지를 지정한다.
        return new ResponseEntity("person", HttpStatus.BAD_REQUEST);
    }
}
