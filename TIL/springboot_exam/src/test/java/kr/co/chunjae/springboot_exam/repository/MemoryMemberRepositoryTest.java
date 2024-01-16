package kr.co.chunjae.springboot_exam.repository;

import kr.co.chunjae.springboot_exam.domain.Member;
import kr.co.chunjae.springboot_exam.domain.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        // 1. 출력문으로 확인
        //System.out.println("(result == member ) = " + (result == member));

        // 2. Assertions (core.api) 사용
        // member와 result의 데이터가 동일한지 비교한다.
        Assertions.assertThat(member).isEqualTo(result);
    }

}
