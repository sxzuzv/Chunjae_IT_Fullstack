package com.study.springboot_javacodedi.bean;

import com.study.springboot_javacodedi.bean.Printer;

public class Member {
    private String name;
    private String nickname;
    private Printer printer;

    // 기본 생성자
    public Member() { }

    // 파라미터가 있는 생성자
    public Member(String name, String nickname, Printer printer) {
        this.name = name;
        this.nickname = nickname;
        this.printer = printer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public void print() {
        printer.print("Hello" + name + " : " + nickname);
    }
}
