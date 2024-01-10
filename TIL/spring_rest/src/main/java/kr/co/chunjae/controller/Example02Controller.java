package kr.co.chunjae.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
public class Example02Controller {
    @GetMapping("/json")
    public String showForm() {
        return "webpage_02";
    }

    // controller 내 요청 처리 메서드의 매개변수에 @RequestBody를 선언하여 JSON 형태로 데이터를 전달받는다.
    // HashMap 타입의 map 객체는 HttpMessageConverter 타입의 메시지 변환기로 JSON 형식으로 전달받는다.
    // 데이터 형식 : {name=kim, age=30}
    @PostMapping("/test")
    public void submit(@RequestBody HashMap<String, Object> map) {
        System.out.println(map);
    }
}
