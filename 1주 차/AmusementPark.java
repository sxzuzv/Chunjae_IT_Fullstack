package Mini_Example_01;

import java.util.Scanner;

public class AmusementPark {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int admission = 10000;

        System.out.println("[입장권 계산]");
        System.out.printf("나이를 입력해 주세요.(숫자):");
        int age = scan.nextInt();

        System.out.printf("입장시간을 입력해 주세요.(숫자입력):");
        int time = scan.nextInt();

        System.out.printf("국가유공자 여부를 입력해 주세요.(y/n):");
        char merit = scan.next().charAt(0);

        System.out.printf("복지카드 여부를 입력해 주세요.(y/n):");
        char card = scan.next().charAt(0);

        if(merit == 'y' || card == 'y') {
            admission = 8000;
        }

        if(age<13 || time>=17) {
            admission = 4000;
            if(age<3) {
                admission = 0;
            }
        }

        System.out.printf("입장료: %d", admission);
    }
}
