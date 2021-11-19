package icns.smartplantdashboardapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class SopDiagramController {

    @PostMapping("/fileTest")
    public ResponseEntity uploadFile(@RequestParam("fileName")MultipartFile fileName) throws IOException {
        System.out.println(fileName.getOriginalFilename());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyMMdd");
        String current_date = simpleDateFormat.format(new Date());
        String absolutePath = new File("").getAbsolutePath() + "\\images\\";
        System.out.println(absolutePath);
        String path = current_date;

        String contentType = fileName.getContentType();
        String originalFileExtension = ".json";

        String new_file_name = Long.toString(System.nanoTime()) + originalFileExtension;
        File file = new File(absolutePath + path + new_file_name);
        fileName.transferTo(file);
        return new ResponseEntity(null,null, HttpStatus.OK);
    }
}
