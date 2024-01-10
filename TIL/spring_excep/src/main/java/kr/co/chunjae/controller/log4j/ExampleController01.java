package kr.co.chunjae.controller.log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExampleController01 {
    /* Logger : Log4j에서 지원하는 핵심 클래스로, 로그 출력 여부는 로깅 레벨에 따라 결정되며 로그 정보는 appender에 전달된다.
    * 로깅 레벨 : TRACE < DEBUG < INFO < WARN < ERROR < FATAL
    * 로그 출력 시, 설정한 레벨 이상의 로그 정보가 출력된다.
    * (INFO 레벨 이상을 출력할 시, INFO, WARN, ERROR< FATAL의 로그까지 출력된다.) */
    public static Logger logger = LoggerFactory.getLogger(ExampleController01.class);

    @GetMapping("/log4j/exam01")
    public String requestMethod(Model model) {
        // log4j.xml의 <root> 요소 내 로그 레벨을 INFO로 설정하였으므로, INFO 레벨 이상의 모든 메시지를 출력하게 된다.
        // 즉, 콘솔에는 INFO, WARN, ERROR 레벨의 메시지가 출력된다.
        logger.trace("Trace 메시지");
        logger.debug("debug 메시지");
        logger.info("info 메시지");
        logger.warn("warn 메시지");
        logger.error("error 메시지");

        return "webpage_log4j";
    }
}
