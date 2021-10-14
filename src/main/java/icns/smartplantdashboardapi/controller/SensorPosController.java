package icns.smartplantdashboardapi.controller;

import icns.smartplantdashboardapi.advice.exception.SensorPosNotFoundException;
import icns.smartplantdashboardapi.domain.SensorPos;
import icns.smartplantdashboardapi.dto.CommonResponse;
import icns.smartplantdashboardapi.dto.sensorPos.SensorPosRequest;
import icns.smartplantdashboardapi.dto.sensorPos.SensorPosResponse;
import icns.smartplantdashboardapi.repository.SensorPosRepository;
import icns.smartplantdashboardapi.service.SensorPosService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SensorPosController {
    private final SensorPosService sensorPosService;


    @GetMapping("/sensor-pos")
    public CommonResponse<List<SensorPosResponse>> findAll(){
        return new CommonResponse<>(true,null,sensorPosService.findAll());
    }
    @PostMapping("/sensor-pos")
    public CommonResponse<Long> save(@RequestBody SensorPosRequest sensorPosRequest){
        return new CommonResponse<>(true,null, sensorPosService.save(sensorPosRequest));
    }
    @GetMapping("/sensor-pos/{posId}")
    public CommonResponse<SensorPosResponse> findById(@PathVariable Long posId){
        return new CommonResponse<>(true, null, sensorPosService.findById(posId));
    }

    @DeleteMapping("/sensor-pos/{posId}")
    public CommonResponse<String> deleteById(@PathVariable Long posId){
        sensorPosService.deleteById(posId);
        return new CommonResponse<>(true, null, null );
    }
}
