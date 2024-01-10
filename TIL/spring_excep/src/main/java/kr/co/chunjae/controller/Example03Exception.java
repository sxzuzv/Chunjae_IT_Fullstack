package kr.co.chunjae.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@SuppressWarnings("serial")
@Getter
@Setter
public class Example03Exception extends RuntimeException {
    private String errMsg;

    public Example03Exception() {
        super();
        this.errMsg = "Example03Exception 메시지입니다.";
    }
}
