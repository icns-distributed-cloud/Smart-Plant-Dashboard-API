package icns.smartplantdashboardapi.controller;

import icns.smartplantdashboardapi.dto.CommonResponse;
import icns.smartplantdashboardapi.dto.SensorManage.SensorManageRequest;
import icns.smartplantdashboardapi.dto.SensorManage.SensorManageResponse;
import icns.smartplantdashboardapi.dto.sensorPos.SensorPosRequest;
import icns.smartplantdashboardapi.dto.sensorPos.SensorPosResponse;
import icns.smartplantdashboardapi.service.SensorManageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SensorManageController {

    private final SensorManageService sensorManageService;

    @PostMapping("/sensor-manage")
    public CommonResponse<Long> save(@RequestBody SensorManageRequest sensorManageRequest){
        return new CommonResponse<>(true,null, sensorManageService.save(sensorManageRequest));
    }

    @GetMapping("/sensor-manage")
    public CommonResponse<Page<SensorManageResponse>> findBySensorPosId(@RequestParam(value = "posId",required = false)Long posId, final Pageable pageable){
       return new CommonResponse<>(true,null,sensorManageService.find(posId, pageable));

    }

    @GetMapping("/sensor-manage/{ssId}")
    public CommonResponse<SensorManageResponse> findById(@PathVariable Long ssId){
        return new CommonResponse<>(true, null, sensorManageService.findById(ssId));
    }

    @PutMapping("/sensor-manage/{ssId}")
    public CommonResponse<SensorManageResponse> updateById(@PathVariable Long ssId, @RequestBody SensorManageRequest sensorManageRequest){
        return new CommonResponse<>(true, null, sensorManageService.updateById(ssId, sensorManageRequest));
    }

    @DeleteMapping("/sensor-manage/{posId}")
    public CommonResponse<String> deleteById(@PathVariable Long ssId){
        sensorManageService.deleteById(ssId);
        return new CommonResponse<>(true, null, null );
    }



}