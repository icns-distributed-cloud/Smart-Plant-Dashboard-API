package icns.smartplantdashboardapi.controller;

import icns.smartplantdashboardapi.dto.common.CommonResponse;
import icns.smartplantdashboardapi.dto.common.StatusCode;
import icns.smartplantdashboardapi.dto.sensorData.SensorDataRequest;
import icns.smartplantdashboardapi.service.SensorDataService;
import io.swagger.annotations.Api;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"센서 데이터 관리"})
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SensorDataController {

    private final SensorDataService sensorDataService;

    @PostMapping("/sensor-data")
    public ResponseEntity save(@RequestBody SensorDataRequest sensorDataRequest) throws Exception{
        return new ResponseEntity(CommonResponse.res(StatusCode.CREATED, sensorDataService.save(sensorDataRequest)),null, HttpStatus.CREATED);
    }

    @GetMapping("/sensor-data")
    public ResponseEntity findByPosId(@RequestParam Long posId){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, sensorDataService.findByPosId(posId)), null, HttpStatus.OK);
    }
    @DeleteMapping("/sensor-data/clear")
    public ResponseEntity clear(@RequestParam(value="month", required = true) Long month){
        return new ResponseEntity(CommonResponse.res(StatusCode.NO_CONTENT, sensorDataService.clearOldData(month)), null, HttpStatus.NO_CONTENT);
    }

    @PostMapping("/sensor-data/save-csv")
    public ResponseEntity saveCsv(@RequestParam(value="month",required = true) Long month) throws IOException {
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, sensorDataService.saveCsv(month)), null, HttpStatus.OK);
    }

}
