package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class MainController {
    // 경로 설정 방법은 여러 개 존재한다.
    // Get, Post 지정해서 url 설정이 가능하다.
    // => @GetMapping, @PostMapping 애너테이션을 사용하여
    // 해당 URL로 들어오는 요청은 반드시 Get 혹은 Post로 메서드를 사용한다고 명시한다.
    
    // @RestController의 경우, 다양한 자료형을 return 할 수 있다.
    @GetMapping("/")
    public HashMap index() {
        HashMap result = new HashMap();
        result.put("status", "UP");

        // HashMap에 넣은 데이터를 JSON 정보로 알아서 컨버팅하여 API를 통해 보낸다.
        return result;
    }
}
