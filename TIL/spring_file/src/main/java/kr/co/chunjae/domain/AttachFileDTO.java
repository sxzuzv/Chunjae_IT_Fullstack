package kr.co.chunjae.domain;

import lombok.Data;

@Data
// 첨부파일의 정보를 저장하는 클래스 AttachFileDTO
public class AttachFileDTO {
    private String fileName;    // 원본 파일 이름
    private String uploadPath;  // 업로드 경로
    private String uuid;        // UUID 값
    private boolean image;      // 이미지 여부
}
