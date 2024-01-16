package kr.co.chunjae.springboot_exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
