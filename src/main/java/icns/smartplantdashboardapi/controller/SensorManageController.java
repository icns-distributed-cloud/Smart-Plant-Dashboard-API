package icns.smartplantdashboardapi.controller;

import icns.smartplantdashboardapi.dto.SensorManage.SensorManageRequest;
import icns.smartplantdashboardapi.dto.SensorManage.SensorManageResponse;
import icns.smartplantdashboardapi.dto.common.CommonResponse;
import icns.smartplantdashboardapi.dto.common.StatusCode;
import icns.smartplantdashboardapi.service.SensorManageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SensorManageController {

    private final SensorManageService sensorManageService;

    @PostMapping("/sensor-manage")
    public ResponseEntity save(@RequestBody SensorManageRequest sensorManageRequest){
        return new ResponseEntity(CommonResponse.res(StatusCode.CREATED,sensorManageService.save(sensorManageRequest)), null, HttpStatus.CREATED);
    }

    @GetMapping("/sensor-manage")
    public ResponseEntity findBySensorPosId(@RequestParam(value = "posId",required = false)Long posId, final Pageable pageable){
       return new ResponseEntity(CommonResponse.res(StatusCode.OK,sensorManageService.find(posId, pageable)), null, HttpStatus.OK);

    }

    @GetMapping("/sensor-manage/{ssId}")
    public ResponseEntity findById(@PathVariable Long ssId){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, sensorManageService.findById(ssId)), null, HttpStatus.OK);
    }

    @PutMapping("/sensor-manage/{ssId}")
    public ResponseEntity updateById(
            @PathVariable Long ssId,
            @RequestBody SensorManageRequest sensorManageRequest){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK,sensorManageService.updateById(ssId, sensorManageRequest)), null, HttpStatus.OK);
    }

    @DeleteMapping("/sensor-manage/{posId}")
    public ResponseEntity deleteById(@PathVariable Long ssId){
        return new ResponseEntity(CommonResponse.res(StatusCode.NO_CONTENT,ssId),null,HttpStatus.NO_CONTENT);
    }



}