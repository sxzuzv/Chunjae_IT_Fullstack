package kr.co.chunjae.member.controller;

import kr.co.chunjae.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
// 생성자 주입을 위한 어노테이션 부착
@RequiredArgsConstructor
// 요청명이 "/member"로 시작할 시, MemberController 내부의 메소드가 실행될 수 있다.
@RequestMapping("/member")
public class MemberController {
    // 필드 생성자 주입 (Service가 Controller에 주입된다.)
    private final MemberService memberService;

}
