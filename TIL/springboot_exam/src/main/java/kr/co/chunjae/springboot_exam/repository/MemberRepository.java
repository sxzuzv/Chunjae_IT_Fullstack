package kr.co.chunjae.springboot_exam.repository;

import kr.co.chunjae.springboot_exam.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    public Member save(Member member);
    public Optional<Member> findById(Long id);
    public Optional<Member> findByName(String name);
    public List<Member> findAll();
    public void clearStore();
}
