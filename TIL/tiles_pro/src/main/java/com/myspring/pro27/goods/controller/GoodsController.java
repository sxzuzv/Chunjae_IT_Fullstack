package com.myspring.pro27.goods.controller;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface GoodsController {
    public ModelAndView goods(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
