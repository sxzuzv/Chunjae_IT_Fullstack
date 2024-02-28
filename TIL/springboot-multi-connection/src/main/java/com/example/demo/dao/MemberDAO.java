package com.example.demo.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class MemberDAO {
    @Autowired
    // @Resource : 등록한 Bean을 사용하도록 한다.
    @Resource(name="memberSqlSessionTemplate")
    private SqlSession sqlSession;

    public List list() {
        return sqlSession.selectList("member.list");
    }
}
