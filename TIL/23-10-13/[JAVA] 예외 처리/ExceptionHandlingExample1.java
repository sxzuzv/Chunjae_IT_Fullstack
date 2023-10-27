package ch11;

// 예외 처리(NullPointerException 발생) 예제_1

public class ExceptionHandlingExample1 {
    public static void printLength(String data) {
        int result = data.length(); // data가 null일 경우, NullPointerException을 발생시킨다.
        System.out.println("문자 수는? : " + result);
    }

    public static void main(String[] args) {
        System.out.println("===== 프로그램 시작 =====");
        printLength("ThisisJava");
        printLength(null); // 매개값으로 null을 대입
        System.out.println("===== 프로그램 종료 =====");
    }
}
