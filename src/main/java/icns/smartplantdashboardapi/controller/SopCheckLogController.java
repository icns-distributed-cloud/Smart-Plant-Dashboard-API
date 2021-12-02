package icns.smartplantdashboardapi.controller;

import icns.smartplantdashboardapi.dto.common.CommonResponse;
import icns.smartplantdashboardapi.dto.common.StatusCode;
import icns.smartplantdashboardapi.service.SopCheckLogService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"e-SOP 체크 로그"})
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SopCheckLogController {

    private final SopCheckLogService sopCheckLogService;

    @GetMapping("/e-sop/check-log")
    public ResponseEntity findAll(final Pageable pageable){
        return new ResponseEntity(CommonResponse.res(StatusCode.OK, sopCheckLogService.findAll(pageable)),null, HttpStatus.OK);
    }
}
