package icns.smartplantdashboardapi.controller;

import icns.smartplantdashboardapi.dto.common.CommonResponse;
import icns.smartplantdashboardapi.dto.common.StatusCode;
import icns.smartplantdashboardapi.service.AccidentService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"사고 발생"})
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AccidentController {

    private final AccidentService accidentService;

    @PostMapping("/accident/fire/{posId}")
    public ResponseEntity fire(@PathVariable Long posId) {
        return new ResponseEntity(CommonResponse.res(StatusCode.CREATED, accidentService.fire(posId)),null, HttpStatus.CREATED);
    }

    @PostMapping("/accident/smoke/{posId}")
    public ResponseEntity smoke(@PathVariable Long posId) {
        return new ResponseEntity(CommonResponse.res(StatusCode.CREATED, accidentService.smoke(posId)),null, HttpStatus.CREATED);
    }

    @GetMapping("/accident")
    public ResponseEntity findAll() {
        return new ResponseEntity(CommonResponse.res(StatusCode.CREATED, accidentService.findAll()),null, HttpStatus.CREATED);
    }
}
