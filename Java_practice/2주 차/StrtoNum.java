package org.example;

/* [4-9] 숫자로 이루어진 문자열 str이 있을 때, 각 자리의 합을 더한 결과를 출력하는 코드를 완성하라.
* 만일 문자열이 "12345"라면, '1+2+3+4+5'의 결과인 15가 출력되어야 한다. */

public class StrtoNum {
    public static void main(String[] args) {
        String str = "12345";
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            // charAt() 함수는 문자열의 인덱스에 해당하는 문자를 char 타입으로 변환한다.
            // char 타입으로 변환된 문자를 아스키 코드를 활용(- '0')하여 정수 타입으로 변환한다.
            // 인덱스에 해당하는 문자를 모두 정수 타입으로 변환하고, 정수형 변수 sum에 더한다.
            sum += str.charAt(i) - '0';
        }

        System.out.println(sum);
    }
}
