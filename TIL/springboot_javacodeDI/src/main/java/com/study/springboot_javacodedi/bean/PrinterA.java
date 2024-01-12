package com.study.springboot_javacodedi.bean;

import com.study.springboot_javacodedi.bean.Printer;

public class PrinterA implements Printer {
    /* @Override : 부모 클래스나 인터페이스로부터 애너테이션 바로 다음의 메서드를 오버라이딩 했다는 의미이다.
    애너테이션 없이 개발자가 메서드명을 직접 입력하여 오버라이딩 했는데 메서드명에 오타를 냈을 시, 자바 컴파일러는 새로운 메서드로 인식하게 된다.
     */
    @Override
    // Printer interface의 print(String message) 메서드를 오버라이딩한다.
    public void print(String message) {
        System.out.println("Printer A : " + message);
    }

}
