package kr.co.chunjae.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// @SuppressWarnings : Java 5.0부터 컴파일 경고를 사용하지 않도록 설정할 수 있는 어노테이션
// 사용자가 의도적으로 설계한 코드를 컴파일러가 오류라고 판단하여 노란색 줄을 띄우는 경우를 막는다.
// 즉, "해당 사항이 오류가 아니다."라는 것을 알린다.
/* "serial" : @SuppressWarnings 내부에서 사용할 수 있는 토큰 중 하나로,
직렬화 가능 클래스에 대한 누락된 serialVersionUID 필드와 관련된 경고를 억제한다.
 */
@SuppressWarnings("serial")
// 클래스에 @ResponseStatus를 선언하여 웹 요청에 대해 예외가 발생하면 지정된 HTTP 404 응답 상태 코드를 웹 브라우저에 전달하여 오류 메시지를 출력한다.
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "찾을 수 없습니다.")
public class Example02Exception extends Exception {
    // 클래스와 동일한 이름의 메서드 = 생성자 (매개변수가 한 개인 생성자)
    public Example02Exception(String message) {
        super(message);

        // console에 메시지를 출력한다.
        System.out.println(message);
    }
}
