package ch15.sec02;

// ArrayList & LinkedList 컬렉션을 활용한 데이터 저장 시간 측정
// PC 성능에 따라 각 컬렉션에 데이터를 저장하는 시간이 달라진다.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        // ArrayList 컬렉션 객체 생성
        List<String> list1 = new ArrayList<String>();
        
        // LinkedList 컬렉션 객체 생성
        List<String> list2 = new LinkedList<String>();

        // 작업 시작 시간, 작업 종료 시간을 저장할 변수 선언
        long startTime;
        long endTime;

        // ArrayList 컬렉션에 데이터를 저장하는 시간을 측정
        startTime = System.nanoTime();
        for(int i = 0; i < 10000; i++) {
            // ArrayList 컬렉션 객체 list1에 0번 인덱스부터 데이터를 저장
            list1.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.printf("%-17s %8d ns \n", "ArrayList 걸린 시간 : ", (endTime-startTime));

        // LinkedList 컬렉션에 데이터를 저장하는 시간을 측정
        startTime = System.nanoTime();
        for(int i = 0; i < 10000; i++) {
            // LinkedList 컬렉션 객체 list2에 0번 인덱스부터 데이터를 저장
            list2.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.printf("%-17s %8d ns \n", "LinkedList 걸린 시간 : ", (endTime-startTime));
    }
}
