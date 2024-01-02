package kr.co.chunjae.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Log4j
public class UploadController {
    // GET 방식으로 첨부 파일을 업로드할 수 있는 화면을 처리하는 메서드 uploadForm()
    // 클래스 선언부에 @RequestMapping이 적용되지 않았으므로, WEB-INF/views 폴더에 uploadForm.jsp 파일을 추가한다.
    @GetMapping("/uploadForm")
    public void uploadForm() {
        log.info("upload form");
    }

    @PostMapping
    public void upload() {

    }
}
