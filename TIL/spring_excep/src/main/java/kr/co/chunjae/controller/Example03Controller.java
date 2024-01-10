package kr.co.chunjae.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Example03Controller {
    @GetMapping("/exam03")
    public void handleRequest() {
        throw new Example03Exception();
    }

    /* @ExceptionHandler : 웹 요청에 따라 controller의 요청 처리 메서드를 실행하는 동안
     * 예외가 발생하면 이를 처리하기 위해 예외 처리 메서드에 사용한다.
     * value 속성 : 예외 처리를 담당하는 클래스 이름을 설정한다. (생략 가능)
     * 속성을 생략하고 @ExceptionHandler만 사용할 시, 예외 처리 메서드의 매개변수로 예외 처리를 담당하는 클래스가 반드시 설정되어 있어야 한다. */
    // @ExceptionHandler를 사용하면 @ResponseStatus 없이 발생한 예외를 처리할 수 있다.
    // 또한, controller 안의 요청 처리 메서드가 발생한 오류나 예외를 직접 구체화하여 처리할 수 있다.
    // => 발생한 예외 정보를 얻을 수 있고, 특정한 뷰 페이지로 이동이 가능하여 사용자가 직접 예외 처리에 응답할 수 있다.
    @ExceptionHandler(Example03Exception.class)
    // 예외 처리 메서드인 handleException()에 @ExceptionHandler를 선언하여 웹 요청에 따라 컨트롤러 안의 요청 처리 메서드에서 발생한 오류를 직접 예외 처리한다.
    public ModelAndView handleException(Example03Exception ex) {
        ModelAndView model = new ModelAndView();

        model.addObject("errorMessage", ex.getErrMsg());
        model.addObject("exception", ex);
        model.setViewName("webpage_03");

        return model;
    }
}
