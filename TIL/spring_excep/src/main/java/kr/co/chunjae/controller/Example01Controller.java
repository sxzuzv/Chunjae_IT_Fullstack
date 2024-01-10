package kr.co.chunjae.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class Example01Controller {
    /* @ResponseStatus : 웹 요청을 할 때 예외가 발생하면 지정된 HTTP 상태 코드를 웹 브라우저에 전달한다.
    * (ResponseStatusExceptionResolver 클래스에서 제공, 디스패처 서블릿에 기본적으로 등록돼 있으므로 별도로 구성할 필요는 없다.)
    * value 속성 : HttpStatus에 정의되어 있는 HTTP 상태 코드를 지정한다.
    * reason 속성 : 자세한 설명을 설정한다. */
    // @ResponseStatus를 메서드에 선언하여 웹 요청에 대해 예외가 발생하면 지정된 HTTP 400 응답 상태 코드를 웹 브라우저에 전달하여 오류 메시지를 출력한다.
    @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason = "요청 실패하였습니다.")
    @GetMapping("/exam01")
    public String requestMethod(Model model) {
        System.out.println("exam01 예제입니다.");

        model.addAttribute("data", "@ResponseStatus 처리 적용");

        return "webpage01";
    }
}
