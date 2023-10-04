package org.example;

import java.util.Scanner;

public class Scan {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("===== 구구단 계산 프로그램 =====");
        int num = 0;

        while(true) {
            System.out.printf("몇 단을 계산할까요? : ");
            num = scan.nextInt();
            if (num == 0 || num == 1) {
                System.out.println("종료합니다.");
                break;
            } else {
                for(int i = 1; i <= 9; i++) {
                    System.out.printf("%d * %d = %2d\n", num, i, num*i);
                }
            }
        }
    }
}
