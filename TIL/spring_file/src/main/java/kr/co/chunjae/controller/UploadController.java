package kr.co.chunjae.controller;

import kr.co.chunjae.domain.AttachFileDTO;
import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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


    // UploadController를 AttachFileDTO의 리스트를 반환하는 구조로 변경한다.
    @PostMapping(value="/uploadAjaxAction", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<AttachFileDTO>> uploadAjaxPost(MultipartFile[] uploadFile) {
        List<AttachFileDTO> list = new ArrayList<>();

        // 업로드 파일을 저장할 폴더의 경로를 지정한다.
        String uploadFolder = "C:\\upload";
        String uploadFolderPath = getFolder();

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
            // AttachFileDTO의 인스턴스를 생성한다.
            AttachFileDTO attachFileDTO = new AttachFileDTO();

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

            // AttachFileDTO 인스턴스에 파일 이름을 저장한다.
            attachFileDTO.setFileName(uploadFileName);

            // 중복 방지를 위한 UUID 적용
            // 파일 이름 생성 시, 동일한 이름으로 업로드되면 기존 파일을 지우게 된다.
            // 이를 java.util.UUID의 값을 이용하여 처리한다.

            // randomUUID()를 이용하여 임의의 값을 생성한다.
            UUID uuid = UUID.randomUUID();

            // 생성된 값은 원래의 파일 이름과 구분할 수 있도록 중간에 '_'를 추가한다.
            // 앞에서부터 '_'를 기준으로 분리하면 원래의 파일 이름을 파악할 수 있게 된다.
            uploadFileName = uuid.toString() + "_" + uploadFileName;

            // UUID를 적용한 첨부파일을 내용을 지정한 경로에 저장한다.
            // File saveFile = new File(uploadPath, uploadFileName);

            // 파라미터로는 java.io.File의 객체를 지정하면 되므로 업로드 되는 원래 파일 이름으로 C 드라이브의 'upload' 폴더에 저장된다.
            // File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());

            // 지정한 경로에 업로드 파일을 저장한다.
            // File saveFile = new File(uploadPath, uploadFileName);

            try {
                // 지정 경로에 저장된 파일의 이름을 가져온다.
                File saveFile = new File(uploadPath, uploadFileName);

                // 업로드 된 파일을 저장할 시, MultipartFile의 transferTo(File file) 메서드를 사용한다.
                multipartFile.transferTo(saveFile);

                // AttachFileDTO 인스턴스에 UUID 값을 저장한다.
                attachFileDTO.setUuid(uuid.toString());
                // AttachFileDTO 인스턴스에 업로드 경로를 저장한다.
                attachFileDTO.setUploadPath(uploadFolderPath);

                // 섬네일 이미지 생성
                // 일반 파일과 이미지 파일을 구분하여 이미지 파일일 시, 섬네일을 생성하도록 한다.

                // 업로드 된 파일이 이미지 파일인지 판단한다.
                if (checkImageType(saveFile)) { // 업로드 된 파일이 이미지 파일인 경우
                    // 기존 파일 이름 앞에 's_'를 붙여 섬네일 이름을 설정한다.
                    FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));

                    // 섬네일 파일 크기는 100x100으로 지정한다.
                    Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);

                    thumbnail.close();
                }

                // 리스트에 AttachFileDTO 인스턴스를 저장한다.
                list.add(attachFileDTO);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // JSON 형태의 데이터를 반환한다.
        return new ResponseEntity<>(list, HttpStatus.OK);
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

    // 특정한 파일이 이미지 타입인지 검사하는 메서드 checkImageType()
    private boolean checkImageType(File file) {
        try {
           String contentType = Files.probeContentType(file.toPath());
           return contentType.startsWith("image");
        } catch (IOException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
        }
        return false;
    }
}
