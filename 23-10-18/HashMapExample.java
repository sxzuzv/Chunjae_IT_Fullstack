package ch15.sec02;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// HashMap 컬렉션을 활용한 데이터 얻기

public class HashMapExample {
    public static void main(String[] args) {
        // Map 컬렉션 생성
        Map<String, Integer> map = new HashMap<>();

        // 객체 저장
        map.put("가", 10);
        map.put("나", 20);
        map.put("다", 30);
        map.put("나", 40); // key가 "나"로 동일하므로, 마지막에 저장된 값만 저장
        System.out.println("총 Entry 수는? : " + map.size());
        System.out.println();

        /* Map 컬렉션 값 얻는 방법 */
        // 1) 키를 통해 값 얻기
        String key = "나";
        int value = map.get(key); // key를 매개값으로 주면 key에 해당하는 값을 리턴
        System.out.println(key + " : " + value);
        System.out.println();

        // 2) 키 Set 컬렉션을 얻고, 반복해서 키와 값을 얻기
        // 키를 반복하기 위해 Set 컬렉션의 iterator() 메소드로 반복자를 얻음
        Set<String> keySet = map.keySet();
        Iterator<String> keyIterator = keySet.iterator();
        while(keyIterator.hasNext()) { // 가져올 객체가 있으면 true, 없으면 false 리턴
            String k = keyIterator.next(); // keyIterator에서 하나의 객체 가져오기
            Integer v = map.get(k);
            System.out.println(k + " : " + v);
        }
        System.out.println();

        // 3) 엔트리 Set 컬렉션을 얻고, 반복해서 키와 값을 얻기
        // 엔트리를 반복하기 위해 Set 컬렉션의 iterator() 메소드로 반복자를 얻음
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
        while(entryIterator.hasNext()) { // 가져올 객체가 있으면 true, 없으면 false 리턴
            Map.Entry<String, Integer> entry = entryIterator.next(); // entryIterator에서 하나의 객체 가져오기
            String k = entry.getKey();
            Integer v = entry.getValue();
            System.out.println(k + " : " + v);
        }
        System.out.println();

        // 키로 엔트리 삭제
        map.remove("나"); // 키 값이 "나"에 해당하는 엔트리 삭제
        System.out.println("총 Entry 수는? : " + map.size());
        System.out.println();
    }
}
