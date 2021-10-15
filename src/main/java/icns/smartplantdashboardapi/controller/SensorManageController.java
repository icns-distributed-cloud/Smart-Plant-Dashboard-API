package icns.smartplantdashboardapi.controller;

import icns.smartplantdashboardapi.dto.SensorManage.SensorManageRequest;
import icns.smartplantdashboardapi.dto.SensorManage.SensorManageResponse;
import icns.smartplantdashboardapi.dto.common.CommonResponse;
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
    public ResponseEntity<CommonResponse<Long>> save(@RequestBody SensorManageRequest sensorManageRequest){
        return new ResponseEntity<>(new CommonResponse<>(null,sensorManageService.save(sensorManageRequest)), null, HttpStatus.CREATED);
    }

    @GetMapping("/sensor-manage")
    public ResponseEntity<CommonResponse<Page<SensorManageResponse>>> findBySensorPosId(@RequestParam(value = "posId",required = false)Long posId, final Pageable pageable){
       return new ResponseEntity<>(new CommonResponse<>(null,sensorManageService.find(posId, pageable)), null, HttpStatus.OK);

    }

    @GetMapping("/sensor-manage/{ssId}")
    public ResponseEntity<CommonResponse<SensorManageResponse>> findById(@PathVariable Long ssId){
        return new ResponseEntity<>(new CommonResponse<>(null, sensorManageService.findById(ssId)), null, HttpStatus.OK);
    }

    @PutMapping("/sensor-manage/{ssId}")
    public ResponseEntity<CommonResponse<SensorManageResponse>> updateById(
            @PathVariable Long ssId,
            @RequestBody SensorManageRequest sensorManageRequest){
        return new ResponseEntity<>(new CommonResponse<>(null,sensorManageService.updateById(ssId, sensorManageRequest)), null, HttpStatus.OK);
    }

    @DeleteMapping("/sensor-manage/{posId}")
    public ResponseEntity<CommonResponse<Long>> deleteById(@PathVariable Long ssId){
        return new ResponseEntity<>(new CommonResponse<>(null,ssId),null,HttpStatus.OK);
    }



}