package ch09.sec00;

// Tire 클래스 (익명 자식 객체를 생성하여 필드, 로컬 변수, 매개변수의 값으로 사용)

public class Tire {
    // Tire 클래스의 익명 자식 객체를 생성하여 필드, 로컬 변수, 매개변수의 값으로 사용한다.
    // 익명 자식 객체는 Tire 클래스의 roll() 메소드를 재정의하여 실행 내용을 변경 (다형성)
    public void roll() {
        System.out.println("일반 타이어가 굴러갑니다.");
    }
}
