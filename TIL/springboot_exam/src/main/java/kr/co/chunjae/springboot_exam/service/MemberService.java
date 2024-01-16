package kr.co.chunjae.springboot_exam.service;

import kr.co.chunjae.springboot_exam.domain.Member;
import kr.co.chunjae.springboot_exam.domain.MemoryMemberRepository;
import kr.co.chunjae.springboot_exam.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
    // Controller, Service의 경우 비즈니스 용어를 사용한다.
    // Repository에서는 개발자 용어를 사용한다.

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 회원가입
    public Long join(Member member) {
        // 같은 이름이 있는 회원의 경우, 중복 가입이 불가하도록 막는다.
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });

        memberRepository.save(member);
        return member.getId();
    }
}
