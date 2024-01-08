package kr.co.chunjae.repository;

import kr.co.chunjae.domain.Member;
import kr.co.chunjae.domain.Student;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudentRepository {
    private final SqlSessionTemplate sql;

    public List<Student> findAll() {
        return sql.selectList("Student.findAll");
    }

    public Student findByNum(int studentNum) {
        return sql.selectOne("Student.findByNum", studentNum);
    }

    public void update(Student student) {
        sql.insert("Student.update", student);
    }

    public void delete(int num) {
        sql.delete("Student.delete", num);
    }

    public void sign(Student student) {
        sql.insert("Student.sign", student);
    }
}
