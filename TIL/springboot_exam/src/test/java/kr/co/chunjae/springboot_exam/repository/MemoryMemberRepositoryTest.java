package kr.co.chunjae.springboot_exam.repository;

import kr.co.chunjae.springboot_exam.domain.Member;
import kr.co.chunjae.springboot_exam.domain.MemoryMemberRepository;

import static kr.co.chunjae.springboot_exam.domain.MemoryMemberRepository.store;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    // 각 테스트가 끝난 이후 실행된다.
    @AfterEach
    public void afterEach() {
        // 테스트가 마무리 된 후, clear 하는 코드를 작성한다.
        repository.clearStore();
    }

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
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member00 = new Member();
        member00.setName("spring00");
        repository.save(member00);

        Member member01 = new Member();
        member01.setName("spring01");
        repository.save(member01);

        // 'spring00' 이름을 가지고 있는 Member 인스턴스를 저장한다.
        Member result = repository.findByName("spring00").get();
        // member00과 저장한 인스턴스가 동일한지 비교한다.
        assertThat(member00).isEqualTo(result);
    }

    @Test
    public void findAll() {
        Member member00 = new Member();
        member00.setName("spring00");
        repository.save(member00);

        Member member01 = new Member();
        member01.setName("spring01");
        repository.save(member01);

        List<Member> result = repository.findAll();

        // 전체 데이터를 READ 하는 것에 성공했는지 판단한다.
        assertThat(result.size()).isEqualTo(2);
    }

    /*
    jUnit : 서버를 돌리지 않고도 실행이 가능하다.
    통합테스트 시, 서버가 필요하다.
    본 파일은 단위테스트에 해당한다.
     */
}
