package kr.co.chunjae.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@Log4j
public class UploadController {
    // GET 방식으로 첨부 파일을 업로드할 수 있는 화면을 처리하는 메서드 uploadForm()
    // 클래스 선언부에 @RequestMapping이 적용되지 않았으므로, WEB-INF/views 폴더에 uploadForm.jsp 파일을 추가한다.
    @GetMapping("/uploadForm")
    public void uploadForm() {
        log.info("upload form");
    }

    // 파일 업로드 후, submit 버튼을 눌렀을 경우 해당 요청을 처리하는 메서드를 작성한다.
    // 파일 처리는 스프링에서 제공하는 MultipartFile 타입을 사용한다.
    // 화면에서 첨부파일을 여러 개 선택할 수 있으므로 배열 타입으로 설정한 후 파일을 업로드한다.
    @PostMapping("/uploadFormAction")
    public void uploadFormPost(MultipartFile[] uploadFile, Model model) {
        // 업로드 한 파일을 저장할 폴더를 지정한다.
        String uploadFolder = "C:\\upload";

        // 여러 개의 파일이 업로드 됐으며, 반복문 수행을 통해 개별 파일에 대한 정보에 접근한다.
        for (MultipartFile multipartFile : uploadFile) {
            log.info("===========================================");
            // 업로드 된 파일의 이름을 출력한다.
            log.info("Upload File Name : " + multipartFile.getOriginalFilename());
            // 업로드 된 파일의 크기를 출력한다.
            log.info("Upload File Size : " + multipartFile.getSize());

            // 파라미터로는 java.io.File의 객체를 지정하면 되므로 업로드 되는 원래 파일 이름으로 C 드라이브의 'upload' 폴더에 저장된다.
            File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());

            try {
                // 업로드 된 파일을 저장할 시, MultipartFile의 transferTo(File file) 메서드를 사용한다.
                multipartFile.transferTo(saveFile);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }


    @GetMapping("/uploadAjax")
    public void uploadAjax() {
        log.info("upload Ajax");
    }

    @PostMapping("/uploadAjaxAction")
    public void uploadAjaxPost(MultipartFile[] uploadFile) {
        // 업로드 파일을 저장할 폴더의 경로를 지정한다.
        String uploadFolder = "C:\\upload";

        // 지정한 경로에 폴더를 생성한다. (폴더 생성 구성 : yyyy 하위 - mm 하위 - dd)
        File uploadPath = new File(uploadFolder, getFolder());
        log.info("upload path : " + uploadPath);

        // 폴더가 생성되지 않았을 경우
        if (uploadPath.exists() == false) {
            // 해당 경로에 폴더를 생성한다.
            uploadPath.mkdirs();
        } // make yyyy/MM/dd folder

        // 여러 개의 파일이 업로드 됐으며, 반복문 수행을 통해 개별 파일에 대한 정보에 접근한다.
        for (MultipartFile multipartFile : uploadFile) {
            log.info("===========================================");
            // 업로드 된 파일의 이름을 출력한다.
            log.info("Upload File Name : " + multipartFile.getOriginalFilename());
            // 업로드 된 파일의 크기를 출력한다.
            log.info("Upload File Size : " + multipartFile.getSize());

            // 업로드 된 파일의 기존 이름을 저장한다.
            String uploadFileName = multipartFile.getOriginalFilename();

            // IE의 경우 전체 파일 경로가 전송되므로, 마지막 '\'를 기준으로 잘라낸 문자열이 실제 파일 이름이 된다.
            uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
            log.info("only file name : " + uploadFileName);

            // 파라미터로는 java.io.File의 객체를 지정하면 되므로 업로드 되는 원래 파일 이름으로 C 드라이브의 'upload' 폴더에 저장된다.
            // File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());

            // 지정한 경로에 업로드 파일을 저장한다.
            File saveFile = new File(uploadPath, uploadFileName);

            try {
                // 업로드 된 파일을 저장할 시, MultipartFile의 transferTo(File file) 메서드를 사용한다.
                multipartFile.transferTo(saveFile);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }

    // 첨부파일을 보관하는 폴더를 생성한다. (폴더 생성 구성 : yyyy 하위 - mm 하위 - dd)
    // 한 번에 폴더를 생성하거나 존재하는 폴더를 이용하는 방식 중 하나를 선택할 수 있다.
    // java.io.File에 존재하는 mkdirs()를 이용하여 필요한 상위 폴더까지 한 번에 생성할 수 있다.
    private String getFolder() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date();

        String str = sdf.format(date);

        // "-"를 기준으로 파일명을 분할한다.
        return str.replace("-", File.separator);
    }
}
