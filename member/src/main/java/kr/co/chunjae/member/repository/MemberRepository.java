package kr.co.chunjae.member.repository;

import kr.co.chunjae.member.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
// 생성자 주입을 위한 어노테이션 부착
@RequiredArgsConstructor
public class MemberRepository {
    // 필드 생성자 주입 (SqlSessionTemplate이 Repository에 주입된다.)
    // SqlSessionTemplate에서 제공하는 다양한 쿼리 메소드를 사용할 수 있다.
    private final SqlSessionTemplate sqlSession;
    
    // 회원가입
    public int sign(MemberDTO memberDTO) {
        // DataBase 연결 확인을 위해 memberDTO를 출력한다.
        System.out.println("MemberDTO : " + memberDTO);

        // 사용자가 입력한 정보를 DataBase에 저장한다.
        return sqlSession.insert("Member.sign", memberDTO);
    }

    
    // 로그인
    
    
    // 회원 목록 리스트 출력
    
    
    
    // 회원 정보 상세 보기
    
    
}
