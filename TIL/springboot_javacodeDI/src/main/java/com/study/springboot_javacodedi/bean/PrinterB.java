package com.study.springboot_javacodedi.bean;

import com.study.springboot_javacodedi.bean.Printer;

public class PrinterB implements Printer {
    @Override
    public void print(String message) {
        System.out.println("Printer B : " + message);
    }
}
