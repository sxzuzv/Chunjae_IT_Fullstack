package com.example.demo.vo;

import lombok.Data;

@Data // Getter, Setter 등 자동으로 생성해준다.
public class QnaVO {
    private int id;
    private String title;
    private String userId;
}
