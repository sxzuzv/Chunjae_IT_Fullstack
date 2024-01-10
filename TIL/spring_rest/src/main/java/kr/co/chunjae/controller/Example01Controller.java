package kr.co.chunjae.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam01")
public class Example01Controller {
    @GetMapping
    public String showForm() {
        return "webpage_01";
    }

    /* @RequestBody : HTTP 요청 body 내용인 XML, JSON 또는 기타 데이터 등을 자바 객체로 매핑하는 역할을 한다. */
    // 일반적으로 폼 페이지에서 전송되는 매개변수가 'name=value' 형태일 시, @RequestParam이나 @ModelAttribute로 전달받는다.
    // 그러나 XML이나 JSON처럼 형식을 갖춘 문자열 형태일 시, @RequestParam이나 @ModelAttribute로 전달받을 수 없다.
    // 이 경우, @RequestBody를 이용하여 매개변수를 전달받는다.
    @PostMapping
    // @RequestBody가 선언된 메서드의 매개변수는 폼 페이지에서 입력된 다중 값을 '&'로 연결된 'name=value' 형태로 전달받는다.
    public String submit(@RequestBody String param, Model model) {
        model.addAttribute("title", "@RequestBody로 정보 받기");
        model.addAttribute("result", param);
        return "webpage_result";
    }
}
