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
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@Api(tags = {"센서 위치 관리"})
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SensorPosController {

    private final SensorPosService sensorPosService;

    @GetMapping("/sensor-pos")
    public ResponseEntity findAll(final Pageable pageable){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK,  sensorPosService.findAll(pageable)), null, HttpStatus.OK);
    }
    @PostMapping("/sensor-pos")
    public ResponseEntity save(@RequestParam(value="posName", required = true) String posName, @RequestParam(value="posCode", required = true) String posCode,  @RequestParam(value="posDtl", required = true) String posDtl , @RequestParam(value = "backgroundImg", required = true) MultipartFile backgroundImg) throws IOException {
        return new ResponseEntity(CommonResponse.res(StatusCode.CREATED, sensorPosService.save(posName, posCode, posDtl, backgroundImg)),null,HttpStatus.CREATED);
    }

    @GetMapping("/sensor-pos/{posId}")
    public ResponseEntity findById(@PathVariable("posId") Long posId) throws IOException{
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, sensorPosService.findById(posId)),null, HttpStatus.OK);
    }

    @PutMapping("/sensor-pos/{posId}")
    public ResponseEntity updateById(
            @PathVariable("posId") Long posId,
            @RequestBody @Valid SensorPosRequest sensorPosRequest){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, sensorPosService.updateById(posId, sensorPosRequest)),null,HttpStatus.OK);
    }

    @PostMapping("/sensor-pos/background-img/{posId}")
    public ResponseEntity updateBackgroundImg(
            @PathVariable("posId") Long posId,
            @RequestParam(value = "backgroundImg") MultipartFile backgroundImg) throws IOException {
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, sensorPosService.updateBackgroundImg(posId, backgroundImg)),null,HttpStatus.OK);
    }

    @DeleteMapping("/sensor-pos/{posId}")
    public ResponseEntity deleteById(@PathVariable("posId") Long posId){
        return new ResponseEntity(CommonResponse.res(StatusCode.NO_CONTENT, sensorPosService.deleteById(posId)),null, HttpStatus.NO_CONTENT);
    }

    @PostMapping("/sensor-pos/position/{posId}")
    public ResponseEntity updatePosition(@PathVariable("posId") Long posId, @RequestParam(value="position") String position, @RequestParam(value = "positionImg", required = true) MultipartFile positionImg) throws IOException {
        System.out.println(position);
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, sensorPosService.updatePosition(posId, position, positionImg)),null,HttpStatus.OK);
    }

}
