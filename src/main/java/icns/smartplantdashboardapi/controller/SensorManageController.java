package icns.smartplantdashboardapi.controller;

import icns.smartplantdashboardapi.dto.CommonResponse;
import icns.smartplantdashboardapi.dto.SensorManage.SensorManageRequest;
import icns.smartplantdashboardapi.dto.SensorManage.SensorManageResponse;
import icns.smartplantdashboardapi.dto.sensorPos.SensorPosRequest;
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
        if(posId == null){
            return new CommonResponse<>(true,null,sensorManageService.findAll(pageable));

        }else{
            return new CommonResponse<>(true,null,sensorManageService.findBySensorPosId(posId,pageable));

        }
    }




}