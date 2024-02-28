package com.example.demo.service;

import com.example.demo.dao.BoardDAO;
import com.example.demo.dao.MemberDAO;
import com.example.demo.vo.QnaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class BoardService {
    @Autowired
    private BoardDAO boardDAO;

    @Autowired
    private MemberDAO memberDAO;

    public HashMap list() {
        QnaVO vo = new QnaVO();
        vo.setTitle("test");
        vo.setUserId("yyb");
        int id = boardDAO.save(vo);
        System.out.println(id);
        System.out.println(vo);

        HashMap result = new HashMap();

        result.put("boardList", boardDAO.list());
        result.put("memberList", memberDAO.list());

        return result;
    }
}
