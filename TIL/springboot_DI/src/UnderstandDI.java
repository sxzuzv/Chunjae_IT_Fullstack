import java.util.Date;

/* static : 정적인, 고정된 => static이 붙은 변수나 메서드는 특정 객체에 소속되는 것이 아닌 클래스에 고정되어 있는 변수나 메서드가 된다.
[static 특징]
    1. 메모리에 고정적으로 할당된다.
    2. 객체 생성 없이 사용 가능하다.
        => 어떤 객체에 소속되어 있다는 것 : new 키워드를 사용하여 객체를 생성해야지만 변수나 메서드를 사용할 수 있다.
    3. 프로그램이 시작되면 메모리의 static 영역에 적재되고, 프로그램이 종료될 때 해제된다.
    4. static 메서드 내에서는 인스턴스 변수 사용이 불가하다.
 */

/* 강한 결합 vs 약한 결합
* Member 클래스 생성자의 public 부분을 private으로 변경할 시, 강한 결합의 경우 Member 객체를 생성하는 과정에서 에러가 발생한다.
* 그러나, 약한 결합의 경우 이미 생성된 객체를 주입받기 때문에, 에러가 발생하지 않는다.
* 즉, 약한 결합을 사용하는 프로그래밍은 다른 클래스의 변화에 안전하고 유연하게 대처할 수 있다. => 의존성 주입을 통해 약한 결합을 사용하는 이유
 */

public class UnderstandDI {
    public static void main(String[] args) {
        // 날짜를 구하기 위해서는 Date 클래스에 의존해야 한다. (Date 클래스 = 기존에 만들어져 있다.)
        // 강한 결합, 약한 결합의 대상은 개발자가 만든 클래스뿐만 아니라, 기존에 만들어져 있는 API 혹은 프레임워크의 기능에도 동일하게 적용된다.
        Date date = new Date();
        System.out.println(date);
    }

    public static void memberUser1() {
        // 강한 결합 : 직접 Member 객체를 생성한다.
        // 생성자를 직접 호출하여 객체를 만들게 되면 강한 결합이 된다.
        Member m1 = new Member();
    }

    public static void memberUser2(Member m) {
        // 약한 결합 : 생성된 Member 객체를 주입받는다. => 의존성 주입 (Dependency Injection)
        // 약한 결합은 의존할 객체를 주입받아야 하므로, 메서드의 파라미터로 받아들여 객체에 할당하는 코드를 작성한다.
        Member m2 = m;
    }
}
