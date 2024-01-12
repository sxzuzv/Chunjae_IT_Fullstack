public class UnderstandDI {
    public static void main(String[] args) {

    }

    public static void memberUser1() {
        // 강한 결합 : 직접 Member 객체를 생성한다.
        Member m1 = new Member();
    }

    public static void memberUser2(Member m) {
        // 약한 결합 : 생성된 Member 객체를 주입받는다. => 의존성 주입 (Dependency Injection)
        Member m2 = m;
    }
}
