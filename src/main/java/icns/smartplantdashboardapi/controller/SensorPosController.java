package icns.smartplantdashboardapi.controller;

import icns.smartplantdashboardapi.dto.common.CommonResponse;
import icns.smartplantdashboardapi.dto.sensorPos.SensorPosRequest;
import icns.smartplantdashboardapi.dto.sensorPos.SensorPosResponse;
import icns.smartplantdashboardapi.service.SensorPosService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SensorPosController {

    private final SensorPosService sensorPosService;

    @GetMapping("/sensor-pos")
    public ResponseEntity<CommonResponse<Page<SensorPosResponse>>> findAll(final Pageable pageable){
        return new ResponseEntity<>(new CommonResponse<>(null, sensorPosService.findAll(pageable)), null, HttpStatus.OK);
    }
    @PostMapping("/sensor-pos")
    public ResponseEntity<CommonResponse<Long>> save(@RequestBody SensorPosRequest sensorPosRequest){
        return new ResponseEntity<>(new CommonResponse<>(null, sensorPosService.save(sensorPosRequest)),null,HttpStatus.CREATED);
    }

    @GetMapping("/sensor-pos/{posId}")
    public ResponseEntity<CommonResponse<SensorPosResponse>> findById(@PathVariable("posId") Long posId){
        return new ResponseEntity<>(new CommonResponse<>(null,sensorPosService.findById(posId)),null, HttpStatus.OK);
    }

    @PutMapping("/sensor-pos/{posId}")
    public ResponseEntity<CommonResponse<SensorPosResponse>> updateById(
            @PathVariable("posId") Long posId,
            @RequestBody SensorPosRequest sensorPosRequest){
        return new ResponseEntity<>(new CommonResponse(null, sensorPosService.updateById(posId, sensorPosRequest)),null,HttpStatus.OK);
    }

    @DeleteMapping("/sensor-pos/{posId}")
    public ResponseEntity<CommonResponse<Long>> deleteById(@PathVariable("posId") Long posId){
        return new ResponseEntity<>(new CommonResponse<>(null, sensorPosService.deleteById(posId)),null, HttpStatus.NO_CONTENT);
    }

}
