package icns.smartplantdashboardapi.controller;

import icns.smartplantdashboardapi.dto.sensorManage.range.SensorRangeRequest;
import icns.smartplantdashboardapi.dto.common.CommonResponse;
import icns.smartplantdashboardapi.dto.common.StatusCode;
import icns.smartplantdashboardapi.service.SensorRangeService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"센서 상태 경계값 관리"})
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SensorRangeController {

    private final SensorRangeService sensorRangeService;

    @GetMapping("/sensor-range")
    public ResponseEntity findByPosId(
            @RequestParam("posId") Long posId,
            final Pageable pageable){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, sensorRangeService.findByPosId(posId, pageable)), null, HttpStatus.OK);
    }

    @PutMapping("/sensor-range/{ssId}")
    public ResponseEntity updateById(
            @PathVariable("ssId") Long ssId,
            @RequestBody SensorRangeRequest sensorRangeRequest){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, sensorRangeService.updateById(ssId, sensorRangeRequest)), null, HttpStatus.OK);
    }

    @GetMapping("/sensor-range/{ssId}")
    public ResponseEntity findById(@PathVariable("ssId") Long ssId){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, sensorRangeService.findBySsId(ssId)), null, HttpStatus.OK);
    }
}
