package top.wugy.cloud.feign.provider.file;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FeignUploadProvider {

    @PostMapping(value = "/uploadFile/server", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String fileUploadServer(MultipartFile file) {
        return file.getOriginalFilename();
    }

}