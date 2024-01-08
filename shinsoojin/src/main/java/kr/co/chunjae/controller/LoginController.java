package kr.co.chunjae.controller;

import kr.co.chunjae.domain.Member;
import kr.co.chunjae.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/login")
    public String LoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String memberLogin(@ModelAttribute Member member, HttpSession httpSession) {
        boolean loginMember = loginService.memberLogin(member);

        if(loginMember) {
            httpSession.setAttribute("memberId", member.getMemberId());

            return "redirect:/student/";
        } else {
            return "login";
        }
    }
}
