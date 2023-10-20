package ch16;

/**
 * 람다식 활용 예제_1
 */

// 인터페이스의 익명 구현 객체를 람다식으로 표현하려면 인터페이스가 단 하나의 추상 메소드만 가져야 한다.
// 인터페이스가 함수형 인터페이스임을 보장하기 위해 @FunctionalInterface 어노테이션 부착
// 컴파일 과정에서 추상 메소드가 하나인지 검사하므로 정확한 함수형 인터페이스를 작성할 수 있게 도와주는 역할을 한다.
@FunctionalInterface
// 인터페이스 Print가 단 하나의 추상 메소드를 가지므로, 함수형 인터페이스(functional interface)이다.
interface Print {
    void print(int a, int b);
}

class Test {
    public void testMethod(Print print) {
        print.print(1, 2);
        System.out.println("콘솔 출력 실행문");
    }
}

public class LambdaExample1 {
    public static void main(String[] args) {
        Test noLambda = new Test();
        noLambda.testMethod(new Print() {

            // Print 인터페이스의 print 메소드 재정의
            @Override
            public void print(int a, int b) {
                System.out.println("a와 b의 합은 : " + (a + b));
                System.out.println("a와 b의 차는 : " + (a - b));
            }
        });

        Test lambdaTest = new Test();
        lambdaTest.testMethod((a, b) -> {
            System.out.println("a와 b의 합은 : " + (a + b));
            System.out.println("a와 b의 차는 : " + (a - b));
        });
    }
}
