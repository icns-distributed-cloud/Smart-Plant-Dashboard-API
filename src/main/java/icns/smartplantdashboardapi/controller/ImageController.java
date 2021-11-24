package icns.smartplantdashboardapi.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.codehaus.plexus.util.IOUtil;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Api(tags = {"파일 관련"})
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ImageController {
    @GetMapping(
        value = "/image",
        produces = MediaType.IMAGE_PNG_VALUE
    )
    public ResponseEntity showImage(@RequestParam String path) throws IOException {
        InputStream in = new FileInputStream(path);
        byte[] imageByteArray = IOUtils.toByteArray(in);
        return new ResponseEntity(imageByteArray, null, HttpStatus.OK);
    }
}
