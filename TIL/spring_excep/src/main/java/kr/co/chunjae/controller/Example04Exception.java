package kr.co.chunjae.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/* @ControllerAdvice : 예외 발생을 개별 controller에서 처리하지 않고 전체 애플리케이션에 한 번에 적용할 수 있다.
(하나의 controller가 아닌 여러 controller에서 발생하는 예외를 공통으로 처리할 수 있다.)
 */
// 전체 애플리케이션에 한 번에 예외 처리를 적용시키기 위해, basePackages 속성에 패키지 경로를 적어준다.
@ControllerAdvice(basePackages = {"kr.co"})
public class Example04Exception {
    // @ControllerAdvice를 선언한 클래스에서는 controller에서 설정하는 @ExceptionHandler, @ModelAttribute, @InitBinder가 선언된 메서드를 사용할 수 있다.
    // @ControllerAdvice를 선언한 클래스 안에는 @ExceptionHandler가 선언된 메서드를 여러 개 설정할 수 있고, 예외가 발생하면 어떤 예외 처리를 할지 value 옵션 요소에 지정한다.
    @ExceptionHandler(value = {RuntimeException.class})
    // @ControllerAdvice를 선언한 클래스 Example04Exception 안의 예외 처리를 위한 메서드 handleErrorMethod()에 @ExceptionHandler를 설정한다.
    private ModelAndView handleErrorMethod(Exception ex) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("errorMessage", "Example04Exception 메시지입니다.");
        modelAndView.addObject("exception", ex);
        modelAndView.setViewName("webpage_03");

        return modelAndView;
    }
}
