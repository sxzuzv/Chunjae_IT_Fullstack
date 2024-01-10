package kr.co.chunjae.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Example04Controller {
    @GetMapping("/exam04")
    public void handleRequest() {
        throw new Example03Exception();
    }
}
