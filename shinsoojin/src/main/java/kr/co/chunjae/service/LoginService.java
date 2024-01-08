package kr.co.chunjae.service;

import kr.co.chunjae.domain.Member;
import kr.co.chunjae.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final LoginRepository repository;

    public boolean memberLogin(Member member) {
        Member loginMember = repository.memberLogin(member);

        if (loginMember != null) {
            return true;
        } else {
            return false;
        }
    }
}
