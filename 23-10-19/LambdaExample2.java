package ch16;

/**
 * 람다식 활용 예제_2
 */

// 인터페이스의 익명 구현 객체를 람다식으로 표현하려면 인터페이스가 단 하나의 추상 메소드만 가져야 한다.
// 인터페이스가 함수형 인터페이스임을 보장하기 위해 @FunctionalInterface 어노테이션 부착
@FunctionalInterface
// 인터페이스 BigNumber가 단 하나의 추상 메소드를 가지므로, 함수형 인터페이스(functional interface)이다.
interface BigNumber {
    int getBigNumber(int num1, int num2);
}

public class LambdaExample2 {
    public static void main(String[] args) {
        BigNumber bigNumber = (x, y) -> {
            if(x > y) { return x; }
            else { return y; }
        };

        int result = bigNumber.getBigNumber(2156, 12382);
        System.out.println(result);
    }
}
