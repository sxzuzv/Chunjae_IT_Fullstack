package ch05;

/** [5-11] 주어진 2차원 배열의 데이터보다 가로와 세로로 1이 더 큰 배열을 생성해서
 * 배열의 행과 열의 마지막 요소에 각 열과 행의 총합을 저장하고 출력하는 프로그램이다.
 * 알맞은 코드를 넣어서 완성하시오.
 */

public class Exercise5_11 {
    public static void main(String[] args) {
        int[][] score = {
                {100, 100, 100}
                , {20, 20, 20}
                , {30, 30, 30}
                , {40, 40, 40}
                , {50, 50, 50}
        };

        // 배열 score(3x5 배열)보다 가로와 세로로 1이 더 큰 배열 result(4x6) 생성
        int[][] result = new int[score.length+1][score[0].length+1];

        // 배열 result에 데이터를 채운다.
        for(int i = 0; i < score.length; i++) {
            for(int j = 0; j < score[i].length; j++) {
                // 3x5 영역에는 배열 score의 데이터를 그대로 저장한다.
                result[i][j] = score[i][j];

                // 행의 마지막 요소에 행의 총합을 저장한다.
                result[i][score[0].length] += result[i][j];

                // 열의 마지막 요소에 열의 총합을 저장한다.
                result[score.length][j] += result[i][j];

                // 행열의 가장 마지막 요소(행과 열의 마지막)에 총합을 저장한다.
                result[score.length][score[0].length] += result[i][j];
            }
        }

        // 배열 result를 출력한다.
        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[i].length; j++) {
                System.out.printf("%4d", result[i][j]);
            }
            System.out.println();
        }
    }
}
