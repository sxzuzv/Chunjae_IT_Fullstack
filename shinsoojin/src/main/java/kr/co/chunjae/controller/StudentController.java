package kr.co.chunjae.controller;

import kr.co.chunjae.domain.Student;
import kr.co.chunjae.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

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

    @GetMapping("/")
    public String findAll(Model model) {
        List<Student> studentList = studentService.findAll();
        model.addAttribute("studentList", studentList);

        return "list";
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam("studentNum") String studentNum, Model model) {
        Student students = studentService.findByNum(studentNum);

        model.addAttribute("studentList", students);

        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Student student) {
        studentService.update(student);
        return "redirect:/student/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("studentNum") int num) {
        studentService.delete(num);

        return "redirect:/student/";
    }

}
