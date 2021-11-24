package icns.smartplantdashboardapi.controller;

import icns.smartplantdashboardapi.dto.common.CommonResponse;
import icns.smartplantdashboardapi.dto.common.StatusCode;
import icns.smartplantdashboardapi.dto.sopDiagram.SopDiagramRequest;
import icns.smartplantdashboardapi.service.SopDiagramService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@Api(tags = {"e-SOP 다이어그램 관리"})
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SopDiagramController {
    private final SopDiagramService sopDiagramService;

    @PostMapping("/sop")
    public ResponseEntity updateDiagram(@RequestBody SopDiagramRequest sopDiagramRequest) throws IOException{
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, sopDiagramService.updateDiagram(sopDiagramRequest)), null, HttpStatus.OK);
    }

    @GetMapping("/sop")
    public ResponseEntity findDiagram(@RequestParam("situationId") Long situationId, @RequestParam("level") Integer level) throws IOException{
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, sopDiagramService.findDiagram(situationId, level)),null,HttpStatus.OK);
    }


}
