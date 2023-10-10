package ch04.page17;

import java.util.Scanner;

/** [4-14] 다음은 숫자 맞추기 게임을 작성한 것이다.
 * 1과 100 사이의 값을 반복적으로 입력해서 컴퓨터가 생각한 값을 맞추면 게임이 끝난다.
 * 사용자가 값을 입력하면, 컴퓨터는 자신이 생각한 값과 비교해서 결과를 알려준다.
 * 사용자가 컴퓨터가 생각한 숫자를 맞추면 게임이 끝나고 몇 번만에 숫자를 맞췄는지 알려준다.
 * 알맞은 코드를 넣어 프로그램을 완성하시오.
 */

public class Exercise4_14 {
    public static void main(String[] args) {
        // 1~100 사이의 임의의 값을 얻어서 answer에 저장한다.
        int answer = (int)(Math.random()*100) + 1;
        int input = 0;
        int count = 0;

        // 화면으로부터 사용자 입력을 받기 위해 Scanner 클래스 사용
        Scanner scan = new Scanner(System.in);

        do {
            count++;
            System.out.print("1과 100 사이의 값을 입력하세요. : ");
            input = scan.nextInt();

            if (answer > input) {
                System.out.println("더 큰 수를 입력해보세요!");
            } else if (answer < input) {
                System.out.println("더 작은 수를 입력해보세요!");
            } else {
                System.out.println("정답입니다! 게임을 종료합니다.");
                System.out.println("시도 횟수는 " + count + "번입니다.");
                break; // 정답을 맞췄을 시, do-while문을 벗어난다.
            }
        } while(true);
    }
}
