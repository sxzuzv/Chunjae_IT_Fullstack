package ch11;

// Class.forName("패키지...클래스")을 활용한 예외 처리

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        try {
            // Class.forName("패키지...클래스") : ClassPath 위치에서 주어진 클래스를 찾는다.
            // 주어진 클래스를 찾지 못했을 시, ClassNotFoundException이라는 일반 예외가 발생한다.
            Class.forName("java.lang.String");
            System.out.println("java.lang.String 클래스가 존재합니다.");
        } catch (ClassNotFoundException e) {
            // 예외 발생 관련 추적 내용을 출력
            e.printStackTrace();
        }

        try {
            Class.forName("java.lang.String2"); // ClassNotFoundException 발생
            System.out.println("java.lang.String2 클래스가 존재합니다.");
        } catch (ClassNotFoundException e) {
            // 예외 발생 관련 추적 내용을 출력
            e.printStackTrace();
        }
    }
}
