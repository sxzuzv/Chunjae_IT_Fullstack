package kr.co.chunjae.member.service;

import kr.co.chunjae.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
// 생성자 주입을 위한 어노테이션 부착
@RequiredArgsConstructor
public class MemberService {
    // 필드 생성자 주입 (Repository가 Service에 주입된다.)
    private final MemberRepository memberRepository;

}
