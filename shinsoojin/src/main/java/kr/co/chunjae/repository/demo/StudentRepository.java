package kr.co.chunjae.repository.demo;

import kr.co.chunjae.domain.Member;
import kr.co.chunjae.domain.Student;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class StudentRepository {
    private final SqlSessionTemplate sql;

    public void sign(Student student) {
        sql.insert("Student.sign", student);
    }
}
