package org.example;

/* [4-8] 방정식 2x+4y=10의 모든 해를 구하시오. 단, x와 y는 정수이고 각각의 범위는 0<=x<=10, 0<=y<=10이다. */

public class EquationSolution {
    public static void main(String[] args) {
        // 이중 for문을 사용하여 방정식의 해를 구한다.
        for (int x = 0; x <= 10; x++) {
            for (int y = 0; y <= 10; y++) {
                if (2*x + 4*y == 10) {
                    System.out.println("x=" + x + ", y=" + y);
                }
            }
        }
    }
}
