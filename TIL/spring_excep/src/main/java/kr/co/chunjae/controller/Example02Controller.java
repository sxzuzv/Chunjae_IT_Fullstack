package kr.co.chunjae.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Example02Controller {
    @GetMapping("/exam02")
    public void handleRequest() throws Exception {
        // Example02Exception에서 설정한 오류 메시지를 웹 페이지에 출력한다.
        // HTTP 상태 코드 = 404, reason = "찾을 수 없습니다.", message = "Example02Exception 메시지입니다."
        throw new Exception(new Example02Exception("Example02Exception 메시지입니다."));
    }
}
