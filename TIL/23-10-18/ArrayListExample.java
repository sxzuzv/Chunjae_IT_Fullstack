package ch15.sec02;

import java.util.ArrayList;
import java.util.List;

// ArrayList 컬렉션을 활용한 객체 얻기 & 삭제

public class ArrayListExample {
    public static void main(String[] args) {
        // ArrayList 컬렉션 생성        
        List<Board> list = new ArrayList<>();

        // list에 객체 추가
        list.add(new Board("제목 1", "내용 1", "글쓴이 1"));
        list.add(new Board("제목 2", "내용 2", "글쓴이 2"));
        list.add(new Board("제목 3", "내용 3", "글쓴이 3"));
        list.add(new Board("제목 4", "내용 4", "글쓴이 4"));
        list.add(new Board("제목 5", "내용 5", "글쓴이 5"));

        // 저장된 총 객체 수 얻기
        int size = list.size();
        System.out.println("총 객체 수 : " + size);
        System.out.println();

        // 2번째 인덱스의 객체를 가지고 와 Board 객체 변수인 board에 대입
        Board board = list.get(2);
        // Board 객체 메소드를 사용하여 가져온 객체 내용 읽기
        System.out.println(board.getSubject() + "\t" + board.getContent() + "\t" + board.getWriter());
        System.out.println();

        // 모든 객체를 하나씩 가져오기
        for(int i = 0; i < list.size(); i++) {
            // i번째 인덱스의 객체를 가지고 와 Board 객체 변수인 b에 대입
            Board b = list.get(i);
            // Board 객체 메소드를 사용하여 가져온 객체 내용 읽기
            System.out.println(b.getSubject() + "\t" + b.getContent() + "\t" + b.getWriter());
        }
        System.out.println();

        // 객체 삭제
        // 2번째 인덱스의 객체를 삭제하였으므로, 이후의 요소들이 한 칸씩 앞으로 당겨온다. (3번 인덱스가 2번 인덱스로 변경)
        list.remove(2);
        // 변경된 2번 인덱스도 삭제
        list.remove(2);

        // 향상된 for문 사용
        // 모든 객체 가져와서 Board 객체 변수인 b에 하나씩 대입 
        for(Board b : list) {
            // Board 객체 메소드를 사용하여 가져온 객체 내용 읽기
            System.out.println(b.getSubject() + "\t" + b.getContent() + "\t" + b.getWriter());
        }
    }
}
