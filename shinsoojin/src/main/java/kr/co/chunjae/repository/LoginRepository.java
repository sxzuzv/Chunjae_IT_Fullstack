package kr.co.chunjae.repository;

import kr.co.chunjae.domain.Member;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LoginRepository {
    private final SqlSessionTemplate sql;


    public Member memberLogin(Member member) {
        return sql.selectOne("Member.login", member);
    }
}
