package ch04.page17;

/** [4-13] 다음은 주어진 문자열(value)이 숫자인지를 판별하는 프로그램이다.
 * 알맞은 코드를 넣어서 프로그램을 완성하시오.
 */

public class Exercise4_13 {
    public static void main(String[] args) {
        String value = "12o34";
        char ch = ' ';
        boolean isNumber = true;

         // 반복문과 charAt(int i)를 이용하여 문자열의 문자를 하나씩 읽어서 검사한다.
        for(int i = 0; i < value.length(); i++) {
            ch = value.charAt(i); // 문자형 변수 ch에 현재 인덱스의 value 값을 넣는다.
            if (!('0' <= ch && ch <= '9')) { // ch가 문자가 아니면 isNumber를 false로 바꾸고 반복문을 종료한다.
                isNumber = false;
                break;
            }
        }

        if (isNumber) {
            System.out.println(value + "는 숫자입니다.");
        } else {
            System.out.println(value + "는 숫자가 아닙니다.");
        }
    }
}
