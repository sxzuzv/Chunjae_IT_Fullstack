package kr.co.chunjae.springboot_exam.controller;

import kr.co.chunjae.springboot_exam.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    // SpringBoot의 경우, 요청명에 '/(root 하위를 의미)'를 적어주지 않아도 된다.
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello");
        return "index";
    }

    // 쿼리스트링을 통해 매개변수를 전달 받는다.
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-spring")
    @ResponseBody // 별도의 웹 페이지(view)가 필요하지 않다.
    public String helloSpring(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody // 별도의 웹 페이지(view)가 필요하지 않다.
    public Member helloApi (@RequestParam("name") String name) {
        // Member 인스턴스를 생성한다.
        Member member = new Member();
        // Member 인스턴스의 name 필드 값을 설정한다.
        member.setName(name);

        // Member 인스턴스 반환 시, 웹 페이지에는 JSON 형태로 데이터가 표시된다.
        // 예시) {"name": "name 값"}
        return member;
    }




}
