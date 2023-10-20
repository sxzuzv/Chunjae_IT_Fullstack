package ch11;

// 예외 떠넘기기(throws) 활용 예제
// throws 키워드가 붙은 메소드에서 해당 예외를 처리하지 않고 떠넘긴다.
// 해당 메소드를 호출하는 곳에서 떠넘긴 예외를 받아 처리한다.

public class ThrowsExample {
    public static void main(String[] args) {
        try {
            findClass(); // findClass() 호출
        } catch(ClassNotFoundException e) { // 예외를 떠넘겨서 처리하도록 한다.
            System.out.println("예외 처리 : " + e.toString());
        }
    }

    // 호출한 곳에서 예외 처리
    public static void findClass() throws ClassNotFoundException {
        Class.forName("java.lang.String2");
    }
}
