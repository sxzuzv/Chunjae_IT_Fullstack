package ch05;

/** [5-6] 다음은 거스름돈을 몇 개의 동전으로 지불할 수 있는지를 계산하는 문제이다.
 * 변수 money의 금액을 동전으로 바꾸었을 때 각각 몇 개의 동전이 필요한지 계산해서 출력하라.
 * 단, 가능한 한 적은 수의 동전으로 거슬러 주어야한다. 알맞은 코드를 넣어서 프로그램을 완성하시오.
 */

public class Exercise5_6 {
    public static void main(String[] args) {
        // 큰 금액의 동전을 우선적으로 거슬러 줘야 한다.
        int[] coinUnit = {500, 100, 50, 10};

        int money = 2680;
        System.out.println("money = " + money);

        for(int i = 0; i < coinUnit.length; i++) {
            // money에서 500원부터 나누면서 필요한 동전 개수를 계산
            System.out.println(coinUnit[i] + "원 : " + money / coinUnit[i]); // 동전별 필요한 개수를 출력
            money %= coinUnit[i]; // 필요한 동전 개수 계산 후, 나머지 계산을 통해 남은 money 값을 저장
        }
    }
}
