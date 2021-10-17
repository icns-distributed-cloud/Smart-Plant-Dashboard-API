package icns.smartplantdashboardapi.controller;

import icns.smartplantdashboardapi.dto.common.CommonResponse;
import icns.smartplantdashboardapi.dto.common.StatusCode;
import icns.smartplantdashboardapi.dto.sensorPos.SensorPosRequest;
import icns.smartplantdashboardapi.service.SensorPosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = {"센서 위치 관리"})
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SensorPosController {

    private final SensorPosService sensorPosService;

    @ApiOperation(value="위치 정보 조회", notes="전체 위치 정보를 조회한다.")
    @GetMapping("/sensor-pos")
    public ResponseEntity findAll(final Pageable pageable){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK,  sensorPosService.findAll(pageable)), null, HttpStatus.OK);
    }
    @PostMapping("/sensor-pos")
    public ResponseEntity save(@RequestBody @Valid SensorPosRequest sensorPosRequest){
        return new ResponseEntity(CommonResponse.res(StatusCode.CREATED, sensorPosService.save(sensorPosRequest)),null,HttpStatus.CREATED);
    }

    @ApiOperation(value="특정 위치 정보 조회", notes="특정 위치 정보 조회")
    @GetMapping("/sensor-pos/{posId}")
    public ResponseEntity findById(@PathVariable("posId") Long posId){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, sensorPosService.findById(posId)),null, HttpStatus.OK);
    }

    @PutMapping("/sensor-pos/{posId}")
    public ResponseEntity updateById(
            @PathVariable("posId") Long posId,
            @RequestBody @Valid SensorPosRequest sensorPosRequest){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, sensorPosService.updateById(posId, sensorPosRequest)),null,HttpStatus.OK);
    }

    @DeleteMapping("/sensor-pos/{posId}")
    public ResponseEntity deleteById(@PathVariable("posId") Long posId){
        return new ResponseEntity(CommonResponse.res(StatusCode.NO_CONTENT, sensorPosService.deleteById(posId)),null, HttpStatus.NO_CONTENT);
    }

}
