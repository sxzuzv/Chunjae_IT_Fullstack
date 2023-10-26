package ch05;

/** [5-7] 커맨드라인으로부터 거슬러 줄 금액을 입력받아 계산한다.
 * 보유한 동전의 개수로 거스름돈을 지불할 수 없으면, '거스름돈이 부족합니다.'라고 출력하고 종료한다.
 * 지불할 돈이 충분히 있으면, 거스름돈을 지불한 만큼 가진 돈에서 빼고 남은 동전의 개수를 화면에 출력한다.
 * 알맞은 코드를 넣어서 프로그램을 완성하시오.
 */

public class Exercise5_7 {
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("USAGE: java Exercise5_7 3120");
            System.exit(0);
        }

        // 문자열을 숫자로 변환, 입력한 값이 숫자가 아닐 경우 예외가 발생한다.
        int money = Integer.parseInt(args[0]);

        System.out.println("money = " + money);

        int[] coinUnit = {500, 100, 50, 10}; // 동전 단위
        int[] coin = {5, 5, 5, 5}; // 단위별 동전 개수

        for(int i = 0; i < coinUnit.length; i++) {
            int coinNum = 0; // 단위별 필요한 동전의 개수

            // money(금액)을 동전 단위로 나눈 뒤, 필요한 동전의 개수(coinNum)를 구한다.
            // 500원부터 10원까지 차례로 필요한 동전의 개수(coinNum)가 구해진다.
            coinNum = money / coinUnit[i];

            // 1) 동전 단위별로 '가진 동전의 수 >= 필요한 동전의 개수'일 경우
            if(coin[i] >= coinNum) {
                // 1-1) 동전 단위별로 '가진 동전의 개수 - 필요한 동전의 개수'를 계산하여 coin[i]의 값을 변경한다.
                coin[i] -= coinNum;
            } else { // 2) 동전 단위별로 '가진 동전의 수 < 필요한 동전의 개수'일 경우
                // 2-1) 거슬러 줄 동전의 개수를 현재 가진 동전의 개수로 바꾼다.
                coinNum = coin[i];
                // 2-2) 가진 동전의 개수는 0으로 설정한다.
                coin[i] = 0;
            }

            // 3) '입력된 금액 - 단위별 동전 개수 * 동전 단위'를 계산하고 거슬러준 후 남은 돈을 업데이트한다.
            money -= coinNum * coinUnit[i];
        }

        // 남은 돈이 0보다 큰 경우 (거스름돈이 모자랄 경우)
        if(money > 0) {
            System.out.println("거스름돈이 부족합니다.");
            System.exit(0); // 프로그램을 종료한다.
        }

        System.out.println("===== 남은 동전의 개수 =====");
        // 동전 단위별 남은 동전의 개수를 출력한다.
        for(int i = 0; i < coinUnit.length; i++) {
            System.out.println(coinUnit[i] + "원 : " + coin[i]);
        }
    }
}
