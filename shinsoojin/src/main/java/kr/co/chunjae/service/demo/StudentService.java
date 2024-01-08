package kr.co.chunjae.service.demo;

import kr.co.chunjae.domain.Member;
import kr.co.chunjae.domain.Student;
import kr.co.chunjae.repository.demo.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;


    public void sign(Student student) {
        repository.sign(student);
    }
}
