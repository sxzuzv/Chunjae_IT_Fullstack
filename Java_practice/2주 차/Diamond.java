package org.example;

import java.util.Scanner;

public class Diamond {
    public static void main(String[] args) {
        // 다이아몬드 뒷 공백은 생각 X
        // 한 행의 공백 수와 별의 갯수를 알고 삼항 연산자를 통해 찍는다.

        Scanner scan = new Scanner(System.in);
        System.out.println("===== 다이아몬드 별 생성 =====");
        System.out.printf("홀수를 입력하세요. : ");

        int count = scan.nextInt();

        int num = count / 2;

        // 세로만큼 반복문 실행(세로 개수 = 입력 홀수만큼)
        for (int i = -num; i <= num; i++) {
            int k = 0;

            // Math.abs : 절댓값 계산
            for (int j = 0; j < count - Math.abs(i); j++) {
                // k가 절댓값보다 작으면 " "(공백), k가 절댓값보다 크면 "*"을 찍는다.
                String result = k < Math.abs(i) ? " " : "*";
                System.out.print(result);
                k++;
            }
            System.out.println();
        }
    }
}
