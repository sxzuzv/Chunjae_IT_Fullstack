package com.example.demo.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class BoardDAO {
    // IoC : SqlSession을 주입해준다.
    // @Autowired 사용 시, 인스턴스를 자동으로 주입한다. (싱글톤 패턴)
    // 싱글톤 패턴 : 인스턴스를 하나만 만들어서 돌려쓴다. (메모리 효율성 UP)
    // @Resource : 등록한 Bean을 사용하도록 한다.
    @Autowired
    @Resource(name="boardSqlSessionTemplate")
    private SqlSession sqlSession;

    public List list() {
        // 괄호 안 : namespace명.id
        // return List<QnaVO>
        return sqlSession.selectList("board.list");
    }
}
