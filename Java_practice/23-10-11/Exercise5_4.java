package ch05;

/** [5-4] 2차원 배열 arr에 담긴 모든 값의 총합과 평균을 구하는 프로그램을 완성하시오.
 */

public class Exercise5_4 {
    public static void main(String[] args) {
        int[][] arr = {
                {5, 5, 5, 5, 5},
                {10, 10, 10, 10, 10},
                {20, 20, 20, 20, 20},
                {30, 30, 30, 30, 30}
        };

        int total = 0;
        float average = 0;
        int count = 0;

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                total += arr[i][j];
            }
        }

        // 나누는 수를 float로 형변환 해주어야 소수점 결과 계산이 가능하다.
        // 평균 : '모든 요소의 총합 / 모든 요소의 개수 (5개 요소씩 4행 = 4 * 5)'
        average = total / (float) (arr.length * arr[0].length);

        System.out.println("total = " + total);
        System.out.println("average = " + average);
    }
}
