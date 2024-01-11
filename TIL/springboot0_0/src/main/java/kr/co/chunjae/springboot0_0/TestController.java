package kr.co.chunjae.springboot0_0;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping(value = "/")
    public String home() {
        System.out.println("TestController HOME");

        return "index";
    }
}
