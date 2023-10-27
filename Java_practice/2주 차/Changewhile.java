package org.example;

/* [4-5] 다음의 for문을 while문으로 변경하시오. */

public class Changewhile {
    public static void main(String[] args) {
        int i = 1;

        while(true) {
            System.out.print("*".repeat(i)); // String 클래스의 repeat() 메서드 사용 (지정한 문자열을 입력한 횟수(정수)만큼 반복한다.)
            System.out.println();

            if(i < 10) i++; // 별을 10줄 찍을 수 있도록 i를 1씩 증가
            else break; // 별을 10줄 모두 찍으면(i가 10이면) while문 종료
        }
    }
}
