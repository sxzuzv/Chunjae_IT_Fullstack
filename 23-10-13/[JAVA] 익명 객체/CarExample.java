package ch09.sec00;

// (다형성) 익명 자식 객체가 부모 타입에 대입되면 부모 메소드 roll()을 호출할 경우, 재정의된 익명 자식 객체의 roll() 메소드가 실행

public class CarExample {
    public static void main(String[] args) {
        // Car 객체 생성
        Car car = new Car();

        // 익명 자식 객체가 대입된 필드 사용
        car.run1();
        
        // 익명 자식 객체가 대입된 로컬 변수 사용
        car.run2();
        
        // 익명 자식 객체가 대입된 매개변수 사용
        car.run3(new Tire() {
            @Override
            public void roll() {
                System.out.println("익명 자식 Tire 객체 3이 굴러갑니다.");
            }
        });
    }
}
