package kr.co.chunjae.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Student {
    private int studentNum;
    private String studentName;
    private int korean;
    private int english;
    private int math;
}
