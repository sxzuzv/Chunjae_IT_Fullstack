package ch05;

/** [5-8] 다음은 배열 answer에 담긴 데이터를 읽고 각 숫자의 개수를 세어서
 * 개수만큼 '*'을 찍어서 그래프를 그리는 프로그램이다. 알맞은 코드를 넣어서 완성하시오.
 */

public class Exercise5_8 {
    public static void main(String[] args) {
        int[] answer = {1, 4, 4, 3, 1, 4, 4, 2, 1, 3, 2};
        // 배열 answer에 1, 2, 3, 4가 몇 개씩 있는 지를 계산하여 저장할 배열
        int[] counter = new int[4];

        // 배열 answer에 1, 2, 3, 4가 몇 개씩 있는 지를 계산한다.
        for(int i = 0; i < answer.length; i++) {
            // counter[인덱스]++; : 인덱스의 값을 1씩 증가시킨다.
            // 인덱스 answer[i]-1 : 배열 인덱스가 0부터 시작하는 것을 고려하여 -1로 처리한다.
            // 0, 1, 2, 3 중 하나의 값을 가지게 되며, 이는 곧 1, 2, 3, 4가 몇 개씩 있는 지를 계산한다는 의미이다.
            counter[answer[i]-1]++;
        }

        for(int i = 0; i < counter.length; i++) {
            // 배열 answer에 1, 2, 3, 4가 몇 개씩 있는 지를 계산한 값을 출력한다.
            System.out.print(counter[i]);

            for(int j = 0; j < counter[i]; j++) {
                // counter[i]의 값 만큼 별을 출력한다. (1, 2, 3, 4의 개수만큼 별을 출력한다.)
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
