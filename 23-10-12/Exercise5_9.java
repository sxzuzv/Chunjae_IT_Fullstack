package ch05;

/** [5-9] 주어진 배열을 시계 방향으로 90도 회전시켜서 출력하는 프로그램을 완성하시오.
 *
 */

public class Exercise5_9 {
    public static void main(String[] args) {
        char[][] star = {
                {'*', '*', ' ', ' ', ' '},
                {'*', '*', ' ', ' ', ' '},
                {'*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*'}
        };

        // 배열 star를 시계 방향으로 90도 회전시킨 배열
        char[][] result = new char[star[0].length][star.length];

        // 배열 star를 출력한다. (기존 모양, 4x5 배열)
        for(int i = 0; i <star.length; i++) {
            for(int j = 0; j < star[i].length; j++) {
                System.out.print(star[i][j]);
            }
            System.out.println();
        }

        System.out.println();

        // 배열 star를 시계 방향으로 90도 회전시킨 배열인 result(5x4 배열)를 만든다.
        // 배열에 사용하는 인덱스 변수 : star[i][j], result[x][y]
        for(int i = 0; i < star.length; i++) {
            for(int j = 0; j < star[i].length; j++) {
                // star(기존 배열)과 result(시계 방향 90도 회전 배열)의 인덱스를 고려한다.
                // 기존 배열을 시계 방향으로 90도 회전하면 인덱스가 아래와 같이 이동한다.
                // star[0][0] = result[0][3], star[0][1] = result[1][3]
                int x = j; // result의 x값과 star의 j값이 동일하다.
                int y = star.length - 1 - i; // result의 y값 + star의 i값 = 3(일정), 3 = star.length-1-1
                
                // result 배열의 내용을 채운다.
                result[x][y] = star[i][j];
            }
        }

        // 배열 result를 출력한다. (시계 방향으로 90도 회전시킨 모양, 5x4 배열)
        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }
}
