package icns.smartplantdashboardapi.controller;

import icns.smartplantdashboardapi.domain.EState;
import icns.smartplantdashboardapi.dto.common.CommonResponse;
import icns.smartplantdashboardapi.dto.common.StatusCode;
import icns.smartplantdashboardapi.dto.sop.SopRequest;
import icns.smartplantdashboardapi.service.SopService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Api(tags = {"e-SOP 다이어그램 관리"})
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SopController {
    private final SopService sopService;

    @PutMapping("/sop")
    public ResponseEntity uploadFile(@RequestParam("typeId") Long typeId, @RequestParam("level") int level, @RequestParam("diagramFile") MultipartFile diagramFile) throws IOException {
        return new ResponseEntity(CommonResponse.res(StatusCode.OK,sopService.update(typeId, level, diagramFile)), null, HttpStatus.OK);
    }

    @GetMapping("/sop")
    public ResponseEntity find(@RequestParam("typeId") Long typeId, @RequestParam("level") int level){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK,sopService.find(typeId, level)),null,HttpStatus.OK);
    }

}
