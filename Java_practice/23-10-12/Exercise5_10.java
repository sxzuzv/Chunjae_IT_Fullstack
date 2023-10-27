package ch05;

/** [5-10] 다음은 알파벳과 숫자를 암호화하는 프로그램이다.
 * 알맞은 코드를 넣어서 완성하시오.
 */

public class Exercise5_10 {
    public static void main(String[] args) {
        char[] abcCode = {
                '`','~','!','@','#','$','%','^','&','*',
                '(',')','-','_','+','=','|','[',']','{',
                '}',';',':',',','.','/'
        };

                         // 0  1   2   3   4   5   6   7   8   9
        char[] numCode = {'q','w','e','r','t','y','u','i','o','p'};

        String src = "abc123";
        String result = "";

        // 문자열 src의 문자를 charAt()으로 하나씩 읽어서 변환 후, result에 저장한다.
        for(int i = 0; i < src.length(); i++) {
            char ch = src.charAt(i);

            // 1) ch가 영어 소문자(a~z)일 경우
            if('a' <= ch && ch <= 'z') {
                // ch가 영어 소문자일 경우, abcCode에서 암호 코드를 얻는다.
                // 인덱스에 해당하는 abcCode를 찾고, result에 반영한다.
                // 문자 'a'의 암호 코드 = abcCode[0] = abcCode['a'-'a']
                result += abcCode[ch-'a'];
            } else if('0' <= ch && ch <= '9') { // 2) ch가 숫자(0~9)일 경우
                // ch가 숫자일 경우, numCode에서 암호 코드를 얻는다.
                // 인덱스에 해당하는 numCode를 찾고, result에 반영한다.
                // 문자 '0'의 암호 코드 = numCode[0] = numCode['0'-'0']
                result += numCode[ch-'0'];
            }
        }
        System.out.println("src : " + src);
        System.out.println("result : " + result);
    }
}
