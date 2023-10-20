package ch11;

// 예외 처리(NullPointerException 발생) 예제 1 + 예외 처리 코드 추가
// try 블록에서 NullPointerException이 발생하면 catch 블록을 실행해서 예외를 처리한다.
// finally 블록은 예외 발생 여부와 관계없이 실행된다.

public class ExceptionHandlerExample2 {
    public static void printLength(String data) {
        try {
            int result = data.length(); // data가 null일 경우, NullPointerException이 발생한다.
            System.out.println("문자 수는? : " + result);
        } catch(NullPointerException e) {
            // Java 17에서는 예외 정보가 나타나지만, Java 11에서는 null로 출력된다.
            System.out.println(e.getMessage()); // 예외 정보 얻는 방법 1
            // System.out.println(e.String()); : 예외 정보 얻는 방법 2
            // e.printStackTrace(); : 예외 정보 얻는 방법 3
        } finally {
            System.out.println("[마무리 실행]\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("===== 프로그램 시작 =====");
        printLength("This is Java");
        printLength(null);
        System.out.println("===== 프로그램 종료 =====");
    }
}
