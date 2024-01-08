package kr.co.chunjae.service;

import kr.co.chunjae.domain.Member;
import kr.co.chunjae.domain.Student;
import kr.co.chunjae.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;

    public List<Student> findAll() {
        return repository.findAll();
    }

    public Student findByNum(String studentNum) {
        return repository.findByNum(Integer.parseInt(studentNum));
    }

    public void update(Student student) {
        repository.update(student);
    }

    public void delete(int num) {
        repository.delete(num);
    }

    public void sign(Student student) {
        repository.sign(student);
    }
}
