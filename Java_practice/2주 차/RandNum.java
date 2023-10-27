package org.example;

/* [4-7] Math.random()을 이용해서 1부터 6사이의 임의의 정수를 변수 value에 저장하는 코드를 완성하라. */
public class RandNum {
    public static void main(String[] args) {
        // Math.random() : 0.0 이상 ~ 1.0 미만 사이의 double형 값을 반환하는 함수
        int value = (int) (Math.random() * 6) + 1;

        System.out.println("value : " + value);
    }
}
