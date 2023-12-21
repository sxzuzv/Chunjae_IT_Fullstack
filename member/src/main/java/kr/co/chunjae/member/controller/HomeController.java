package kr.co.chunjae.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {
    // 요청명 "/"가 입력되면, index() 메소드가 실행된다.
    // index() 메소드의 실행으로 index.jsp(view)가 출력된다.
    @GetMapping("/")
    public String index() { return "index"; };

}
