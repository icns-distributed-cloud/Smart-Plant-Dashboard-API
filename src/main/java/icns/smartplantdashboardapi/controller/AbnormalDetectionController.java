package icns.smartplantdashboardapi.controller;

import icns.smartplantdashboardapi.dto.abnormalDetection.AbnormalDetectionRequest;
import icns.smartplantdashboardapi.dto.common.CommonResponse;
import icns.smartplantdashboardapi.dto.common.StatusCode;
import icns.smartplantdashboardapi.service.AbnormalDetectionService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"이상 감지 이력 관리"})
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AbnormalDetectionController {
    private final AbnormalDetectionService abnormalDetectionService;

    /*
    @PostMapping("/abnormal-detection")
    public ResponseEntity save(@RequestBody AbnormalDetectionRequest abnormalDetectionRequest){
        return new ResponseEntity(CommonResponse.res(StatusCode.CREATED, abnormalDetectionService.save(abnormalDetectionRequest)),null, HttpStatus.CREATED);
    }

     */

    @GetMapping("/abnormal-detection")
    public ResponseEntity findPage(@RequestParam(value="posId", required = false) Long posId, final Pageable pageable){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, abnormalDetectionService.findPage(posId, pageable)),null, HttpStatus.OK);
    }

    @GetMapping("/abnormal-detection-list")
    public ResponseEntity find(@RequestParam(value="posId", required = false) Long posId){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, abnormalDetectionService.find(posId)),null, HttpStatus.OK);
    }
}
