package icns.smartplantdashboardapi.controller;

import icns.smartplantdashboardapi.dto.common.CommonResponse;
import icns.smartplantdashboardapi.dto.common.StatusCode;
import icns.smartplantdashboardapi.dto.sensorType.SensorTypeRequest;
import icns.smartplantdashboardapi.dto.situation.SituationRequest;
import icns.smartplantdashboardapi.service.SituationService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Api(tags = {"상황 관리"})
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SituationController {

    private final SituationService situationService;

    @GetMapping("/situation")
    public ResponseEntity findAll(){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, situationService.findAll()),null, HttpStatus.OK);
    }

    @PostMapping("/situation")
    public ResponseEntity save(@RequestBody SituationRequest situationRequest){
        return new ResponseEntity(CommonResponse.res(StatusCode.CREATED, situationService.save(situationRequest)), null, HttpStatus.CREATED);
    }

    @GetMapping("/situation/{situationId}")
    public ResponseEntity findById(@PathVariable("situationId") Long situationId){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, situationService.find(situationId)),null, HttpStatus.OK);
    }
    @PutMapping("/situation/{situationId}")
    public ResponseEntity updateById(
            @PathVariable("situationId") Long situationId,
            @RequestBody SituationRequest situationRequest){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, situationService.update(situationId, situationRequest)),null, HttpStatus.OK);
    }

    @DeleteMapping("/situation/{situationId}")
    public ResponseEntity deleteById(@PathVariable("situationId") Long situationId){
        return new ResponseEntity(CommonResponse.res(StatusCode.NO_CONTENT, situationService.delete(situationId)),null, HttpStatus.NO_CONTENT);
    }
}
