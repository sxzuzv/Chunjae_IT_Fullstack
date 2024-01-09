package com.myspring.pro27.board.controller;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BoardController {
    public ModelAndView board(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
