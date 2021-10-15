package icns.smartplantdashboardapi.controller;

import icns.smartplantdashboardapi.dto.CommonResponse;
import icns.smartplantdashboardapi.dto.sensorPos.SensorPosRequest;
import icns.smartplantdashboardapi.dto.sensorPos.SensorPosResponse;
import icns.smartplantdashboardapi.service.SensorPosService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SensorPosController {

    private final SensorPosService sensorPosService;

    // http://localhost:8080/api/sensor-pos?page=5&size=2&sort=createdAt,DESC
    @GetMapping("/sensor-pos")
    public CommonResponse<Page<SensorPosResponse>> findAll(final Pageable pageable){
        return new CommonResponse<Page<SensorPosResponse>>(true,null,sensorPosService.findAll(pageable));
    }
    @PostMapping("/sensor-pos")
    public CommonResponse<Long> save(@RequestBody SensorPosRequest sensorPosRequest){
        return new CommonResponse<>(true,null, sensorPosService.save(sensorPosRequest));
    }

    @GetMapping("/sensor-pos/{posId}")
    public CommonResponse<SensorPosResponse> findById(@PathVariable Long posId){
        return new CommonResponse<>(true, null, sensorPosService.findById(posId));
    }

    @PutMapping("/sensor-pos/{posId}")
    public CommonResponse<SensorPosResponse> updateById(@PathVariable Long posId, @RequestBody SensorPosRequest sensorPosRequest){
        return new CommonResponse<>(true, null, sensorPosService.updateById(posId, sensorPosRequest));
    }

    @DeleteMapping("/sensor-pos/{posId}")
    public CommonResponse<String> deleteById(@PathVariable Long posId){
        sensorPosService.deleteById(posId);
        return new CommonResponse<>(true, null, null );
    }

}
