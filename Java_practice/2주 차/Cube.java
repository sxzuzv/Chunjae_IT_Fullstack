package org.example;

/* [4-6] 두 개의 주사위를 던졌을 때, 눈의 합이 6이 되는 모든 경우의 수를 출력하는 프로그램을 작성하시오. */
public class Cube {
    public static void main(String[] args) {
        System.out.println("===== 눈의 합이 6이 되는 경우의 수 =====");

        // 이중 for문 사용, 두 변수의 합이 6이 되는 경우의 수를 찾는다.
        for (int i = 1; i <= 6; i++) {
            for (int j = 6; j >= 1; j--) {
                if(i + j == 6) {
                    System.out.printf("(%d, %d)", i, j);
                    System.out.println();
                }
            }
        }
    }
}
