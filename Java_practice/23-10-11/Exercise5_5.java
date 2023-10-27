package ch05;

/** [5-5] 다음은 1과 9 사이의 중복되지 않은 숫자로 이루어진 3자리 숫자를 만들어내는 프로그램이다.
 * 알맞은 코드를 넣어서 프로그램을 완성하시오.
 */

public class Exercise5_5 {
    public static void main(String[] args) {
        int[] ballArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] ball3 = new int[3];

        // 배열 ballArr의 임의의 요소를 골라서 위치를 바꾼다.
        for(int i = 0; i < ballArr.length; i++) {
            int j = (int)(Math.random() * ballArr.length);
            int tmp = 0;

            tmp = ballArr[i];
            ballArr[i] = ballArr[j]; // 인덱스(랜덤으로 뽑은 수)에 해당하는 요소를 ballArr 배열에 차례로 넣는다.
            ballArr[j] = tmp;
        }

        // ballArr[0]에서 ball3[0]으로 3개의 데이터를 복사한다.
        System.arraycopy(ballArr, 0, ball3, 0, 3);

        for(int i = 0; i < ball3.length; i++) {
            System.out.print(ball3[i]);
        }
    }
}
