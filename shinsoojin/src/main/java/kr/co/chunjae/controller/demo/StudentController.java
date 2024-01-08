package kr.co.chunjae.controller.demo;

import kr.co.chunjae.domain.Member;
import kr.co.chunjae.domain.Student;
import kr.co.chunjae.service.demo.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/sign")
    public String signForm() {
        return "sign";
    }

    @PostMapping("/sign")
    public String sign(@ModelAttribute Student student) {
        studentService.sign(student);

        return "redirect:/student/";
    }

}
