package icns.smartplantdashboardapi.controller;

import icns.smartplantdashboardapi.dto.common.CommonResponse;
import icns.smartplantdashboardapi.dto.common.StatusCode;
import icns.smartplantdashboardapi.dto.sensorType.SensorTypeRequest;
import icns.smartplantdashboardapi.service.SensorTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SensorTypeController {

    private final SensorTypeService sensorTypeService;

    @GetMapping("/sensor-type")
    public ResponseEntity findAll(final Pageable pageable){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, sensorTypeService.findAll(pageable)),null, HttpStatus.OK);
    }

    @PostMapping("/sensor-type")
    public ResponseEntity save(@RequestBody @Valid SensorTypeRequest sensorTypeRequest){
        return new ResponseEntity(CommonResponse.res(StatusCode.CREATED, sensorTypeService.save(sensorTypeRequest)), null, HttpStatus.CREATED);
    }

    @GetMapping("/sensor-type/{typeId}")
    public ResponseEntity findById(@PathVariable("typeId") Long typeId){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, sensorTypeService.findById(typeId)),null, HttpStatus.OK);
    }
    @PutMapping("/sensor-type/{typeId}")
    public ResponseEntity updateById(
            @PathVariable("typeId") Long typeId,
            @RequestBody @Valid SensorTypeRequest sensorTypeRequest){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, sensorTypeService.updateById(typeId, sensorTypeRequest)),null, HttpStatus.OK);
    }

    @DeleteMapping("/sensor-type/{typeId}")
    public ResponseEntity deleteById(@PathVariable("typeId") Long typeId){
        sensorTypeService.deleteById(typeId);
        return new ResponseEntity(CommonResponse.res(StatusCode.NO_CONTENT, null),null, HttpStatus.NO_CONTENT);
    }
}
